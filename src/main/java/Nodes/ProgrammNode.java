package nodes;

import visitors.AstVisitor;

/**
 * Created by ssdmitriev on 29.03.16.
 */
public class ProgrammNode extends FunctionNode{
    public <T> T accept(AstVisitor<T> v) {
        return v.visit(this);
    }
}
