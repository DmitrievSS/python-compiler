package runtime;

/**
 * Created by ssdmitriev on 03.05.16.
 */
public abstract class PythonObject {
    private PythonType type;
    protected String stringValue;
    protected double numberValue;
    protected boolean boolValue;

    public PythonObject(PythonType type) {
        this.type = type;
    }

    protected boolean toBool() {
        return numberValue != 0;
    }

    public int toInt() {
        return this.toPythonBool().toInt();
    }

    public abstract PythonObject toPythonBool();

    public abstract PythonObject toPythonNumber();

    public abstract PythonObject toPythonString();

    public abstract PythonObject neg();

    public abstract PythonObject not();

    public abstract PythonObject mul();
    public abstract PythonObject mod();
    public abstract PythonObject div();
    public abstract PythonObject eq();
    public abstract PythonObject add();
    public abstract PythonObject or();
    public abstract PythonObject notEq();
    public abstract PythonObject greaterOrEq();
    public abstract PythonObject greater();
    public abstract PythonObject lessOrEq();
    public abstract PythonObject less();
    public PythonObject append(PythonObject object) throws Exception {
        return this;
    }

    public PythonObject remove(int index) throws Exception {
        return this;
    }

    public PythonObject get(int index) throws Exception {
        return this;
    }
}
