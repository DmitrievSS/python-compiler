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
