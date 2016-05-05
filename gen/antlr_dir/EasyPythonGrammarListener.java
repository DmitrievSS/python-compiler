// Generated from /Users/ssdmitriev/Python3Compiler/src/main/java/antlr_dir/EasyPythonGrammar.g4 by ANTLR 4.5.1
package antlr_dir;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link EasyPythonGrammarParser}.
 */
public interface EasyPythonGrammarListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link EasyPythonGrammarParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(EasyPythonGrammarParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link EasyPythonGrammarParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(EasyPythonGrammarParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link EasyPythonGrammarParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterStat(EasyPythonGrammarParser.StatContext ctx);
	/**
	 * Exit a parse tree produced by {@link EasyPythonGrammarParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitStat(EasyPythonGrammarParser.StatContext ctx);
	/**
	 * Enter a parse tree produced by {@link EasyPythonGrammarParser#blockStat}.
	 * @param ctx the parse tree
	 */
	void enterBlockStat(EasyPythonGrammarParser.BlockStatContext ctx);
	/**
	 * Exit a parse tree produced by {@link EasyPythonGrammarParser#blockStat}.
	 * @param ctx the parse tree
	 */
	void exitBlockStat(EasyPythonGrammarParser.BlockStatContext ctx);
	/**
	 * Enter a parse tree produced by {@link EasyPythonGrammarParser#ifStat}.
	 * @param ctx the parse tree
	 */
	void enterIfStat(EasyPythonGrammarParser.IfStatContext ctx);
	/**
	 * Exit a parse tree produced by {@link EasyPythonGrammarParser#ifStat}.
	 * @param ctx the parse tree
	 */
	void exitIfStat(EasyPythonGrammarParser.IfStatContext ctx);
	/**
	 * Enter a parse tree produced by {@link EasyPythonGrammarParser#whileStat}.
	 * @param ctx the parse tree
	 */
	void enterWhileStat(EasyPythonGrammarParser.WhileStatContext ctx);
	/**
	 * Exit a parse tree produced by {@link EasyPythonGrammarParser#whileStat}.
	 * @param ctx the parse tree
	 */
	void exitWhileStat(EasyPythonGrammarParser.WhileStatContext ctx);
	/**
	 * Enter a parse tree produced by {@link EasyPythonGrammarParser#returnStat}.
	 * @param ctx the parse tree
	 */
	void enterReturnStat(EasyPythonGrammarParser.ReturnStatContext ctx);
	/**
	 * Exit a parse tree produced by {@link EasyPythonGrammarParser#returnStat}.
	 * @param ctx the parse tree
	 */
	void exitReturnStat(EasyPythonGrammarParser.ReturnStatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code GetField}
	 * labeled alternative in {@link EasyPythonGrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterGetField(EasyPythonGrammarParser.GetFieldContext ctx);
	/**
	 * Exit a parse tree produced by the {@code GetField}
	 * labeled alternative in {@link EasyPythonGrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitGetField(EasyPythonGrammarParser.GetFieldContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Or}
	 * labeled alternative in {@link EasyPythonGrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterOr(EasyPythonGrammarParser.OrContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Or}
	 * labeled alternative in {@link EasyPythonGrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitOr(EasyPythonGrammarParser.OrContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AddSub}
	 * labeled alternative in {@link EasyPythonGrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterAddSub(EasyPythonGrammarParser.AddSubContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AddSub}
	 * labeled alternative in {@link EasyPythonGrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitAddSub(EasyPythonGrammarParser.AddSubContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Parens}
	 * labeled alternative in {@link EasyPythonGrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterParens(EasyPythonGrammarParser.ParensContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Parens}
	 * labeled alternative in {@link EasyPythonGrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitParens(EasyPythonGrammarParser.ParensContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Var}
	 * labeled alternative in {@link EasyPythonGrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterVar(EasyPythonGrammarParser.VarContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Var}
	 * labeled alternative in {@link EasyPythonGrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitVar(EasyPythonGrammarParser.VarContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Constant}
	 * labeled alternative in {@link EasyPythonGrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterConstant(EasyPythonGrammarParser.ConstantContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Constant}
	 * labeled alternative in {@link EasyPythonGrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitConstant(EasyPythonGrammarParser.ConstantContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Cmp}
	 * labeled alternative in {@link EasyPythonGrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterCmp(EasyPythonGrammarParser.CmpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Cmp}
	 * labeled alternative in {@link EasyPythonGrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitCmp(EasyPythonGrammarParser.CmpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Eq}
	 * labeled alternative in {@link EasyPythonGrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterEq(EasyPythonGrammarParser.EqContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Eq}
	 * labeled alternative in {@link EasyPythonGrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitEq(EasyPythonGrammarParser.EqContext ctx);
	/**
	 * Enter a parse tree produced by the {@code UnaryExpr}
	 * labeled alternative in {@link EasyPythonGrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterUnaryExpr(EasyPythonGrammarParser.UnaryExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code UnaryExpr}
	 * labeled alternative in {@link EasyPythonGrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitUnaryExpr(EasyPythonGrammarParser.UnaryExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Array}
	 * labeled alternative in {@link EasyPythonGrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterArray(EasyPythonGrammarParser.ArrayContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Array}
	 * labeled alternative in {@link EasyPythonGrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitArray(EasyPythonGrammarParser.ArrayContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Function}
	 * labeled alternative in {@link EasyPythonGrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterFunction(EasyPythonGrammarParser.FunctionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Function}
	 * labeled alternative in {@link EasyPythonGrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitFunction(EasyPythonGrammarParser.FunctionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MulDivMod}
	 * labeled alternative in {@link EasyPythonGrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterMulDivMod(EasyPythonGrammarParser.MulDivModContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MulDivMod}
	 * labeled alternative in {@link EasyPythonGrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitMulDivMod(EasyPythonGrammarParser.MulDivModContext ctx);
	/**
	 * Enter a parse tree produced by the {@code And}
	 * labeled alternative in {@link EasyPythonGrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterAnd(EasyPythonGrammarParser.AndContext ctx);
	/**
	 * Exit a parse tree produced by the {@code And}
	 * labeled alternative in {@link EasyPythonGrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitAnd(EasyPythonGrammarParser.AndContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Assign}
	 * labeled alternative in {@link EasyPythonGrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterAssign(EasyPythonGrammarParser.AssignContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Assign}
	 * labeled alternative in {@link EasyPythonGrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitAssign(EasyPythonGrammarParser.AssignContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FunctionCall}
	 * labeled alternative in {@link EasyPythonGrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterFunctionCall(EasyPythonGrammarParser.FunctionCallContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FunctionCall}
	 * labeled alternative in {@link EasyPythonGrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitFunctionCall(EasyPythonGrammarParser.FunctionCallContext ctx);
	/**
	 * Enter a parse tree produced by the {@code PutField}
	 * labeled alternative in {@link EasyPythonGrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterPutField(EasyPythonGrammarParser.PutFieldContext ctx);
	/**
	 * Exit a parse tree produced by the {@code PutField}
	 * labeled alternative in {@link EasyPythonGrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitPutField(EasyPythonGrammarParser.PutFieldContext ctx);
	/**
	 * Enter a parse tree produced by {@link EasyPythonGrammarParser#functionArgs}.
	 * @param ctx the parse tree
	 */
	void enterFunctionArgs(EasyPythonGrammarParser.FunctionArgsContext ctx);
	/**
	 * Exit a parse tree produced by {@link EasyPythonGrammarParser#functionArgs}.
	 * @param ctx the parse tree
	 */
	void exitFunctionArgs(EasyPythonGrammarParser.FunctionArgsContext ctx);
	/**
	 * Enter a parse tree produced by {@link EasyPythonGrammarParser#functionParams}.
	 * @param ctx the parse tree
	 */
	void enterFunctionParams(EasyPythonGrammarParser.FunctionParamsContext ctx);
	/**
	 * Exit a parse tree produced by {@link EasyPythonGrammarParser#functionParams}.
	 * @param ctx the parse tree
	 */
	void exitFunctionParams(EasyPythonGrammarParser.FunctionParamsContext ctx);
	/**
	 * Enter a parse tree produced by {@link EasyPythonGrammarParser#index}.
	 * @param ctx the parse tree
	 */
	void enterIndex(EasyPythonGrammarParser.IndexContext ctx);
	/**
	 * Exit a parse tree produced by {@link EasyPythonGrammarParser#index}.
	 * @param ctx the parse tree
	 */
	void exitIndex(EasyPythonGrammarParser.IndexContext ctx);
	/**
	 * Enter a parse tree produced by {@link EasyPythonGrammarParser#field}.
	 * @param ctx the parse tree
	 */
	void enterField(EasyPythonGrammarParser.FieldContext ctx);
	/**
	 * Exit a parse tree produced by {@link EasyPythonGrammarParser#field}.
	 * @param ctx the parse tree
	 */
	void exitField(EasyPythonGrammarParser.FieldContext ctx);
}