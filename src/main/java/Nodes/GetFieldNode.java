package nodes;

import visitors.AstVisitor;

/**
 * Created by ssdmitriev on 31.03.16.
 */
public class GetFieldNode extends BaseStatNode {
    private ExpressionStatNode variable;
    private ExpressionStatNode index;

    public GetFieldNode() {
        variable = null;
        index = null;
    }

    public ExpressionStatNode getVariable() {
        return variable;
    }

    public void setVariable(ExpressionStatNode variable) {
        this.variable = variable;
    }

    public ExpressionStatNode getIndex() {
        return index;
    }

    public void setIndex(ExpressionStatNode index) {
        this.index = index;
    }

    public <T> T accept(AstVisitor<T> v) {
        return v.visit(this);
    }
}
