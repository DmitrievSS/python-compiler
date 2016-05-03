package antlr_dir;// Generated from EasyPythonGrammar.g4 by ANTLR 4.5.2
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link EasyPythonGrammarParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface EasyPythonGrammarVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link EasyPythonGrammarParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(EasyPythonGrammarParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link EasyPythonGrammarParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStat(EasyPythonGrammarParser.StatContext ctx);
	/**
	 * Visit a parse tree produced by {@link EasyPythonGrammarParser#blockStat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlockStat(EasyPythonGrammarParser.BlockStatContext ctx);
	/**
	 * Visit a parse tree produced by {@link EasyPythonGrammarParser#ifStat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStat(EasyPythonGrammarParser.IfStatContext ctx);
	/**
	 * Visit a parse tree produced by {@link EasyPythonGrammarParser#whileStat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileStat(EasyPythonGrammarParser.WhileStatContext ctx);
	/**
	 * Visit a parse tree produced by {@link EasyPythonGrammarParser#returnStat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnStat(EasyPythonGrammarParser.ReturnStatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code GetField}
	 * labeled alternative in {@link EasyPythonGrammarParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGetField(EasyPythonGrammarParser.GetFieldContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Or}
	 * labeled alternative in {@link EasyPythonGrammarParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOr(EasyPythonGrammarParser.OrContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AddSub}
	 * labeled alternative in {@link EasyPythonGrammarParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddSub(EasyPythonGrammarParser.AddSubContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Parens}
	 * labeled alternative in {@link EasyPythonGrammarParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParens(EasyPythonGrammarParser.ParensContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Var}
	 * labeled alternative in {@link EasyPythonGrammarParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVar(EasyPythonGrammarParser.VarContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Constant}
	 * labeled alternative in {@link EasyPythonGrammarParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstant(EasyPythonGrammarParser.ConstantContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Cmp}
	 * labeled alternative in {@link EasyPythonGrammarParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCmp(EasyPythonGrammarParser.CmpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Eq}
	 * labeled alternative in {@link EasyPythonGrammarParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEq(EasyPythonGrammarParser.EqContext ctx);
	/**
	 * Visit a parse tree produced by the {@code UnaryExpr}
	 * labeled alternative in {@link EasyPythonGrammarParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryExpr(EasyPythonGrammarParser.UnaryExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Array}
	 * labeled alternative in {@link EasyPythonGrammarParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArray(EasyPythonGrammarParser.ArrayContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Function}
	 * labeled alternative in {@link EasyPythonGrammarParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunction(EasyPythonGrammarParser.FunctionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code MulDivMod}
	 * labeled alternative in {@link EasyPythonGrammarParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMulDivMod(EasyPythonGrammarParser.MulDivModContext ctx);
	/**
	 * Visit a parse tree produced by the {@code And}
	 * labeled alternative in {@link EasyPythonGrammarParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnd(EasyPythonGrammarParser.AndContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Assign}
	 * labeled alternative in {@link EasyPythonGrammarParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssign(EasyPythonGrammarParser.AssignContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FunctionCall}
	 * labeled alternative in {@link EasyPythonGrammarParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionCall(EasyPythonGrammarParser.FunctionCallContext ctx);
	/**
	 * Visit a parse tree produced by the {@code PutField}
	 * labeled alternative in {@link EasyPythonGrammarParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPutField(EasyPythonGrammarParser.PutFieldContext ctx);
	/**
	 * Visit a parse tree produced by {@link EasyPythonGrammarParser#functionArgs}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionArgs(EasyPythonGrammarParser.FunctionArgsContext ctx);
	/**
	 * Visit a parse tree produced by {@link EasyPythonGrammarParser#functionParams}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionParams(EasyPythonGrammarParser.FunctionParamsContext ctx);
	/**
	 * Visit a parse tree produced by {@link EasyPythonGrammarParser#index}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIndex(EasyPythonGrammarParser.IndexContext ctx);
	/**
	 * Visit a parse tree produced by {@link EasyPythonGrammarParser#field}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitField(EasyPythonGrammarParser.FieldContext ctx);
}