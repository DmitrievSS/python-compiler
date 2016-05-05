package nodes;

import visitors.AstVisitor;

/**
 * Created by ssdmitriev on 31.03.16.
 */
public class NegNode extends UnaryExpressionNode {
    public static final String TYPE = "NegNode";

    public <T> T accept(AstVisitor<T> v) {
        return v.visit(this);
    }
}
