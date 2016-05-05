package runtime;

/**
 * Created by ssdmitriev on 03.05.16.
 */
public class PythonBoolean extends PythonObject {
    public static final PythonBoolean TRUE = new PythonBoolean(true);
    public static final PythonBoolean FALSE = new PythonBoolean(false);

    public PythonBoolean(boolean b) {
        super(PythonType.BOOL);
        this.boolValue = b;
    }



    public PythonObject toPythonBool() {
        return this;
    }

    public PythonObject toPythonNumber() {
        return new PythonNumber(boolValue);
    }

    public PythonObject toPythonString() {
        return new PythonString(String.valueOf(boolValue));
    }

    @Override
    public PythonObject neg() {
        PythonObject number = this.toPythonNumber();
        return new PythonNumber(-number.getNumberValue());
    }

    @Override
    public PythonObject not() {
        return new PythonBoolean(!this.boolValue);
    }

    @Override
    public PythonObject mul(PythonObject x) {
        PythonNumber number1 = (PythonNumber) this.toPythonNumber();
        PythonObject number2 = x.toPythonNumber();
        return number1.mul(number2);
    }

    @Override
    public PythonObject mod(PythonObject x) {
        PythonNumber number1 = (PythonNumber) this.toPythonNumber();
        PythonObject number2 = x.toPythonNumber();
        return number1.mod(number2);
    }

    @Override
    public PythonObject div(PythonObject x) {
        PythonNumber number1 = (PythonNumber) this.toPythonNumber();
        PythonObject number2 = x.toPythonNumber();
        return number1.div(number2);
    }

    @Override
    public PythonObject eq(PythonObject x) {
        return new PythonBoolean(this.boolValue == x.boolValue);
    }

    @Override
    public PythonObject add(PythonObject x) {
        return null;
    }

    @Override
    public PythonObject or(PythonObject x) {
        return new PythonBoolean(this.boolValue || x.boolValue);
    }

    @Override
    public PythonObject notEq(PythonObject x) {
        return new PythonBoolean(this.boolValue != x.boolValue);
    }

    @Override
    public PythonObject greaterOrEq(PythonObject x) {
        PythonNumber number1 = (PythonNumber) this.toPythonNumber();
        PythonObject number2 = x.toPythonNumber();
        return number1.greaterOrEq(number2);
    }

    @Override
    public PythonObject greater(PythonObject x) {
        PythonNumber number1 = (PythonNumber) this.toPythonNumber();
        PythonObject number2 = x.toPythonNumber();
        return number1.greater(number2);
    }

    @Override
    public PythonObject lessOrEq(PythonObject x) {
        PythonNumber number1 = (PythonNumber) this.toPythonNumber();
        PythonObject number2 = x.toPythonNumber();
        return number1.lessOrEq(number2);
    }

    @Override
    public PythonObject less(PythonObject x) {
        PythonNumber number1 = (PythonNumber) this.toPythonNumber();
        PythonObject number2 = x.toPythonNumber();
        return number1.less(number2);
    }

}
