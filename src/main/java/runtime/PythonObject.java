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

    public PythonObject toPythonBool() {
//        switch (type) {
//            case NUMBER:
//                return new PythonBoolean(numberValue > 0);
//            case STRING:
//                return new PythonBoolean(!stringValue.isEmpty());
//            case OBJECT:
//                break;
////                return new PythonBoolean(doubleVal > 0);
//            case BOOL:
//                return new PythonBoolean(boolValue);
//            default:
//                System.err.println("RUNTIME ERROR: unmatchable type: " + type);
//                System.exit(1);
//        }
//        return null;
    }

    public PythonObject toPythonNumber() {
//        switch (type) {
//            case NUMBER:
//                return new PythonNumber(numberValue);
//            case STRING:
//                return new PythonNumber(Double.parseDouble(stringValue));
//            case BOOL:
//                return new PythonNumber(boolValue);
//            case OBJECT:
//                break;
//            default:
//                System.err.println("RUNTIME ERROR: unmatchable type: " + type);
//                System.exit(1);
//        }
//        return null;

    }
    public abstract PythonObject toPythonString() {
//        switch (type) {
//            case NUMBER:
//                return new PythonString(Double.toString(numberValue));
//            case STRING:
//                return new PythonString(stringValue);
//            case BOOL:
//                return new PythonString(Boolean.toString(toBool()));
//            case OBJECT:
//            default:
//                System.err.println("RUNTIME ERROR: unmatchable type: " + type);
//                System.exit(1);
//        }
//        return null;
    }

    public PythonObject neg() {
        PythonObject number = this.toPythonNumber();
        return new PythonNumber(-this.numberValue);
    }

    public PythonObject not() {
        PythonObject bool = toPythonBool();
        return new PythonBoolean(!bool.boolValue);
    }

    public PythonObject mul() {}
    public PythonObject mod() {}
    public PythonObject div() {}
    public PythonObject eq() {}
    public PythonObject not() {}
    public PythonObject notEq() {}
}
