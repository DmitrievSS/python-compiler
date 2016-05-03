package visitors;

import jdk.internal.org.objectweb.asm.ClassWriter;
import jdk.internal.org.objectweb.asm.Label;
import jdk.internal.org.objectweb.asm.MethodVisitor;
import jdk.internal.org.objectweb.asm.Opcodes;
import nodes.*;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.LinkedList;

/**
 * Created by ssdmitriev on 03.05.16.
 */
public class CodeGenerator implements AstVisitor<Object>, Opcodes {
    private static final String RUNTIME_PACKAGE = "runtime/";
    private class Class {
        public static final String OBJECT = RUNTIME_PACKAGE + "PythonObject";
        public static final String BOOL = RUNTIME_PACKAGE + "PythonBoolean";
        public static final String LIST = RUNTIME_PACKAGE + "PythonList";
        public static final String NUMBER = RUNTIME_PACKAGE + "PythonNumber";
        public static final String FUNCTION = RUNTIME_PACKAGE + "PythonFunction";
        public static final String STRING = RUNTIME_PACKAGE + "PythonString";
        public static final String STANDARD_LIBRARY = RUNTIME_PACKAGE + "StandardLibrary";
    }

    private class Type {
        public static final String OBJECT = "L" + Class.OBJECT + ';';
        public static final String BOOL = "L" + Class.BOOL + ';';
        public static final String STRING = "L" + Class.STRING + ';';
        public static final String NUMBER = "L" + Class.NUMBER + ';';
        public static final String FUNCTION = "L" + Class.FUNCTION + ';';
        public static final String LIST = "L" + Class.LIST + ";";
    }

    public static final String CALL_SIGNATURE = "([" + Type.OBJECT + ")" +  Type.OBJECT;
    public static final String BINARY_SIGNATURE  = "(" + Type.OBJECT + ")" + Type.OBJECT;
    public static final String UNARY_SIGNATURE  = "()" + Type.OBJECT;
    public static final String ARRAY_SIGNATURE = "([" + Type.OBJECT + ")V";
    public static final String PUT_SIGNATURE = "(" + Type.OBJECT +  Type.OBJECT + ")" + Type.OBJECT;

    private String fileName;
    private boolean mainScope;
    private int functionCounter;
    private final LinkedList<FunctionWriter> writers;

    public CodeGenerator(String fileName) {
        this.fileName = fileName;
        mainScope = true;
        functionCounter = 0;
        writers = new LinkedList<>();
    }

    // FunctionWriter
    private class FunctionWriter {
        private ClassWriter cw;
        private MethodVisitor mv;
        private FunctionNode function;
        private int number;
        private String signature;
        private int currentStack;
        private int maxStack;

        public FunctionWriter(FunctionNode function) {
            this.cw = new ClassWriter(0);
            this.function = function;
            this.number = functionCounter;
            StringBuilder signature = new StringBuilder("(");
            for (FunctionWriter fw : writers) {
                signature.append(scopeType(fw.getNumber()));
            }
            signature.append(")V");
            this.signature = signature.toString();
            this.currentStack = 1;
            this.maxStack = 2;
            ++functionCounter;
        }

        public FunctionNode getFunction() {
            return function;
        }

        public String getSignature() {
            return signature;
        }

        public int getNumber() {
            return number;
        }

        // Use this method after visitMethodInsn
        public void stackPop(int times) {
            currentStack -= times;
        }

        public void visitTryCatchBlock(Label tryStart, Label tryEnd,
                                       Label catchStart, String exception) {
            mv.visitTryCatchBlock(tryStart, tryEnd, catchStart, exception);
        }

        public void visitFieldInsn(int opcode, String owner, String name, String desc) {
            if (opcode == GETSTATIC) {
                ++currentStack;
                maxStack = Math.max(maxStack, currentStack);
            } else if (opcode == PUTFIELD) {
                currentStack -= 2;
            } else if (opcode != GETFIELD) {
                System.err.println("Unknown opcode visitFieldInsn");
                System.exit(1);
            }
            mv.visitFieldInsn(opcode, owner, name, desc);
        }

        public void visitInsn(int opcode) {
            if (opcode == DUP) {
                ++currentStack;
                maxStack = Math.max(maxStack, currentStack);
            } else if (opcode == AALOAD || opcode == AASTORE || opcode == POP) {
                --currentStack;
            } else if (opcode != RETURN && opcode != ARETURN) {
                System.err.println("Unknown opcode visitInsn");
                System.exit(1);
            }
            mv.visitInsn(opcode);
        }

        public void visitJumpInsn(int opcode, Label label) {
            mv.visitJumpInsn(opcode, label);
        }

        public void visitLabel(Label label) {
            mv.visitLabel(label);
        }

        public void visitLdcInsn(Object cst) {
            ++currentStack;
            if (cst instanceof Double) {
                ++currentStack;
            }
            maxStack = Math.max(maxStack, currentStack);
            mv.visitLdcInsn(cst);
        }

        public void visitMethodInsn(int opcode, String owner, String name, String desc) {
            mv.visitMethodInsn(opcode, owner, name, desc);
        }

        public void visitTypeInsn(int opcode, String type) {
            ++currentStack;
            maxStack = Math.max(maxStack, currentStack);
            mv.visitTypeInsn(opcode, type);
        }

        public void visitVarInsn(int opcode, int var) {
            if (opcode == ALOAD) {
                ++currentStack;
                maxStack = Math.max(maxStack, currentStack);
            } else if (opcode == ASTORE) {
                --currentStack;
            } else {
                System.err.println("Unknown opcode visitVarInsn");
                System.exit(1);
            }
            mv.visitVarInsn(opcode, var);
        }

        public void handleFunction() {
            generateScopeClass();
            cw = new ClassWriter(0);
            cw.visit(V1_1, ACC_PUBLIC, functionClass(number), null, Class.FUNCTION, null);
            for (FunctionWriter fw : writers) {
                cw.visitField(ACC_PUBLIC, scopeName(fw.getNumber()),
                        scopeType(fw.getNumber()), null, null);
            }

            // Constructor
            mv = cw.visitMethod(ACC_PUBLIC, "<init>", getSignature(), null, null);
            mv.visitVarInsn(ALOAD, 0);
            mv.visitLdcInsn(function.getValue());
            mv.visitMethodInsn(INVOKESPECIAL, Class.FUNCTION,
                    "<init>", "(Ljava/lang/String;)V");
            int i = 1;
            for (FunctionWriter fw : writers) {
                if (!functionClass(fw.getNumber()).equals(functionClass(number))) {
                    mv.visitVarInsn(ALOAD, 0);
                    mv.visitVarInsn(ALOAD, i);
                    ++i;
                    mv.visitFieldInsn(PUTFIELD, functionClass(number),
                            scopeName(fw.getNumber()), scopeType(fw.getNumber()));
                }
            }
            mv.visitInsn(RETURN);
            mv.visitMaxs(2, writers.size());
            mv.visitEnd();

            // call
            mv = cw.visitMethod(ACC_PUBLIC, "call", CALL_SIGNATURE, null, null);
            visitVarInsn(ALOAD, 0);
            visitTypeInsn(NEW, scopeClass(number));
            visitInsn(DUP);
            visitMethodInsn(INVOKESPECIAL, scopeClass(number), "<init>", "()V");
            stackPop(1);
            visitFieldInsn(PUTFIELD, functionClass(number),
                    scopeName(number), scopeType(number));

            if (function.getParameters().size() > 0) {
                Label tryStart = new Label();
                Label tryEnd = new Label();
                Label catchStart = new Label();
                Label catchEnd = new Label();
                visitTryCatchBlock(tryStart, tryEnd, catchStart, "java/lang/Exception");
                visitLabel(tryStart);
                i = 0;
                for (FunctionParameterNode param : function.getParameters()) {
                    visitVarInsn(ALOAD, 0);
                    visitFieldInsn(GETFIELD, functionClass(number),
                            scopeName(number), scopeType(number));
                    visitVarInsn(ALOAD, 1);
                    visitLdcInsn(i);
                    ++i;
                    visitInsn(AALOAD);
                    visitFieldInsn(PUTFIELD, scopeClass(number), param.getName(), Type.OBJECT);
                }
                visitLabel(tryEnd);
                visitJumpInsn(GOTO, catchEnd);
                visitLabel(catchStart);
                visitVarInsn(ASTORE, 1);
                visitLabel(catchEnd);
            }

            for (BlockStatNode stat : this.getFunction().getBody()) {
                stat.accept(CodeGenerator.this);
            }
            visitFieldInsn(GETSTATIC, Class.UNDEF, "UNDEF", Type.UNDEF);
            visitInsn(ARETURN);
            mv.visitMaxs(maxStack, 2);
            mv.visitEnd();

            cw.visitEnd();

            writeFile(cw, functionClass(number));
        }

        private void generateScopeClass() {
            ClassWriter cw = new ClassWriter(0);
            cw.visit(V1_1, ACC_PUBLIC, scopeClass(number), null, "java/lang/Object", null);

            if (mainScope) {
                for (String f : LIBRARY) {
                    function.getVariables().add(f);
                }
            }

            for (String var : function.getVariables()) {
                cw.visitField(ACC_PUBLIC, var, Type.OBJECT, null, null);
            }

            MethodVisitor mv = cw.visitMethod(ACC_PUBLIC, "<init>", "()V", null, null);
            mv.visitVarInsn(ALOAD, 0);
            mv.visitMethodInsn(INVOKESPECIAL, "java/lang/Object", "<init>", "()V");
            for (String var : function.getVariables()) {
                mv.visitVarInsn(ALOAD, 0);
                mv.visitFieldInsn(GETSTATIC, Class.UNDEF, "UNDEF", Type.UNDEF);
                mv.visitFieldInsn(PUTFIELD, scopeClass(number), var, Type.OBJECT);
            }

            // Initializing library functions
            if (mainScope) {
                mainScope = false;

                mv.visitVarInsn(ALOAD, 0);
                mv.visitFieldInsn(GETSTATIC, Class.STANDARD_LIBRARY, "CONSOLE", Type.ARRAY);
                mv.visitFieldInsn(PUTFIELD, scopeClass(number), CONSOLE_LIBRARY, Type.OBJECT);

                mv.visitVarInsn(ALOAD, 0);
                mv.visitFieldInsn(GETSTATIC, Class.STANDARD_LIBRARY, "MATH", Type.ARRAY);
                mv.visitFieldInsn(PUTFIELD, scopeClass(number), MATH_LIBRARY, Type.OBJECT);
            }

            mv.visitInsn(RETURN);
            mv.visitMaxs(2, 1);
            mv.visitEnd();

            cw.visitEnd();

            writeFile(cw, scopeClass(number));
        }
    }

    private String functionClass(int number) {
        return fileName + "$Function" + number;
    }

    private String scopeClass(int number) {
        return fileName + "$Scope" + number;
    }

    private String scopeType(int number) {
        return "L" + scopeClass(number) + ";";
    }

    private String scopeName(int number) {
        return "scope" + number;
    }

    private void writeFile(ClassWriter cw, String className) {
        try {
            byte[] code = cw.toByteArray();
            FileOutputStream fos = new FileOutputStream(className + ".class");
            fos.write(code);
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private int findScopeNumber(VarNode var) {
        for (FunctionWriter fw : writers) {
            for (String v : fw.getFunction().getVariables()) {
                if (v.equals(var.getName())) {
                    return fw.getNumber();
                }
            }
        }
        return -1;
    }

    @Override
    public Object visit(AddNode add) {
        return null;
    }

    @Override
    public Object visit(AndExpressionNode and) {
        return null;
    }

    @Override
    public Object visit(ListNode array) {
        return null;
    }

    @Override
    public Object visit(AssignmentNode assign) {
        return null;
    }

    @Override
    public Object visit(BlockStatNode block) {
        return null;
    }

    @Override
    public Object visit(BoolNode bool) {
        return null;
    }

    @Override
    public Object visit(DivNode div) {
        return null;
    }

    @Override
    public Object visit(EqNode eq) {
        return null;
    }

    @Override
    public Object visit(ExpressionStatNode exprStat) {
        return null;
    }

    @Override
    public Object visit(FunctionCallNode functionCall) {
        return null;
    }

    @Override
    public Object visit(FunctionNode function) {
        return null;
    }

    @Override
    public Object visit(FunctionParameterNode functionParam) {
        return null;
    }

    @Override
    public Object visit(GetFieldNode getIndex) {
        return null;
    }

    @Override
    public Object visit(GeNode ge) {
        return null;
    }

    @Override
    public Object visit(GtNode gt) {
        return null;
    }

    @Override
    public Object visit(IfElseStatNode ifElse) {
        return null;
    }

    @Override
    public Object visit(LeNode le) {
        return null;
    }

    @Override
    public Object visit(LtNode lt) {
        return null;
    }

    @Override
    public Object visit(ModNode mod) {
        return null;
    }

    @Override
    public Object visit(MulNode mul) {
        return null;
    }

    @Override
    public Object visit(NegNode neg) {
        return null;
    }

    @Override
    public Object visit(NotEqNode ne) {
        return null;
    }

    @Override
    public Object visit(NotNode not) {
        return null;
    }

    @Override
    public Object visit(NumberNode number) {
        return null;
    }

    @Override
    public Object visit(OrExpressionNode or) {
        return null;
    }

    @Override
    public Object visit(PlusNode plus) {
        return null;
    }

    @Override
    public Object visit(ProgrammNode program) {
        return null;
    }

    @Override
    public Object visit(PutFieldNode putIndex) {
        return null;
    }

    @Override
    public Object visit(ReturnStatNode returnStat) {
        return null;
    }

    @Override
    public Object visit(StringNode string) {
        return null;
    }

    @Override
    public Object visit(SubNode sub) {
        return null;
    }

    @Override
    public Object visit(VarNode var) {
        return null;
    }

    @Override
    public Object visit(WhileStatNode whileStat) {
        return null;
    }

    @Override
    public Object visit(WithConditionStatNode doWhile) {
        return null;
    }
}
