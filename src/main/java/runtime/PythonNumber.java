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
}
