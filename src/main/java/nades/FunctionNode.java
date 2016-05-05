package nodes;

import visitors.AstVisitor;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * Created by ssdmitriev on 31.03.16.
 */
public class FunctionNode extends ConstantNode{
    private final ArrayList<FunctionParameterNode> parameters;
    private final ArrayList<BaseStatNode> body;
    private final HashSet<String> variables;

    public FunctionNode() {
        parameters = new ArrayList<>();
        body = new ArrayList<>();
        variables = new HashSet<>();
    }


    public ArrayList<FunctionParameterNode> getParameters() {
        return parameters;
    }

    public void addParameter(FunctionParameterNode parameter) {
        parameters.add(parameter);
    }

    public ArrayList<BaseStatNode> getBody() {
        return body;
    }

    public void addStatement(BaseStatNode statement) {
        body.add(statement);
    }

    public void addVariable(String name) {
        variables.add(name);
    }

    public boolean findVariable(String name) {
        return variables.contains(name);
    }

    // debug
    public HashSet<String> getVariables() {
        return variables;
    }

    public <T> T accept(AstVisitor<T> v) {
        return v.visit(this);
    }
}
