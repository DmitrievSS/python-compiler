package runtime;

/**
 * Created by ssdmitriev on 03.05.16.
 */
public class PythonBoolean extends PythonObject {
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
}
