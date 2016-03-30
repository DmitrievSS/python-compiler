import Nodes.*;

/**
 * Created by ssdmitriev on 29.03.16.
 */
public class AstBuilder extends EasyPythonGrammarBaseVisitor {

    @Override
    public BaseStatNode visitProgram(EasyPythonGrammarParser.ProgramContext ctx) {
        BlockStatNode block = new BlockStatNode();
        block.setPosition(ctx.start.getLine(), ctx.start.getCharPositionInLine());
        for (EasyPythonGrammarParser.StatContext stat : ctx.stat()) {
            block.addStatement((StatStatNode) visit(stat));
        }
        return block;
    }

    @Override
    public Object visitStat(EasyPythonGrammarParser.StatContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Object visitBlockStat(EasyPythonGrammarParser.BlockStatContext ctx) {
        BlockStatNode block = new BlockStatNode();
        block.setPosition(ctx.start.getLine(), ctx.start.getCharPositionInLine());
        for (EasyPythonGrammarParser.StatContext stat : ctx.stat()) {
            block.addStatement((StatStatNode) visit(stat));
        }
        return block;
    }

    @Override
    public BaseStatNode visitIfStat(EasyPythonGrammarParser.IfStatContext ctx) {
        IfElseStatNode ifElseNode = new IfElseStatNode();
        ifElseNode.setPosition(ctx.start.getLine(), ctx.start.getCharPositionInLine());
        ifElseNode.setCondition((ExpressionStatNode) visit(ctx.expr()));
        ifElseNode.setIfStat((StatStatNode) visit(ctx.stat(0)));
        if (ctx.stat(1) != null) {
            ifElseNode.setElseStat((StatStatNode) visit(ctx.stat(1)));
        }
        return ifElseNode;
    }

    @Override
    public BaseStatNode visitWhileStat(EasyPythonGrammarParser.WhileStatContext ctx) {
        WhileStatNode whileNode = new WhileStatNode();
        whileNode.setPosition(ctx.start.getLine(), ctx.start.getCharPositionInLine());
        whileNode.setCondition((ExpressionStatNode) visit(ctx.expr()));
        whileNode.setStat((StatStatNode) visit(ctx.stat()));
        whileNode.setPosition(ctx.start.getLine(), ctx.start.getCharPositionInLine());
        return whileNode;
    }

    @Override
    public Object visitReturnStat(EasyPythonGrammarParser.ReturnStatContext ctx) {
        ReturnStatNode returnNode = new ReturnStatNode();
        returnNode.setPosition(ctx.start.getLine(), ctx.start.getCharPositionInLine());
        if (ctx.expr() != null) {
            returnNode.setValue((ExpressionStatNode) visit(ctx.expr()));
        }
        return returnNode;
    }

    @Override
    public Object visitGetField(EasyPythonGrammarParser.GetFieldContext ctx) {
        return super.visitGetField(ctx);
    }

    @Override
    public Object visitOr(EasyPythonGrammarParser.OrContext ctx) {
        return super.visitOr(ctx);
    }

    @Override
    public Object visitAddSub(EasyPythonGrammarParser.AddSubContext ctx) {
        return super.visitAddSub(ctx);
    }

    @Override
    public Object visitParens(EasyPythonGrammarParser.ParensContext ctx) {
        return super.visitParens(ctx);
    }

    @Override
    public Object visitVar(EasyPythonGrammarParser.VarContext ctx) {
        return super.visitVar(ctx);
    }

    @Override
    public Object visitConstant(EasyPythonGrammarParser.ConstantContext ctx) {
        return super.visitConstant(ctx);
    }

    @Override
    public Object visitCmp(EasyPythonGrammarParser.CmpContext ctx) {
        return super.visitCmp(ctx);
    }

    @Override
    public Object visitEq(EasyPythonGrammarParser.EqContext ctx) {
        return super.visitEq(ctx);
    }

    @Override
    public Object visitUnaryExpr(EasyPythonGrammarParser.UnaryExprContext ctx) {
        return super.visitUnaryExpr(ctx);
    }

    @Override
    public Object visitArray(EasyPythonGrammarParser.ArrayContext ctx) {
        return super.visitArray(ctx);
    }

    @Override
    public Object visitFunction(EasyPythonGrammarParser.FunctionContext ctx) {
        return super.visitFunction(ctx);
    }

    @Override
    public Object visitMulDivMod(EasyPythonGrammarParser.MulDivModContext ctx) {
        return super.visitMulDivMod(ctx);
    }

    @Override
    public Object visitAnd(EasyPythonGrammarParser.AndContext ctx) {
        return super.visitAnd(ctx);
    }

    @Override
    public Object visitAssign(EasyPythonGrammarParser.AssignContext ctx) {
        return super.visitAssign(ctx);
    }

    @Override
    public Object visitFunctionCall(EasyPythonGrammarParser.FunctionCallContext ctx) {
        return super.visitFunctionCall(ctx);
    }

    @Override
    public Object visitPutField(EasyPythonGrammarParser.PutFieldContext ctx) {
        return super.visitPutField(ctx);
    }

    @Override
    public BaseStatNode visitExpr(EasyPythonGrammarParser.ExprContext ctx) {
        ExpressionStatNode expressionNode = new ExpressionStatNode();
        expressionNode.setPosition(ctx.start.getLine(), ctx.start.getCharPositionInLine());
        return expressionNode;
    }

    @Override
    public Object visitFunctionArgs(EasyPythonGrammarParser.FunctionArgsContext ctx) {
        return super.visitFunctionArgs(ctx);
    }

    @Override
    public Object visitFunctionParams(EasyPythonGrammarParser.FunctionParamsContext ctx) {
        return super.visitFunctionParams(ctx);
    }

    @Override
    public Object visitIndex(EasyPythonGrammarParser.IndexContext ctx) {
        return super.visitIndex(ctx);
    }

    @Override
    public Object visitField(EasyPythonGrammarParser.FieldContext ctx) {
        return super.visitField(ctx);
    }
}
