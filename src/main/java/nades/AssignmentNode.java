package nodes;

import visitors.AstVisitor;

/**
 * Created by ssdmitriev on 31.03.16.
 */
public class AssignmentNode extends ExpressionStatNode {
    private VarNode variable;
    private ExpressionStatNode expression;

    public AssignmentNode() {
        variable = null;
        expression = null;
    }

    public VarNode getVariable() {
        return variable;
    }

    public void setVariable(VarNode variable) {
        this.variable = variable;
    }

    public ExpressionStatNode getExpression() {
        return expression;
    }

    public void setExpression(ExpressionStatNode expression) {
        this.expression = expression;
    }

    public <T> T accept(AstVisitor<T> v) {
        return v.visit(this);
    }
}
