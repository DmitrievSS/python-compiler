package runtime;

/**
 * Created by ssdmitriev on 03.05.16.
 */
public class PythonNumber extends PythonObject {
    public PythonNumber(double v) {
        super(PythonType.NUMBER);
        this.numberValue = v;
    }

    public PythonNumber(boolean v) {
        super(PythonType.NUMBER);
        if (v) {
            this.numberValue = 1.0;
        } else {
            this.numberValue = 0.0;
        }
    }

    @Override
    public int toInt() {
        return (int) this.numberValue;
    }


    public PythonObject toPythonBool() {
        return new PythonBoolean(numberValue > 0);
    }

    public PythonObject toPythonNumber() {
        return this;
    }

    public PythonObject toPythonString() {
        return new PythonString(String.valueOf(numberValue));
    }

    @Override
    public PythonObject neg() {
        return null;
    }

    @Override
    public PythonObject not() {
        return null;
    }

    @Override
    public PythonObject mul(PythonObject x) {
        PythonNumber number = (PythonNumber) x.toPythonNumber();
        return new PythonNumber(this.numberValue * number.getNumberValue());
    }

    @Override
    public PythonObject mod(PythonObject x) {
        PythonNumber number = (PythonNumber) x.toPythonNumber();
        return new PythonNumber(this.numberValue % number.getNumberValue());
    }

    @Override
    public PythonObject div(PythonObject x) {
        PythonNumber number = (PythonNumber) x.toPythonNumber();
        return new PythonNumber(this.numberValue / number.getNumberValue());
    }

    @Override
    public PythonObject eq(PythonObject x) {
        PythonNumber number = (PythonNumber) x.toPythonNumber();
        return new PythonBoolean(this.numberValue == number.getNumberValue());
    }

    @Override
    public PythonObject add(PythonObject x) {

        return null;
    }

    @Override
    public PythonObject or(PythonObject x) {
        PythonBoolean bool1 = (PythonBoolean) this.toPythonBool();
        PythonBoolean bool2 = (PythonBoolean) x.toPythonBool();
        return new PythonBoolean(bool1.boolValue || bool2.boolValue);
    }

    @Override
    public PythonObject notEq(PythonObject x) {
        PythonNumber number = (PythonNumber) x.toPythonNumber();
        return new PythonBoolean(this.numberValue != number.getNumberValue());
    }

    @Override
    public PythonObject greaterOrEq(PythonObject x) {
        PythonNumber number = (PythonNumber) x.toPythonNumber();
        return new PythonBoolean(this.numberValue >= number.getNumberValue());
    }

    @Override
    public PythonObject greater(PythonObject x) {
        PythonNumber number = (PythonNumber) x.toPythonNumber();
        return new PythonBoolean(this.numberValue > number.getNumberValue());
    }

    @Override
    public PythonObject lessOrEq(PythonObject x) {
        PythonNumber number = (PythonNumber) x.toPythonNumber();
        return new PythonBoolean(this.numberValue <= number.getNumberValue());
    }

    @Override
    public PythonObject less(PythonObject x) {
        PythonNumber number = (PythonNumber) x.toPythonNumber();
        return new PythonBoolean(this.numberValue < number.getNumberValue());
    }

    @Override
    public String toString() {
        return String.valueOf(numberValue);
    }
}
