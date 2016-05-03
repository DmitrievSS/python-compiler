package runtime;

/**
 * Created by ssdmitriev on 03.05.16.
 */
public class PythonString extends PythonObject{
    public PythonString(String stringValue) {
        super(PythonType.STRING);
        this.stringValue = stringValue
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
}
