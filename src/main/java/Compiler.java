import antlr_dir.EasyPythonGrammarLexer;
import antlr_dir.EasyPythonGrammarParser;
import nodes.ProgrammNode;
import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import visitors.AstBuilder;
import visitors.CodeGenerator;

import java.io.IOException;

/**
 * Created by ssdmitriev on 03.05.16.
 */
public class Compiler {
    private String inputFileName;

    private String outputFileName;

    public void run() {
        try {
            CharStream cs = new ANTLRFileStream(inputFileName);
            EasyPythonGrammarLexer pythonGrammarLexer = new EasyPythonGrammarLexer(cs);
            CommonTokenStream tokens = new CommonTokenStream(pythonGrammarLexer);
            EasyPythonGrammarParser pythonGrammarParser = new EasyPythonGrammarParser(tokens);
            ParseTree tree = pythonGrammarParser.program();
            AstBuilder astBuilder = new AstBuilder();
            ProgrammNode ast = (ProgrammNode) astBuilder.visit(tree);
            CodeGenerator codeGenerator = new CodeGenerator("New");
            codeGenerator.visit(ast);
            int i  = 1;
        } catch (IOException e) {
            System.err.println("ERROR: source file doesn't exist:" + inputFileName);
            System.exit(1);
        }

    }




    public String getOutputFileName() {
        return outputFileName;
    }

    public void setOutputFileName(String outputFileName) {
        this.outputFileName = outputFileName;
    }

    public String getInputFileName() {
        return inputFileName;
    }

    public void setInputFileName(String inputFileName) {
        this.inputFileName = inputFileName;
    }

}
