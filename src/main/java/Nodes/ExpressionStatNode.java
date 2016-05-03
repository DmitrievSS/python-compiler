package nodes;

import visitors.AstVisitor;

/**
 * Created by ssdmitriev on 29.03.16.
 */
public class ExpressionStatNode extends BaseStatNode {
    private ExpressionStatNode expr;

    public ExpressionStatNode getExpr() {
        return expr;
    }

    public void setExpr(ExpressionStatNode stat) {
        this.expr = stat;
    }
    public <T> T accept(AstVisitor<T> v) {
        return v.visit(this);
    }
}
