/**
 * Created by ssdmitriev on 03.05.16.
 */
public class Main {
    public static void main(String[] args) {
        String name = "/Users/ssdmitriev/Python3Compiler/src/main/resources/examples/simple_python.py";
//        if (args.length == 0) {
//            System.out.println("ERROR: not enough params");
//            System.exit(1);
//        }
        Compiler compiler = new Compiler();
        compiler.setInputFileName(args[0]);
        String target = args.length > 1 ? args[1] : "Out";
        compiler.setOutputFileName(target);
        compiler.run();
    }
}
