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

    @Override
    public PythonObject append(PythonObject object) throws Exception {
        array.put(length + "", object);
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
