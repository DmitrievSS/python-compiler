package nodes;

import visitors.AstVisitor;

/**
 * Created by ssdmitriev on 30.03.16.
 */
public class OrExpressionNode extends BinaryExpressionNode {
    public static final String TYPE = "or";

    public <T> T accept(AstVisitor<T> v) {
        return v.visit(this);
    }
}
