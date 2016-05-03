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
    public PythonObject mul() {
        return null;
    }

    @Override
    public PythonObject mod() {
        return null;
    }

    @Override
    public PythonObject div() {
        return null;
    }

    @Override
    public PythonObject eq() {
        return null;
    }

    @Override
    public PythonObject add() {
        return null;
    }

    @Override
    public PythonObject or() {
        return null;
    }

    @Override
    public PythonObject notEq() {
        return null;
    }

    @Override
    public PythonObject greaterOrEq() {
        return null;
    }

    @Override
    public PythonObject greater() {
        return null;
    }

    @Override
    public PythonObject lessOrEq() {
        return null;
    }

    @Override
    public PythonObject less() {
        return null;
    }
}
