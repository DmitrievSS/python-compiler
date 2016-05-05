package nodes;

import visitors.AstVisitor;

/**
 * Created by ssdmitriev on 29.03.16.
 */
public class ReturnStatNode extends BaseStatNode{
    private ExpressionStatNode value;

    public ReturnStatNode() {
        value = null;
    }

    public ExpressionStatNode getValue() {
        return value;
    }

    public void setValue(ExpressionStatNode value) {
        this.value = value;
    }

    public <T> T accept(AstVisitor<T> v) {
        return v.visit(this);
    }
}
