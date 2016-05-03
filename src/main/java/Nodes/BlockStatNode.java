package nodes;

import visitors.AstVisitor;

import java.util.ArrayList;

/**
 * Created by ssdmitriev on 29.03.16.
 */
public class BlockStatNode extends BaseStatNode {
    private ArrayList<StatStatNode> body;

    public BlockStatNode() {
        body = new ArrayList<>();
    }

    public ArrayList<StatStatNode> getBody() {
        return body;
    }

    public void addStatement(StatStatNode statement) {
        body.add(statement);
    }

    public <T> T accept(AstVisitor<T> v) {
        return v.visit(this);
    }
}
