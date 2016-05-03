package nodes;

import visitors.AstVisitor;

/**
 * Created by ssdmitriev on 29.03.16.
 */
public class WhileStatNode extends WithConditionStatNode {
    private StatStatNode stat;

    public StatStatNode getStat() {
        return stat;
    }

    public void setStat(StatStatNode stat) {
        this.stat = stat;
    }

    public <T> T accept(AstVisitor<T> v) {
        return v.visit(this);
    }
}
