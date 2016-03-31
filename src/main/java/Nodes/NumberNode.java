package Nodes;

/**
 * Created by ssdmitriev on 31.03.16.
 */
public class NumberNode extends ConstantNode {
    public void setValue(String value) {
        try {
            double t = Double.parseDouble(value);
            String str = (long) t == t ? "" + (long) t : "" + t;
            super.setValue(str);
        } catch (NumberFormatException e) {
            super.setValue(value); // NaN
        }
    }

}
