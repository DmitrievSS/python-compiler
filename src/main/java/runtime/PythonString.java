package runtime;

/**
 * Created by ssdmitriev on 03.05.16.
 */
public class PythonString extends PythonObject{
    public PythonString(String stringValue) {
        super(PythonType.STRING);
        this.stringValue = stringValue;
    }

    public PythonObject toPythonBool() {
        return new PythonBoolean(!stringValue.isEmpty());
    }

    public PythonObject toPythonNumber() {
        return new PythonNumber(Double.parseDouble(this.stringValue));
    }

    public PythonObject toPythonString() {
        return this;
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
        return null;
    }

    @Override
    public PythonObject mod(PythonObject x) {
        return null;
    }

    @Override
    public PythonObject div(PythonObject x) {
        return null;
    }

    @Override
    public PythonObject eq(PythonObject x) {
        return null;
    }

    @Override
    public PythonObject add(PythonObject x) {
        return null;
    }

    @Override
    public PythonObject or(PythonObject x) {
        return null;
    }

    @Override
    public PythonObject notEq(PythonObject x) {
        return null;
    }

    @Override
    public PythonObject greaterOrEq(PythonObject x) {
        return null;
    }

    @Override
    public PythonObject greater(PythonObject x) {
        return null;
    }

    @Override
    public PythonObject lessOrEq(PythonObject x) {
        return null;
    }

    @Override
    public PythonObject less(PythonObject x) {
        return null;
    }


}
