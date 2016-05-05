package nodes;

import visitors.AstVisitor;

/**
 * Created by ssdmitriev on 31.03.16.
 */
public class LeNode extends BinaryExpressionNode {
    public static final String TYPE = "LeNode";

    public <T> T accept(AstVisitor<T> v) {
        return v.visit(this);
    }
}
