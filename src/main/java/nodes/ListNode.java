package nodes;

import visitors.AstVisitor;

import java.util.ArrayList;

/**
 * Created by ssdmitriev on 31.03.16.
 */
public class ListNode extends ExpressionStatNode{

    private final ArrayList<ExpressionStatNode> elements;

    public ListNode() {
        elements = new ArrayList<>();
    }

    public ArrayList<ExpressionStatNode> getElements() {
        return elements;
    }

    public void addElement(ExpressionStatNode element) {
        elements.add(element);
    }

    public <T> T accept(AstVisitor<T> v) {
        return v.visit(this);
    }
}
