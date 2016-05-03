package nodes;

import visitors.AstVisitor;

import java.util.Optional;

/**
 * Created by ssdmitriev on 29.03.16.
 */
public class IfElseStatNode extends WithConditionStatNode {

    private StatStatNode ifStat;
    private Optional<StatStatNode> elseStat;

    public StatStatNode getIfStat() {
        return ifStat;
    }

    public void setIfStat(StatStatNode stat) {
        this.ifStat = stat;
    }

    public Optional<StatStatNode> getElseStat() {
        return elseStat;
    }

    public void setElseStat(StatStatNode elseStat) {
        this.elseStat = Optional.of(elseStat);
    }

    public <T> T accept(AstVisitor<T> v) {
        return v.visit(this);
    }
}
