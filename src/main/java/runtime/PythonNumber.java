package runtime;

/**
 * Created by ssdmitriev on 03.05.16.
 */
public class PythonNumber extends PythonObject{
    public PythonNumber(double v) {
        super(PythonType.NUMBER);
        this.numberValue = v;
    }
    public PythonNumber(boolean v){
        super(PythonType.NUMBER);
        if (v) {
            this.numberValue = 1.0;
        }
        else {
            this.numberValue = 0.0;
        }
    }
    public PythonObject toPythonBool() {
        return new PythonBoolean(numberValue > 0);
    }

    public PythonObject toPythonNumber() {
        return new PythonNumber(boolValue);
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
