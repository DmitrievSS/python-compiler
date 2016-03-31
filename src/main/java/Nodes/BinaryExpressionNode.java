package Nodes;

/**
 * Created by ssdmitriev on 30.03.16.
 */
public class BinaryExpressionNode extends ExpressionStatNode{
    private ExpressionStatNode leftNode;
    private ExpressionStatNode rightNode;


    public ExpressionStatNode getRightNode() {
        return rightNode;
    }

    public void setRightNode(ExpressionStatNode rightNode) {
        this.rightNode = rightNode;
    }

    public ExpressionStatNode getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(ExpressionStatNode leftNode) {
        this.leftNode = leftNode;
    }
}
