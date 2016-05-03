package nodes;

import visitors.AstVisitor;

/**
 * Created by ssdmitriev on 29.03.16.
 */
public class WithConditionStatNode extends BaseStatNode {
    private BaseStatNode condition;
    public BaseStatNode getCondition() {
        return condition;
    }

    public void setCondition(BaseStatNode condition) {
        this.condition = condition;
    }

    public <T> T accept(AstVisitor<T> v) {
        return v.visit(this);
    }
}
