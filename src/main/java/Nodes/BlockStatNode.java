package nodes;

import visitors.AstVisitor;

import java.util.ArrayList;

/**
 * Created by ssdmitriev on 29.03.16.
 */
public class BlockStatNode extends BaseStatNode {
    private ArrayList<BaseStatNode> body;

    public BlockStatNode() {
        body = new ArrayList<>();
    }

    public ArrayList<BaseStatNode> getBody() {
        return body;
    }

    public void addStatement(BaseStatNode statement) {
        body.add(statement);
    }

    public <T> T accept(AstVisitor<T> v) {
        return v.visit(this);
    }
}
