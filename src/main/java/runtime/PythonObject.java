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
        throw new RuntimeException("Class error");
    }

    public PythonObject call(PythonObject... objects) {
        System.err.println("RUNTIME ERROR: object '" +
                this.toPythonString().getStringValue() + "' is not callable.");
        System.exit(1);
        return null;
    }

    public abstract PythonObject toPythonBool();

    public abstract PythonObject toPythonNumber();

    public abstract PythonObject toPythonString();

    public abstract PythonObject neg();

    public abstract PythonObject not();

    public abstract PythonObject mul(PythonObject x);

    public abstract PythonObject mod(PythonObject x);
    public abstract PythonObject div(PythonObject x);
    public abstract PythonObject eq(PythonObject x);
    public abstract PythonObject add(PythonObject x);
    public abstract PythonObject or(PythonObject x);
    public abstract PythonObject notEq(PythonObject x);
    public abstract PythonObject greaterOrEq(PythonObject x);
    public abstract PythonObject greater(PythonObject x);
    public abstract PythonObject lessOrEq(PythonObject x);
    public abstract PythonObject less(PythonObject x);
    public PythonObject append(PythonObject object) throws Exception {
        return this;
    }
    public PythonObject remove(PythonObject  index) throws Exception {
        return this;
    }

    public PythonObject get(PythonObject index) throws Exception {
        return this;
    }

    public String getStringValue() {
        return stringValue.replaceAll("\'", "");
    }

    public double getNumberValue() {
        return numberValue;
    }

    public boolean isBoolValue() {
        return boolValue;
    }
}
