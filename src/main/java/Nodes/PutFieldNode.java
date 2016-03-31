package Nodes;

/**
 * Created by ssdmitriev on 31.03.16.
 */
public class PutFieldNode extends ExpressionStatNode {
    private ExpressionStatNode variable;
    private ExpressionStatNode index;

    public PutFieldNode() {
        variable = null;
        index = null;
    }

    public ExpressionStatNode getVariable() {
        return variable;
    }

    public void setVariable(ExpressionStatNode variable) {
        this.variable = variable;
    }

    public ExpressionStatNode getIndex() {
        return index;
    }

    public void setIndex(ExpressionStatNode index) {
        this.index = index;
    }
}
