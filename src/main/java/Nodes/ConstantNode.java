package Nodes;

/**
 * Created by ssdmitriev on 31.03.16.
 */
public class ConstantNode extends ExpressionStatNode{
    private String value;

    public ConstantNode() {
        value = "";
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
