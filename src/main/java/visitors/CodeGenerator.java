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
        public static final String UNDEF = RUNTIME_PACKAGE + "PythonUndef";
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
        public static final String UNDEF = "L" + Class.UNDEF+ ';';
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

            for (BaseStatNode stat : this.getFunction().getBody()) {
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
                mv.visitFieldInsn(GETSTATIC, Class.STANDARD_LIBRARY, "CONSOLE", Type.LIST);
                mv.visitFieldInsn(PUTFIELD, scopeClass(number), CONSOLE_LIBRARY, Type.OBJECT);

//                mv.visitVarInsn(ALOAD, 0);
//                mv.visitFieldInsn(GETSTATIC, Class.STANDARD_LIBRARY, "MATH", Type.LIST);
//                mv.visitFieldInsn(PUTFIELD, scopeClass(number), MATH_LIBRARY, Type.OBJECT);
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
        add.getLeftNode().accept(this);
        add.getRightNode().accept(this);
        writers.peek().visitMethodInsn(
                INVOKEVIRTUAL, Class.OBJECT, "add", BINARY_SIGNATURE);
        writers.peek().stackPop(1);
        return null;
    }

    @Override
    public Object visit(AndExpressionNode and) {
        and.getLeftNode().accept(this);
        and.getRightNode().accept(this);
        writers.peek().visitMethodInsn(
                INVOKEVIRTUAL, Class.OBJECT, "and", BINARY_SIGNATURE);
        writers.peek().stackPop(1);
        return null;
    }

    @Override
    public Object visit(ListNode list) {
        writers.peek().visitTypeInsn(NEW, Class.LIST);
        writers.peek().visitInsn(DUP);
        writers.peek().visitLdcInsn(list.getElements().size());
        writers.peek().visitTypeInsn(ANEWARRAY, Class.OBJECT);
        int i = 0;
        for (ExpressionStatNode elem : list.getElements()) {
            writers.peek().visitInsn(DUP);
            writers.peek().visitLdcInsn(i);
            ++i;
            elem.accept(this);
            writers.peek().visitInsn(AASTORE);
        }
        writers.peek().visitMethodInsn(
                INVOKESPECIAL, Class.LIST, "<init>", ARRAY_SIGNATURE);
        writers.peek().stackPop(list.getElements().size() + 1);
        return null;
    }

    @Override
    public Object visit(AssignmentNode assign) {
        int number = findScopeNumber(assign.getVariable());
        FunctionWriter w = writers.peek();

        w.visitVarInsn(ALOAD, 0);
        w.visitFieldInsn(GETFIELD, functionClass(w.getNumber()),
                scopeName(number), scopeType(number));
        assign.getExpression().accept(this);
        w.visitFieldInsn(PUTFIELD, scopeClass(number),
                assign.getVariable().getName(), Type.OBJECT);

        w.visitVarInsn(ALOAD, 0);
        w.visitFieldInsn(GETFIELD, functionClass(w.getNumber()),
                scopeName(number), scopeType(number));
        w.visitFieldInsn(GETFIELD, scopeClass(number),
                assign.getVariable().getName(), Type.OBJECT);
        return null;
    }

    @Override
    public Object visit(BlockStatNode block) {
        for (BaseStatNode stat: block.getBody()) {
            stat.accept(this);
        }
        return null;
    }

    @Override
    public Object visit(BoolNode bool) {
        writers.peek().visitFieldInsn(GETSTATIC, Class.BOOL,
                bool.getValue().toUpperCase(), Type.BOOL);
        return null;
    }

    @Override
    public Object visit(DivNode div) {
        return null;
    }

    @Override
    public Object visit(EqNode eq) {
        eq.getLeftNode().accept(this);
        eq.getRightNode().accept(this);
        writers.peek().visitMethodInsn(
                INVOKEVIRTUAL, Class.OBJECT, "eq", BINARY_SIGNATURE);
        writers.peek().stackPop(1);
        return null;
    }

    @Override
    public Object visit(ExpressionStatNode exprStat) {
        exprStat.getExpr().accept(this);
        writers.peek().visitInsn(POP);
        return null;
    }

    @Override
    public Object visit(FunctionCallNode functionCall) {
        functionCall.getFunction().accept(this);
        writers.peek().visitLdcInsn(functionCall.getArguments().size());
        writers.peek().visitTypeInsn(ANEWARRAY, Class.OBJECT);
        int i = 0;
        for (ExpressionStatNode arg : functionCall.getArguments()) {
            writers.peek().visitInsn(DUP);
            writers.peek().visitLdcInsn(i);
            ++i;
            arg.accept(this);
            writers.peek().visitInsn(AASTORE);
        }
        writers.peek().visitMethodInsn(
                INVOKEVIRTUAL, Class.OBJECT, "call", CALL_SIGNATURE);
        writers.peek().stackPop(functionCall.getArguments().size());
        return null;
    }

    @Override
    public Object visit(FunctionNode function) {
        FunctionWriter fw = new FunctionWriter(function);
        writers.push(fw);
        writers.peek().handleFunction();
        writers.pop();
        FunctionWriter w = writers.peek();
        w.visitTypeInsn(NEW, functionClass(fw.getNumber()));
        w.visitInsn(DUP);
        for (FunctionWriter writer : writers) {
            w.visitVarInsn(ALOAD, 0);
            w.visitFieldInsn(GETFIELD, functionClass(w.getNumber()),
                    scopeName(writer.getNumber()), scopeType(writer.getNumber()));
        }
        w.visitMethodInsn(INVOKESPECIAL,
                functionClass(fw.getNumber()), "<init>", fw.getSignature());
        writers.peek().stackPop(writers.size() + 1);

        return null;
    }

    @Override
    public Object visit(FunctionParameterNode functionParam) {
        return null;
    }

    @Override
    public Object visit(GetFieldNode getIndex) {
        getIndex.getVariable().accept(this);
        getIndex.getIndex().accept(this);
        writers.peek().visitMethodInsn(INVOKEVIRTUAL, Class.OBJECT, "get", BINARY_SIGNATURE);
        writers.peek().stackPop(1);
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
        Label elseBlock = new Label();
        Label end = new Label();
        ifElse.getCondition().accept(this);
        writers.peek().visitMethodInsn(
                INVOKEVIRTUAL, Class.OBJECT, "toInt", "()I"); // 0(false) or 1(true)
        writers.peek().stackPop(0);
        writers.peek().visitJumpInsn(IFEQ, elseBlock); // if x == 0
        ifElse.getIfBranch().accept(this);
        writers.peek().visitJumpInsn(GOTO, end);
        writers.peek().visitLabel(elseBlock);
        if (ifElse.getElseBranch() != null) {
            ifElse.getElseBranch().accept(this);
        }
        writers.peek().visitLabel(end);
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
        ne.getLeftNode().accept(this);
        ne.getRightNode().accept(this);
        writers.peek().visitMethodInsn(
                INVOKEVIRTUAL, Class.OBJECT, "ne", BINARY_SIGNATURE);
        writers.peek().stackPop(1);
        return null;
    }

    @Override
    public Object visit(NotNode not) {
        not.getExpression().accept(this);
        writers.peek().visitMethodInsn(
                INVOKEVIRTUAL, Class.OBJECT, "not", UNARY_SIGNATURE);
        writers.peek().stackPop(0);
        return null;
    }

    @Override
    public Object visit(NumberNode number) {
        if (number.getValue().equals("NaN")) {
            writers.peek().visitFieldInsn(
                    GETSTATIC, Class.NUMBER, "NAN", Type.NUMBER);
        } else if (number.getValue().equals("0.0")) {
            writers.peek().visitFieldInsn(
                    GETSTATIC, Class.NUMBER, "ZERO", Type.NUMBER);
        } else if (number.getValue().equals("1.0")) {
            writers.peek().visitFieldInsn(
                    GETSTATIC, Class.NUMBER, "ONE", Type.NUMBER);
        } else if (number.getValue().equals("Infinity")) {
            writers.peek().visitFieldInsn(
                    GETSTATIC, Class.NUMBER, "POS_INFINITY", Type.NUMBER);
        } else {
            writers.peek().visitTypeInsn(NEW, Class.NUMBER);
            writers.peek().visitInsn(DUP);
            writers.peek().visitLdcInsn(Double.parseDouble(number.getValue()));
            writers.peek().visitMethodInsn(INVOKESPECIAL,
                    Class.NUMBER, "<init>", "(D)V");
            writers.peek().stackPop(3);
        }
        return null;
    }

    @Override
    public Object visit(OrExpressionNode or) {
        or.getLeftNode().accept(this);
        or.getRightNode().accept(this);
        writers.peek().visitMethodInsn(
                INVOKEVIRTUAL, Class.OBJECT, "or", BINARY_SIGNATURE);
        writers.peek().stackPop(1);
        return null;
    }

    @Override
    public Object visit(PlusNode plus) {
        plus.getExpression().accept(this);
        writers.peek().visitMethodInsn(
                INVOKEVIRTUAL, Class.OBJECT, "plus", UNARY_SIGNATURE);
        writers.peek().stackPop(0);
        return null;
    }

    @Override
    public Object visit(ProgrammNode program) {
        ClassWriter cw = new ClassWriter(0);
        cw.visit(V1_1, ACC_PUBLIC, fileName, null, "java/lang/Object", null);

        // Constructor
        MethodVisitor mv = cw.visitMethod(ACC_PUBLIC, "<init>", "()V", null, null);
        mv.visitVarInsn(ALOAD, 0);
        mv.visitMethodInsn(INVOKESPECIAL, "java/lang/Object", "<init>", "()V");
        // initialization
        mv.visitInsn(RETURN);
        mv.visitMaxs(1, 1);
        mv.visitEnd();

        mv = cw.visitMethod(ACC_PUBLIC + ACC_STATIC, "main",
                "([Ljava/lang/String;)V", null, null);

        FunctionWriter fw = new FunctionWriter(program);
        writers.push(fw);
        writers.peek().handleFunction();
        writers.pop();

        mv.visitTypeInsn(NEW, functionClass(fw.getNumber()));
        mv.visitInsn(DUP);
        mv.visitMethodInsn(INVOKESPECIAL,
                functionClass(fw.getNumber()), "<init>", fw.getSignature());
        mv.visitLdcInsn(0);
        mv.visitTypeInsn(ANEWARRAY, Class.OBJECT);
        mv.visitMethodInsn(INVOKEVIRTUAL,
                functionClass(fw.getNumber()), "call", CALL_SIGNATURE);
        mv.visitInsn(POP);

        mv.visitInsn(RETURN);
        mv.visitMaxs(2, 1);
        mv.visitEnd();

        writeFile(cw, fileName);
        return null;
    }

    @Override
    public Object visit(PutFieldNode putIndex) {
        FunctionWriter w = writers.peek();
        putIndex.getVariable().accept(this);
        putIndex.getIndex().accept(this);
        putIndex.getExpr().accept(this);
        w.visitMethodInsn(INVOKEVIRTUAL, Class.OBJECT, "put", PUT_SIGNATURE);
        w.stackPop(2);
        return null;
    }

    @Override
    public Object visit(ReturnStatNode returnStat) {
        if (returnStat.getValue() != null) {
            returnStat.getValue().accept(this);
        } else {
            writers.peek().visitFieldInsn(
                    GETSTATIC, Class.UNDEF, "UNDEF", Type.UNDEF);
        }
        writers.peek().visitInsn(ARETURN);
        return null;
    }

    @Override
    public Object visit(StringNode string) {
        if (string.getValue().equals("")) {
            writers.peek().visitFieldInsn(
                    GETSTATIC, Class.STRING, "EMPTY", Type.STRING);
        } else {
            writers.peek().visitTypeInsn(NEW, Class.STRING);
            writers.peek().visitInsn(DUP);
            writers.peek().visitLdcInsn(string.getValue());
            writers.peek().visitMethodInsn(INVOKESPECIAL,
                    Class.STRING, "<init>", "(Ljava/lang/String;)V");
            writers.peek().stackPop(2);
        }
        return null;
    }

    @Override
    public Object visit(SubNode sub) {
        sub.getLeftNode().accept(this);
        sub.getRightNode().accept(this);
        writers.peek().visitMethodInsn(
                INVOKEVIRTUAL, Class.OBJECT, "sub", BINARY_SIGNATURE);
        writers.peek().stackPop(1);
        return null;
    }

    @Override
    public Object visit(VarNode var) {
        int number = findScopeNumber(var);
        FunctionWriter w = writers.peek();
        w.visitVarInsn(ALOAD, 0);
        w.visitFieldInsn(GETFIELD,functionClass(w.getNumber()),
                scopeName(number), scopeType(number));
        w.visitFieldInsn(GETFIELD, scopeClass(number), var.getName(), Type.OBJECT);
        return null;
    }

    @Override
    public Object visit(WhileStatNode whileStat) {
        Label loopStart = new Label();
        Label loopEnd = new Label();
        writers.peek().visitLabel(loopStart);
        whileStat.getCondition().accept(this);
        writers.peek().visitMethodInsn(
                INVOKEVIRTUAL, Class.OBJECT, "toInt", "()I"); // 0(false) or 1(true)
        writers.peek().stackPop(0);
        writers.peek().visitJumpInsn(IFEQ, loopEnd); // if x == false
        whileStat.getStat().accept(this);
        writers.peek().visitInsn(POP);
        writers.peek().visitJumpInsn(GOTO, loopStart);
        writers.peek().visitLabel(loopEnd);
        return null;
    }

    @Override
    public Object visit(WithConditionStatNode doWhile) {
        return null;
    }

    @Override
    public Object visit(BaseStatNode doWhile) {
        return null;
    }
}
