package nodes;

import visitors.AstVisitor;

import java.util.Optional;

/**
 * Created by ssdmitriev on 29.03.16.
 */
public class IfElseStatNode extends WithConditionStatNode {

    private BaseStatNode ifBranch;
    private BaseStatNode elseBranch;

    public BaseStatNode getIfBranch() {
        return ifBranch;
    }

    public void setIfBranch(BaseStatNode stat) {
        this.ifBranch = stat;
    }

    public BaseStatNode getElseBranch() {
        return elseBranch;
    }

    public void setElseBranch(BaseStatNode elseBranch) {
        this.elseBranch = elseBranch;
    }

    public <T> T accept(AstVisitor<T> v) {
        return v.visit(this);
    }
}
