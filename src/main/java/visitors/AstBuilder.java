package visitors;

import antlr_dir.EasyPythonGrammarBaseVisitor;
import antlr_dir.EasyPythonGrammarParser;
import nodes.*;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.Stack;

/**
 * Created by ssdmitriev on 29.03.16.
 */
public class AstBuilder extends EasyPythonGrammarBaseVisitor {
    private Stack<FunctionNode> scopes;

    @Override
    public BaseStatNode visitProgram(EasyPythonGrammarParser.ProgramContext ctx) {
        FunctionNode block = new FunctionNode();
        scopes.push(block);
        block.setPosition(ctx.start.getLine(), ctx.start.getCharPositionInLine());
        for (EasyPythonGrammarParser.StatContext stat : ctx.stat()) {
            block.addStatement((BlockStatNode) visit(stat));
        }
        scopes.pop();
        return block;
    }

    @Override
    public Object visitStat(EasyPythonGrammarParser.StatContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public BaseStatNode visitBlockStat(EasyPythonGrammarParser.BlockStatContext ctx) {
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
    public BaseStatNode visitReturnStat(EasyPythonGrammarParser.ReturnStatContext ctx) {
        ReturnStatNode returnNode = new ReturnStatNode();
        returnNode.setPosition(ctx.start.getLine(), ctx.start.getCharPositionInLine());
        if (ctx.expr() != null) {
            returnNode.setValue((ExpressionStatNode) visit(ctx.expr()));
        }
        return returnNode;
    }

    @Override
    public BaseStatNode visitGetField(EasyPythonGrammarParser.GetFieldContext ctx) {
        GetFieldNode getFieldNode = new GetFieldNode();
        getFieldNode.setPosition(ctx.start.getLine(), ctx.start.getCharPositionInLine());
        getFieldNode.setVariable((ExpressionStatNode) visit(ctx.expr()));


        if (ctx.index() != null) {
            getFieldNode.setIndex((ExpressionStatNode) visit(ctx.index().expr()));
        } else if (ctx.field() != null) {
            StringNode str = new StringNode();
            str.setValue("'" + ctx.field().ID().getText() + "'");
            getFieldNode.setIndex(str);
        }
        return getFieldNode;
    }

    @Override
    public BaseStatNode visitOr(EasyPythonGrammarParser.OrContext ctx) {
        OrExpressionNode expr = new OrExpressionNode();
        expr.setPosition(ctx.start.getLine(), ctx.start.getCharPositionInLine());
        expr.setLeftNode((ExpressionStatNode) visit(ctx.expr(0)));
        expr.setLeftNode((ExpressionStatNode) visit(ctx.expr(1)));
        return expr;
    }

    @Override
    public BaseStatNode visitAddSub(EasyPythonGrammarParser.AddSubContext ctx) {
        BinaryExpressionNode binary;
        if (ctx.op.getType() == EasyPythonGrammarParser.ADD) {
            binary = new AddNode();
        } else {
            binary = new SubNode();
        }
        binary.setPosition(ctx.start.getLine(), ctx.start.getCharPositionInLine());
        return binary;
    }


    @Override
    public BaseStatNode visitVar(EasyPythonGrammarParser.VarContext ctx) {
        AssignmentNode assign = new AssignmentNode();
        assign.setPosition(ctx.start.getLine(), ctx.start.getCharPositionInLine());
        VarNode var = new VarNode();
        var.setPosition(ctx.start.getLine(), ctx.start.getCharPositionInLine());
        var.setName(ctx.ID().getText());
        return var;
    }

    @Override
    public Object visitConstant(EasyPythonGrammarParser.ConstantContext ctx) {
        ConstantNode constant = null;
        if (ctx.NUM() != null) {
            constant = new NumberNode();
            constant.setValue(ctx.NUM().getText());
        } else if (ctx.STR() != null) {
            constant = new StringNode();
            constant.setValue(ctx.STR().getText());
        } else if (ctx.BOOL() != null) {
            constant = new BoolNode();
            constant.setValue(ctx.BOOL().getText());
        }
        constant.setPosition(ctx.start.getLine(), ctx.start.getCharPositionInLine());
        return constant;
    }

    @Override
    public Object visitCmp(EasyPythonGrammarParser.CmpContext ctx) {
        BinaryExpressionNode binary;
        if (ctx.op.getType() == EasyPythonGrammarParser.LESS_THAN) {
            binary = new LtNode();
        } else if (ctx.op.getType() == EasyPythonGrammarParser.LT_EQ) {
            binary = new LeNode();
        } else if (ctx.op.getType() == EasyPythonGrammarParser.GREATER_THAN) {
            binary = new GtNode();
        } else {
            binary = new GeNode();
        }
        binary.setPosition(ctx.start.getLine(), ctx.start.getCharPositionInLine());
        binary.setLeftNode((ExpressionStatNode) visit(ctx.expr(0)));
        binary.setRightNode((ExpressionStatNode) visit(ctx.expr(1)));
        return binary;
    }

    @Override
    public Object visitEq(EasyPythonGrammarParser.EqContext ctx) {
        BinaryExpressionNode binary;
        if (ctx.op.getType() == EasyPythonGrammarParser.EQUALS) {
            binary = new EqNode();
        } else {
            binary = new NotEqNode();
        }
        binary.setPosition(ctx.start.getLine(), ctx.start.getCharPositionInLine());
        binary.setLeftNode((ExpressionStatNode) visit(ctx.expr(0)));
        binary.setRightNode((ExpressionStatNode) visit(ctx.expr(1)));
        return binary;
    }

    @Override
    public Object visitUnaryExpr(EasyPythonGrammarParser.UnaryExprContext ctx) {
        UnaryExpressionNode unary;
        if (ctx.op.getType() == EasyPythonGrammarParser.NOT) {
            unary = new NotNode();
        } else if (ctx.op.getType() == EasyPythonGrammarParser.MINUS) {
            unary = new NegNode();
        } else {
            unary = new PlusNode();
        }
        unary.setPosition(ctx.start.getLine(), ctx.start.getCharPositionInLine());
        unary.setExpression((ExpressionStatNode) visit(ctx.expr()));
        return unary;
    }

    @Override
    public Object visitArray(EasyPythonGrammarParser.ArrayContext ctx) {
        ListNode array = new ListNode();
        if (ctx.functionArgs() != null) {
            for (EasyPythonGrammarParser.ExprContext elem : ctx.functionArgs().expr()) {
                array.addElement((ExpressionStatNode) visit(elem));
            }
        }
        return array;
    }

    @Override
    public Object visitFunction(EasyPythonGrammarParser.FunctionContext ctx) {
        FunctionNode function = new FunctionNode();
        scopes.push(function);
        function.setPosition(ctx.start.getLine(), ctx.start.getCharPositionInLine());
        function.setValue(ctx.getText());
        if (ctx.functionParams() != null) {
            for (TerminalNode paramName : ctx.functionParams().ID()) {
                FunctionParameterNode param = new FunctionParameterNode();
                param.setName(paramName.getText());
                function.addParameter(param);
            }
        }
        for (EasyPythonGrammarParser.StatContext statement : ctx.blockStat().stat()) {
            function.addStatement((BlockStatNode) visit(statement));
        }
        scopes.pop();
        return function;
    }

    @Override
    public Object visitMulDivMod(EasyPythonGrammarParser.MulDivModContext ctx) {
        BinaryExpressionNode binary;
        if (ctx.op.getType() == EasyPythonGrammarParser.STAR) {
            binary = new MulNode();
        } else if (ctx.op.getType() == EasyPythonGrammarParser.DIV) {
            binary = new DivNode();
        } else {
            binary = new ModNode();
        }
        binary.setPosition(ctx.start.getLine(), ctx.start.getCharPositionInLine());
        binary.setLeftNode((ExpressionStatNode) visit(ctx.expr(0)));
        binary.setRightNode((ExpressionStatNode) visit(ctx.expr(1)));
        return binary;
    }

    @Override
    public BaseStatNode visitAnd(EasyPythonGrammarParser.AndContext ctx) {
        AndExpressionNode expr = new AndExpressionNode();
        expr.setPosition(ctx.start.getLine(), ctx.start.getCharPositionInLine());
        expr.setLeftNode((ExpressionStatNode) visit(ctx.expr(0)));
        expr.setLeftNode((ExpressionStatNode) visit(ctx.expr(1)));
        return expr;
    }

    @Override
    public Object visitAssign(EasyPythonGrammarParser.AssignContext ctx) {
        AssignmentNode assignment = new AssignmentNode();
        assignment.setPosition(ctx.start.getLine(), ctx.start.getCharPositionInLine());
        VarNode var = new VarNode();
        var.setPosition(ctx.start.getLine(), ctx.start.getCharPositionInLine());
        var.setName(ctx.ID().getText());
        assignment.setVariable(var);
        assignment.setExpression((ExpressionStatNode) visit(ctx.expr()));
        scopes.peek().addVariable(var.getName());
        if (ctx.expr() != null) {
            assignment.setExpression((ExpressionStatNode) visit(ctx.expr()));
        } else {
            assignment.setExpression(var);
        }
        ExpressionStatNode exprStat = new ExpressionStatNode();
        exprStat.setExpr(assignment);
        return assignment;
    }

    @Override
    public BaseStatNode visitFunctionCall(EasyPythonGrammarParser.FunctionCallContext ctx) {
        FunctionCallNode functionCall = new FunctionCallNode();
        functionCall.setPosition(ctx.start.getLine(), ctx.start.getCharPositionInLine());
        functionCall.setFunction((ExpressionStatNode) visit(ctx.expr()));
        if (ctx.functionArgs() != null) {
            for (EasyPythonGrammarParser.ExprContext arg : ctx.functionArgs().expr()) {
                functionCall.addArgument((ExpressionStatNode) visit(arg));
            }
        }
        return functionCall;
    }

    @Override
    public Object visitPutField(EasyPythonGrammarParser.PutFieldContext ctx) {
        PutFieldNode putIndex = new PutFieldNode();
        putIndex.setVariable((ExpressionStatNode) visit(ctx.expr(0)));
        if (ctx.index() != null) {
            putIndex.setIndex((ExpressionStatNode) visit(ctx.index().expr()));
        } else if (ctx.field() != null) {
            StringNode str = new StringNode();
            str.setValue("'" + ctx.field().ID().getText() + "'");
            putIndex.setIndex(str);
        }
        putIndex.setExpr((ExpressionStatNode) visit(ctx.expr(1)));
        return putIndex;
    }

}
