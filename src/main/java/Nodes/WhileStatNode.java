package nodes;

import visitors.AstVisitor;

/**
 * Created by ssdmitriev on 29.03.16.
 */
public class WhileStatNode extends WithConditionStatNode {
    private BaseStatNode stat;

    public BaseStatNode getStat() {
        return stat;
    }

    public void setStat(BaseStatNode stat) {
        this.stat = stat;
    }

    public <T> T accept(AstVisitor<T> v) {
        return v.visit(this);
    }
}
