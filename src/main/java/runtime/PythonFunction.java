package runtime;

/**
 * Created by ssdmitriev on 04.05.16.
 */
public class PythonFunction extends PythonObject {
    public PythonFunction(String text) {
        super(PythonType.OBJECT);
        this.stringValue = text;
    }

    @Override
    public int toInt() {
        throw new RuntimeException("Class error");
    }

    @Override
    public PythonObject toPythonBool() {
        return null;
    }

    @Override
    public PythonObject toPythonNumber() {
        return null;
    }

    @Override
    public PythonObject toPythonString() {
        return null;
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
    public String toString() {
        return stringValue;
    }

    @Override
    public PythonObject less(PythonObject x) {
        return null;
    }
}
