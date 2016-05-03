package visitors;

import nodes.*;

/**
 * Created by ssdmitriev on 03.05.16.
 */
public interface AstVisitor<T> {
    public static final String CONSOLE_LIBRARY = "_Console";
    public static final String MATH_LIBRARY = "_Math";
    public static final String[] LIBRARY = {CONSOLE_LIBRARY, MATH_LIBRARY};
    T visit(AddNode add);

    T visit(AndExpressionNode and);

    T visit(ListNode array);

    T visit(AssignmentNode assign);

    T visit(BlockStatNode block);

    T visit(BoolNode bool);

    T visit(DivNode div);

    T visit(EqNode eq);

    T visit(ExpressionStatNode exprStat);

    T visit(FunctionCallNode functionCall);

    T visit(FunctionNode function);

    T visit(FunctionParameterNode functionParam);

    T visit (GetFieldNode getIndex);

    T visit(GeNode ge);

    T visit(GtNode gt);

    T visit(IfElseStatNode ifElse);

    T visit(LeNode le);

    T visit(LtNode lt);

    T visit(ModNode mod);

    T visit(MulNode mul);

    T visit(NegNode neg);

    T visit(NotEqNode ne);

    T visit(NotNode not);

    T visit(NumberNode number);

    T visit(OrExpressionNode or);

    T visit(PlusNode plus);

    T visit(ProgrammNode program);

    T visit(PutFieldNode putIndex);

    T visit(ReturnStatNode returnStat);


    T visit(StringNode string);

    T visit(SubNode sub);

    T visit(VarNode var);

    T visit(WhileStatNode whileStat);

    T visit(WithConditionStatNode doWhile);
}

