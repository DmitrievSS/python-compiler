package nodes;

import visitors.AstVisitor;

import java.util.ArrayList;

/**
 * Created by ssdmitriev on 31.03.16.
 */
public class FunctionCallNode extends ExpressionStatNode{
    private ExpressionStatNode function;
    private final ArrayList<ExpressionStatNode> arguments;

    public FunctionCallNode() {
        function = null;
        arguments = new ArrayList<ExpressionStatNode>();
    }

    public ExpressionStatNode getFunction() {
        return function;
    }

    public void setFunction(ExpressionStatNode function) {
        this.function = function;
    }

    public ArrayList<ExpressionStatNode> getArguments() {
        return arguments;
    }

    public void addArgument(ExpressionStatNode argument) {
        arguments.add(argument);
    }

    public <T> T accept(AstVisitor<T> v) {
        return v.visit(this);
    }
}
