package nodes;

import visitors.AstVisitor;

/**
 * Created by ssdmitriev on 31.03.16.
 */
public class NotNode extends UnaryExpressionNode {
    public static final String TYPE = "NotNode";

    public <T> T accept(AstVisitor<T> v) {
        return v.visit(this);
    }
}
