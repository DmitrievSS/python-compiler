package nodes;

import visitors.AstVisitor;

/**
 * Created by ssdmitriev on 31.03.16.
 */
public class EqNode extends BinaryExpressionNode {
    public static final String TYPE = "EqNode";
    public <T> T accept(AstVisitor<T> v) {
        return v.visit(this);
    }
}
