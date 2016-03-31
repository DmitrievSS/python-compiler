package Nodes;

/**
 * Created by ssdmitriev on 31.03.16.
 */
public class UnaryExpressionNode extends ExpressionStatNode {
    private ExpressionStatNode expression;

    public UnaryExpressionNode() {
        expression = null;
    }

    public ExpressionStatNode getExpression() {
        return expression;
    }

    public void setExpression(ExpressionStatNode expression) {
        this.expression = expression;
    }
}
