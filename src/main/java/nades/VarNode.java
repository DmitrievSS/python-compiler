package nodes;

import visitors.AstVisitor;

/**
 * Created by ssdmitriev on 31.03.16.
 */
public class VarNode extends ExpressionStatNode{
    private String name;

    public VarNode() {
        name = "";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = "_" + name; // for non-conflicting names
    }

    public <T> T accept(AstVisitor<T> v) {
        return v.visit(this);
    }
}
