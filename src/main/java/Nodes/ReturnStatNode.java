package Nodes;

/**
 * Created by ssdmitriev on 29.03.16.
 */
public class ReturnStatNode extends BaseStatNode{
    private ExpressionStatNode value;

    public ReturnStatNode() {
        value = null;
    }

    public ExpressionStatNode getValue() {
        return value;
    }

    public void setValue(ExpressionStatNode value) {
        this.value = value;
    }
}
