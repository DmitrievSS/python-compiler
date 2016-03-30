package Nodes;

import com.sun.org.apache.xpath.internal.ExpressionNode;

/**
 * Created by ssdmitriev on 29.03.16.
 */
public class WithConditionStatNode extends BaseStatNode {
    private BaseStatNode condition;
    public BaseStatNode getCondition() {
        return condition;
    }

    public void setCondition(BaseStatNode condition) {
        this.condition = condition;
    }

}
