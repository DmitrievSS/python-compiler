package runtime;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ssdmitriev on 03.05.16.
 */
public class PythonList extends PythonObject {
    private Map<String, PythonObject> array;
    private int length;

    public PythonList(PythonObject... objects) {
        super(PythonType.OBJECT);
        array = new HashMap<>();
        length = objects.length;
        for (int i = 0; i < objects.length; i++) {
            array.put(i + "", objects[i]);
        }
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
    public PythonObject less(PythonObject x) {
        return null;
    }


    @Override
    public PythonObject append(PythonObject object) throws Exception {
        array.put(length + "", object);
        length++;
        return this;
    }

    public PythonObject append(PythonString string, PythonObject object){
        array.put(string.getStringValue(), object);
        length++;
        return this;
    }

    @Override
    public PythonObject remove(int index) throws Exception {
        array.remove(index + "");
        length--;
        return this;
    }

    @Override
    public PythonObject get(int index) throws Exception {
        return array.get(index+"");
    }

}
