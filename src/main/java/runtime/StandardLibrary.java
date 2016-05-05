package runtime;

import java.util.Scanner;

/**
 * Created by ssdmitriev on 04.05.16.
 */
public class StandardLibrary {
    public static final PythonList CONSOLE;
    private static final String FUNCTION_TEXT = "[native code]";
    private static final PythonFunction CONSOLE_PRINT = new PythonFunction(FUNCTION_TEXT) {
        public PythonObject call(PythonObject... objects) {
            StringBuilder result = new StringBuilder();
            for (int i = 0; i < objects.length; i++) {
                result.append(objects[i].toPythonString().getStringValue());
                if (i != objects.length - 1) {
                    result.append(" ");
                }
            }
            System.out.print(result.toString());
            return new PythonUndef();
        }
    };

    private static final PythonFunction CONSOLE_PRINTLN = new PythonFunction(FUNCTION_TEXT) {
        public PythonObject call(PythonObject... objects) {
            StringBuilder result = new StringBuilder();
            for (int i = 0; i < objects.length; i++) {
                result.append(objects[i].toPythonString().getStringValue());
                if (i != objects.length - 1) {
                    result.append(" ");
                }
            }
            System.out.println(result.toString());
            return new PythonUndef();
        }
    };

    private static final PythonFunction CONSOLE_READ = new PythonFunction(FUNCTION_TEXT) {
        private Scanner scanner = new Scanner(System.in);

        public PythonObject call(PythonObject... objects) {
            return new PythonString(scanner.nextLine());
        }
    };

    static {
        CONSOLE = new PythonList();
        CONSOLE.append(new PythonString("print"), CONSOLE_PRINT);
        CONSOLE.append(new PythonString("println"), CONSOLE_PRINTLN);
        CONSOLE.append(new PythonString("read"), CONSOLE_READ);
    }
}
