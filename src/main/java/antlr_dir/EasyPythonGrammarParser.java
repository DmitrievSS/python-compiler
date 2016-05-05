// Generated from EasyPythonGrammar.g4 by ANTLR 4.5.3
package antlr_dir;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class EasyPythonGrammarParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.5.3", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		DEF=1, RETURN=2, IF=3, ELIF=4, ELSE=5, WHILE=6, LAMBDA=7, OR=8, AND=9, 
		NOT=10, IS=11, NONE=12, TRUE=13, FALSE=14, CLASS=15, PASS=16, CONTINUE=17, 
		BREAK=18, NEWLINE=19, DOT=20, STAR=21, OPEN_PAREN=22, CLOSE_PAREN=23, 
		COMMA=24, COLON=25, ASSIGN=26, OPEN_BRACK=27, CLOSE_BRACK=28, ADD=29, 
		MINUS=30, DIV=31, MOD=32, IDIV=33, OPEN_BRACE=34, CLOSE_BRACE=35, LESS_THAN=36, 
		GREATER_THAN=37, EQUALS=38, GT_EQ=39, LT_EQ=40, NOT_EQ=41, ID=42, NUM=43, 
		STR=44, BOOL=45, WS=46, INDENT=47, DEDENT=48;
	public static final int
		RULE_program = 0, RULE_stat = 1, RULE_blockStat = 2, RULE_ifStat = 3, 
		RULE_whileStat = 4, RULE_returnStat = 5, RULE_expr = 6, RULE_functionArgs = 7, 
		RULE_functionParams = 8, RULE_index = 9, RULE_field = 10;
	public static final String[] ruleNames = {
		"program", "stat", "blockStat", "ifStat", "whileStat", "returnStat", "expr", 
		"functionArgs", "functionParams", "index", "field"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'def'", "'return'", "'if'", "'elif'", "'else'", "'while'", "'lambda'", 
		"'or'", "'and'", "'not'", "'is'", "'None'", "'True'", "'False'", "'class'", 
		"'pass'", "'continue'", "'break'", null, "'.'", "'*'", "'('", "')'", "','", 
		"':'", "'='", "'['", "']'", "'+'", "'-'", "'/'", "'%'", "'//'", "'{'", 
		"'}'", "'<'", "'>'", "'=='", "'>='", "'<='", "'!='"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "DEF", "RETURN", "IF", "ELIF", "ELSE", "WHILE", "LAMBDA", "OR", 
		"AND", "NOT", "IS", "NONE", "TRUE", "FALSE", "CLASS", "PASS", "CONTINUE", 
		"BREAK", "NEWLINE", "DOT", "STAR", "OPEN_PAREN", "CLOSE_PAREN", "COMMA", 
		"COLON", "ASSIGN", "OPEN_BRACK", "CLOSE_BRACK", "ADD", "MINUS", "DIV", 
		"MOD", "IDIV", "OPEN_BRACE", "CLOSE_BRACE", "LESS_THAN", "GREATER_THAN", 
		"EQUALS", "GT_EQ", "LT_EQ", "NOT_EQ", "ID", "NUM", "STR", "BOOL", "WS", 
		"INDENT", "DEDENT"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "EasyPythonGrammar.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public EasyPythonGrammarParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ProgramContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(EasyPythonGrammarParser.EOF, 0); }
		public List<StatContext> stat() {
			return getRuleContexts(StatContext.class);
		}
		public StatContext stat(int i) {
			return getRuleContext(StatContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EasyPythonGrammarListener ) ((EasyPythonGrammarListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EasyPythonGrammarListener ) ((EasyPythonGrammarListener)listener).exitProgram(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EasyPythonGrammarVisitor ) return ((EasyPythonGrammarVisitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(25);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << DEF) | (1L << RETURN) | (1L << IF) | (1L << WHILE) | (1L << NOT) | (1L << NEWLINE) | (1L << OPEN_PAREN) | (1L << OPEN_BRACK) | (1L << ADD) | (1L << MINUS) | (1L << ID) | (1L << NUM) | (1L << STR) | (1L << BOOL))) != 0)) {
				{
				{
				setState(22);
				stat();
				}
				}
				setState(27);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(28);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StatContext extends ParserRuleContext {
		public BlockStatContext blockStat() {
			return getRuleContext(BlockStatContext.class,0);
		}
		public IfStatContext ifStat() {
			return getRuleContext(IfStatContext.class,0);
		}
		public WhileStatContext whileStat() {
			return getRuleContext(WhileStatContext.class,0);
		}
		public ReturnStatContext returnStat() {
			return getRuleContext(ReturnStatContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public StatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stat; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EasyPythonGrammarListener ) ((EasyPythonGrammarListener)listener).enterStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EasyPythonGrammarListener ) ((EasyPythonGrammarListener)listener).exitStat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EasyPythonGrammarVisitor ) return ((EasyPythonGrammarVisitor<? extends T>)visitor).visitStat(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatContext stat() throws RecognitionException {
		StatContext _localctx = new StatContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_stat);
		try {
			setState(35);
			switch (_input.LA(1)) {
			case NEWLINE:
				enterOuterAlt(_localctx, 1);
				{
				setState(30);
				blockStat();
				}
				break;
			case IF:
				enterOuterAlt(_localctx, 2);
				{
				setState(31);
				ifStat();
				}
				break;
			case WHILE:
				enterOuterAlt(_localctx, 3);
				{
				setState(32);
				whileStat();
				}
				break;
			case RETURN:
				enterOuterAlt(_localctx, 4);
				{
				setState(33);
				returnStat();
				}
				break;
			case DEF:
			case NOT:
			case OPEN_PAREN:
			case OPEN_BRACK:
			case ADD:
			case MINUS:
			case ID:
			case NUM:
			case STR:
			case BOOL:
				enterOuterAlt(_localctx, 5);
				{
				setState(34);
				expr(0);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BlockStatContext extends ParserRuleContext {
		public TerminalNode NEWLINE() { return getToken(EasyPythonGrammarParser.NEWLINE, 0); }
		public TerminalNode INDENT() { return getToken(EasyPythonGrammarParser.INDENT, 0); }
		public TerminalNode DEDENT() { return getToken(EasyPythonGrammarParser.DEDENT, 0); }
		public List<StatContext> stat() {
			return getRuleContexts(StatContext.class);
		}
		public StatContext stat(int i) {
			return getRuleContext(StatContext.class,i);
		}
		public BlockStatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_blockStat; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EasyPythonGrammarListener ) ((EasyPythonGrammarListener)listener).enterBlockStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EasyPythonGrammarListener ) ((EasyPythonGrammarListener)listener).exitBlockStat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EasyPythonGrammarVisitor ) return ((EasyPythonGrammarVisitor<? extends T>)visitor).visitBlockStat(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockStatContext blockStat() throws RecognitionException {
		BlockStatContext _localctx = new BlockStatContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_blockStat);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(37);
			match(NEWLINE);
			setState(38);
			match(INDENT);
			setState(40); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(39);
				stat();
				}
				}
				setState(42); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << DEF) | (1L << RETURN) | (1L << IF) | (1L << WHILE) | (1L << NOT) | (1L << NEWLINE) | (1L << OPEN_PAREN) | (1L << OPEN_BRACK) | (1L << ADD) | (1L << MINUS) | (1L << ID) | (1L << NUM) | (1L << STR) | (1L << BOOL))) != 0) );
			setState(44);
			match(DEDENT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IfStatContext extends ParserRuleContext {
		public TerminalNode IF() { return getToken(EasyPythonGrammarParser.IF, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public List<TerminalNode> COLON() { return getTokens(EasyPythonGrammarParser.COLON); }
		public TerminalNode COLON(int i) {
			return getToken(EasyPythonGrammarParser.COLON, i);
		}
		public List<StatContext> stat() {
			return getRuleContexts(StatContext.class);
		}
		public StatContext stat(int i) {
			return getRuleContext(StatContext.class,i);
		}
		public TerminalNode ELSE() { return getToken(EasyPythonGrammarParser.ELSE, 0); }
		public IfStatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifStat; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EasyPythonGrammarListener ) ((EasyPythonGrammarListener)listener).enterIfStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EasyPythonGrammarListener ) ((EasyPythonGrammarListener)listener).exitIfStat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EasyPythonGrammarVisitor ) return ((EasyPythonGrammarVisitor<? extends T>)visitor).visitIfStat(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IfStatContext ifStat() throws RecognitionException {
		IfStatContext _localctx = new IfStatContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_ifStat);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(46);
			match(IF);
			setState(47);
			expr(0);
			setState(48);
			match(COLON);
			setState(49);
			stat();
			setState(53);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				{
				setState(50);
				match(ELSE);
				setState(51);
				match(COLON);
				setState(52);
				stat();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class WhileStatContext extends ParserRuleContext {
		public TerminalNode WHILE() { return getToken(EasyPythonGrammarParser.WHILE, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode COLON() { return getToken(EasyPythonGrammarParser.COLON, 0); }
		public StatContext stat() {
			return getRuleContext(StatContext.class,0);
		}
		public WhileStatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whileStat; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EasyPythonGrammarListener ) ((EasyPythonGrammarListener)listener).enterWhileStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EasyPythonGrammarListener ) ((EasyPythonGrammarListener)listener).exitWhileStat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EasyPythonGrammarVisitor ) return ((EasyPythonGrammarVisitor<? extends T>)visitor).visitWhileStat(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WhileStatContext whileStat() throws RecognitionException {
		WhileStatContext _localctx = new WhileStatContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_whileStat);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(55);
			match(WHILE);
			setState(56);
			expr(0);
			setState(57);
			match(COLON);
			setState(58);
			stat();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ReturnStatContext extends ParserRuleContext {
		public TerminalNode RETURN() { return getToken(EasyPythonGrammarParser.RETURN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ReturnStatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_returnStat; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EasyPythonGrammarListener ) ((EasyPythonGrammarListener)listener).enterReturnStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EasyPythonGrammarListener ) ((EasyPythonGrammarListener)listener).exitReturnStat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EasyPythonGrammarVisitor ) return ((EasyPythonGrammarVisitor<? extends T>)visitor).visitReturnStat(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReturnStatContext returnStat() throws RecognitionException {
		ReturnStatContext _localctx = new ReturnStatContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_returnStat);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(60);
			match(RETURN);
			setState(62);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				{
				setState(61);
				expr(0);
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExprContext extends ParserRuleContext {
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
	 
		public ExprContext() { }
		public void copyFrom(ExprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class GetFieldContext extends ExprContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public IndexContext index() {
			return getRuleContext(IndexContext.class,0);
		}
		public FieldContext field() {
			return getRuleContext(FieldContext.class,0);
		}
		public GetFieldContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EasyPythonGrammarListener ) ((EasyPythonGrammarListener)listener).enterGetField(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EasyPythonGrammarListener ) ((EasyPythonGrammarListener)listener).exitGetField(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EasyPythonGrammarVisitor ) return ((EasyPythonGrammarVisitor<? extends T>)visitor).visitGetField(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class OrContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode OR() { return getToken(EasyPythonGrammarParser.OR, 0); }
		public OrContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EasyPythonGrammarListener ) ((EasyPythonGrammarListener)listener).enterOr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EasyPythonGrammarListener ) ((EasyPythonGrammarListener)listener).exitOr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EasyPythonGrammarVisitor ) return ((EasyPythonGrammarVisitor<? extends T>)visitor).visitOr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AddSubContext extends ExprContext {
		public Token op;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode ADD() { return getToken(EasyPythonGrammarParser.ADD, 0); }
		public TerminalNode MINUS() { return getToken(EasyPythonGrammarParser.MINUS, 0); }
		public AddSubContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EasyPythonGrammarListener ) ((EasyPythonGrammarListener)listener).enterAddSub(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EasyPythonGrammarListener ) ((EasyPythonGrammarListener)listener).exitAddSub(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EasyPythonGrammarVisitor ) return ((EasyPythonGrammarVisitor<? extends T>)visitor).visitAddSub(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ParensContext extends ExprContext {
		public TerminalNode OPEN_PAREN() { return getToken(EasyPythonGrammarParser.OPEN_PAREN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode CLOSE_PAREN() { return getToken(EasyPythonGrammarParser.CLOSE_PAREN, 0); }
		public ParensContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EasyPythonGrammarListener ) ((EasyPythonGrammarListener)listener).enterParens(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EasyPythonGrammarListener ) ((EasyPythonGrammarListener)listener).exitParens(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EasyPythonGrammarVisitor ) return ((EasyPythonGrammarVisitor<? extends T>)visitor).visitParens(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class VarContext extends ExprContext {
		public TerminalNode ID() { return getToken(EasyPythonGrammarParser.ID, 0); }
		public VarContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EasyPythonGrammarListener ) ((EasyPythonGrammarListener)listener).enterVar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EasyPythonGrammarListener ) ((EasyPythonGrammarListener)listener).exitVar(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EasyPythonGrammarVisitor ) return ((EasyPythonGrammarVisitor<? extends T>)visitor).visitVar(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ConstantContext extends ExprContext {
		public TerminalNode NUM() { return getToken(EasyPythonGrammarParser.NUM, 0); }
		public TerminalNode STR() { return getToken(EasyPythonGrammarParser.STR, 0); }
		public TerminalNode BOOL() { return getToken(EasyPythonGrammarParser.BOOL, 0); }
		public ConstantContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EasyPythonGrammarListener ) ((EasyPythonGrammarListener)listener).enterConstant(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EasyPythonGrammarListener ) ((EasyPythonGrammarListener)listener).exitConstant(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EasyPythonGrammarVisitor ) return ((EasyPythonGrammarVisitor<? extends T>)visitor).visitConstant(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CmpContext extends ExprContext {
		public Token op;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode LESS_THAN() { return getToken(EasyPythonGrammarParser.LESS_THAN, 0); }
		public TerminalNode LT_EQ() { return getToken(EasyPythonGrammarParser.LT_EQ, 0); }
		public TerminalNode GREATER_THAN() { return getToken(EasyPythonGrammarParser.GREATER_THAN, 0); }
		public TerminalNode GT_EQ() { return getToken(EasyPythonGrammarParser.GT_EQ, 0); }
		public CmpContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EasyPythonGrammarListener ) ((EasyPythonGrammarListener)listener).enterCmp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EasyPythonGrammarListener ) ((EasyPythonGrammarListener)listener).exitCmp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EasyPythonGrammarVisitor ) return ((EasyPythonGrammarVisitor<? extends T>)visitor).visitCmp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class EqContext extends ExprContext {
		public Token op;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode EQUALS() { return getToken(EasyPythonGrammarParser.EQUALS, 0); }
		public TerminalNode NOT_EQ() { return getToken(EasyPythonGrammarParser.NOT_EQ, 0); }
		public EqContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EasyPythonGrammarListener ) ((EasyPythonGrammarListener)listener).enterEq(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EasyPythonGrammarListener ) ((EasyPythonGrammarListener)listener).exitEq(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EasyPythonGrammarVisitor ) return ((EasyPythonGrammarVisitor<? extends T>)visitor).visitEq(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class UnaryExprContext extends ExprContext {
		public Token op;
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode NOT() { return getToken(EasyPythonGrammarParser.NOT, 0); }
		public TerminalNode MINUS() { return getToken(EasyPythonGrammarParser.MINUS, 0); }
		public TerminalNode ADD() { return getToken(EasyPythonGrammarParser.ADD, 0); }
		public UnaryExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EasyPythonGrammarListener ) ((EasyPythonGrammarListener)listener).enterUnaryExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EasyPythonGrammarListener ) ((EasyPythonGrammarListener)listener).exitUnaryExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EasyPythonGrammarVisitor ) return ((EasyPythonGrammarVisitor<? extends T>)visitor).visitUnaryExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ArrayContext extends ExprContext {
		public TerminalNode OPEN_BRACK() { return getToken(EasyPythonGrammarParser.OPEN_BRACK, 0); }
		public TerminalNode CLOSE_BRACK() { return getToken(EasyPythonGrammarParser.CLOSE_BRACK, 0); }
		public FunctionArgsContext functionArgs() {
			return getRuleContext(FunctionArgsContext.class,0);
		}
		public ArrayContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EasyPythonGrammarListener ) ((EasyPythonGrammarListener)listener).enterArray(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EasyPythonGrammarListener ) ((EasyPythonGrammarListener)listener).exitArray(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EasyPythonGrammarVisitor ) return ((EasyPythonGrammarVisitor<? extends T>)visitor).visitArray(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FunctionContext extends ExprContext {
		public TerminalNode ID() { return getToken(EasyPythonGrammarParser.ID, 0); }
		public TerminalNode OPEN_PAREN() { return getToken(EasyPythonGrammarParser.OPEN_PAREN, 0); }
		public TerminalNode CLOSE_PAREN() { return getToken(EasyPythonGrammarParser.CLOSE_PAREN, 0); }
		public BlockStatContext blockStat() {
			return getRuleContext(BlockStatContext.class,0);
		}
		public FunctionParamsContext functionParams() {
			return getRuleContext(FunctionParamsContext.class,0);
		}
		public FunctionContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EasyPythonGrammarListener ) ((EasyPythonGrammarListener)listener).enterFunction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EasyPythonGrammarListener ) ((EasyPythonGrammarListener)listener).exitFunction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EasyPythonGrammarVisitor ) return ((EasyPythonGrammarVisitor<? extends T>)visitor).visitFunction(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class MulDivModContext extends ExprContext {
		public Token op;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode STAR() { return getToken(EasyPythonGrammarParser.STAR, 0); }
		public TerminalNode DIV() { return getToken(EasyPythonGrammarParser.DIV, 0); }
		public TerminalNode MOD() { return getToken(EasyPythonGrammarParser.MOD, 0); }
		public MulDivModContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EasyPythonGrammarListener ) ((EasyPythonGrammarListener)listener).enterMulDivMod(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EasyPythonGrammarListener ) ((EasyPythonGrammarListener)listener).exitMulDivMod(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EasyPythonGrammarVisitor ) return ((EasyPythonGrammarVisitor<? extends T>)visitor).visitMulDivMod(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AndContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode AND() { return getToken(EasyPythonGrammarParser.AND, 0); }
		public AndContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EasyPythonGrammarListener ) ((EasyPythonGrammarListener)listener).enterAnd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EasyPythonGrammarListener ) ((EasyPythonGrammarListener)listener).exitAnd(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EasyPythonGrammarVisitor ) return ((EasyPythonGrammarVisitor<? extends T>)visitor).visitAnd(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AssignContext extends ExprContext {
		public TerminalNode ID() { return getToken(EasyPythonGrammarParser.ID, 0); }
		public TerminalNode ASSIGN() { return getToken(EasyPythonGrammarParser.ASSIGN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public AssignContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EasyPythonGrammarListener ) ((EasyPythonGrammarListener)listener).enterAssign(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EasyPythonGrammarListener ) ((EasyPythonGrammarListener)listener).exitAssign(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EasyPythonGrammarVisitor ) return ((EasyPythonGrammarVisitor<? extends T>)visitor).visitAssign(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FunctionCallContext extends ExprContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode OPEN_PAREN() { return getToken(EasyPythonGrammarParser.OPEN_PAREN, 0); }
		public TerminalNode CLOSE_PAREN() { return getToken(EasyPythonGrammarParser.CLOSE_PAREN, 0); }
		public FunctionArgsContext functionArgs() {
			return getRuleContext(FunctionArgsContext.class,0);
		}
		public FunctionCallContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EasyPythonGrammarListener ) ((EasyPythonGrammarListener)listener).enterFunctionCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EasyPythonGrammarListener ) ((EasyPythonGrammarListener)listener).exitFunctionCall(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EasyPythonGrammarVisitor ) return ((EasyPythonGrammarVisitor<? extends T>)visitor).visitFunctionCall(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PutFieldContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode ASSIGN() { return getToken(EasyPythonGrammarParser.ASSIGN, 0); }
		public IndexContext index() {
			return getRuleContext(IndexContext.class,0);
		}
		public FieldContext field() {
			return getRuleContext(FieldContext.class,0);
		}
		public PutFieldContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EasyPythonGrammarListener ) ((EasyPythonGrammarListener)listener).enterPutField(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EasyPythonGrammarListener ) ((EasyPythonGrammarListener)listener).exitPutField(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EasyPythonGrammarVisitor ) return ((EasyPythonGrammarVisitor<? extends T>)visitor).visitPutField(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 12;
		enterRecursionRule(_localctx, 12, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(89);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				{
				_localctx = new ParensContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(65);
				match(OPEN_PAREN);
				setState(66);
				expr(0);
				setState(67);
				match(CLOSE_PAREN);
				}
				break;
			case 2:
				{
				_localctx = new UnaryExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(69);
				((UnaryExprContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NOT) | (1L << ADD) | (1L << MINUS))) != 0)) ) {
					((UnaryExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(70);
				expr(13);
				}
				break;
			case 3:
				{
				_localctx = new AssignContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(71);
				match(ID);
				setState(72);
				match(ASSIGN);
				setState(73);
				expr(5);
				}
				break;
			case 4:
				{
				_localctx = new VarContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(74);
				match(ID);
				}
				break;
			case 5:
				{
				_localctx = new ConstantContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(75);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NUM) | (1L << STR) | (1L << BOOL))) != 0)) ) {
				_errHandler.recoverInline(this);
				} else {
					consume();
				}
				}
				break;
			case 6:
				{
				_localctx = new ArrayContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(76);
				match(OPEN_BRACK);
				setState(78);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << DEF) | (1L << NOT) | (1L << OPEN_PAREN) | (1L << OPEN_BRACK) | (1L << ADD) | (1L << MINUS) | (1L << ID) | (1L << NUM) | (1L << STR) | (1L << BOOL))) != 0)) {
					{
					setState(77);
					functionArgs();
					}
				}

				setState(80);
				match(CLOSE_BRACK);
				}
				break;
			case 7:
				{
				_localctx = new FunctionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(81);
				match(DEF);
				setState(82);
				match(ID);
				setState(83);
				match(OPEN_PAREN);
				setState(85);
				_la = _input.LA(1);
				if (_la==ID) {
					{
					setState(84);
					functionParams();
					}
				}

				setState(87);
				match(CLOSE_PAREN);
				setState(88);
				blockStat();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(130);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(128);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
					case 1:
						{
						_localctx = new MulDivModContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(91);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(92);
						((MulDivModContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << STAR) | (1L << DIV) | (1L << MOD))) != 0)) ) {
							((MulDivModContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(93);
						expr(13);
						}
						break;
					case 2:
						{
						_localctx = new AddSubContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(94);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(95);
						((AddSubContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==ADD || _la==MINUS) ) {
							((AddSubContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(96);
						expr(12);
						}
						break;
					case 3:
						{
						_localctx = new CmpContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(97);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(98);
						((CmpContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LESS_THAN) | (1L << GREATER_THAN) | (1L << GT_EQ) | (1L << LT_EQ))) != 0)) ) {
							((CmpContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(99);
						expr(11);
						}
						break;
					case 4:
						{
						_localctx = new EqContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(100);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(101);
						((EqContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==EQUALS || _la==NOT_EQ) ) {
							((EqContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(102);
						expr(10);
						}
						break;
					case 5:
						{
						_localctx = new AndContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(103);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(104);
						match(AND);
						setState(105);
						expr(9);
						}
						break;
					case 6:
						{
						_localctx = new OrContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(106);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(107);
						match(OR);
						setState(108);
						expr(8);
						}
						break;
					case 7:
						{
						_localctx = new PutFieldContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(109);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(112);
						switch (_input.LA(1)) {
						case OPEN_BRACK:
							{
							setState(110);
							index();
							}
							break;
						case DOT:
							{
							setState(111);
							field();
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						setState(114);
						match(ASSIGN);
						setState(115);
						expr(7);
						}
						break;
					case 8:
						{
						_localctx = new GetFieldContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(117);
						if (!(precpred(_ctx, 15))) throw new FailedPredicateException(this, "precpred(_ctx, 15)");
						setState(120);
						switch (_input.LA(1)) {
						case OPEN_BRACK:
							{
							setState(118);
							index();
							}
							break;
						case DOT:
							{
							setState(119);
							field();
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						}
						break;
					case 9:
						{
						_localctx = new FunctionCallContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(122);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(123);
						match(OPEN_PAREN);
						setState(125);
						_la = _input.LA(1);
						if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << DEF) | (1L << NOT) | (1L << OPEN_PAREN) | (1L << OPEN_BRACK) | (1L << ADD) | (1L << MINUS) | (1L << ID) | (1L << NUM) | (1L << STR) | (1L << BOOL))) != 0)) {
							{
							setState(124);
							functionArgs();
							}
						}

						setState(127);
						match(CLOSE_PAREN);
						}
						break;
					}
					} 
				}
				setState(132);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class FunctionArgsContext extends ParserRuleContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public FunctionArgsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionArgs; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EasyPythonGrammarListener ) ((EasyPythonGrammarListener)listener).enterFunctionArgs(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EasyPythonGrammarListener ) ((EasyPythonGrammarListener)listener).exitFunctionArgs(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EasyPythonGrammarVisitor ) return ((EasyPythonGrammarVisitor<? extends T>)visitor).visitFunctionArgs(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionArgsContext functionArgs() throws RecognitionException {
		FunctionArgsContext _localctx = new FunctionArgsContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_functionArgs);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(133);
			expr(0);
			setState(138);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(134);
				match(COMMA);
				setState(135);
				expr(0);
				}
				}
				setState(140);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FunctionParamsContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(EasyPythonGrammarParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(EasyPythonGrammarParser.ID, i);
		}
		public FunctionParamsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionParams; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EasyPythonGrammarListener ) ((EasyPythonGrammarListener)listener).enterFunctionParams(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EasyPythonGrammarListener ) ((EasyPythonGrammarListener)listener).exitFunctionParams(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EasyPythonGrammarVisitor ) return ((EasyPythonGrammarVisitor<? extends T>)visitor).visitFunctionParams(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionParamsContext functionParams() throws RecognitionException {
		FunctionParamsContext _localctx = new FunctionParamsContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_functionParams);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(141);
			match(ID);
			setState(146);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(142);
				match(COMMA);
				setState(143);
				match(ID);
				}
				}
				setState(148);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IndexContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public IndexContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_index; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EasyPythonGrammarListener ) ((EasyPythonGrammarListener)listener).enterIndex(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EasyPythonGrammarListener ) ((EasyPythonGrammarListener)listener).exitIndex(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EasyPythonGrammarVisitor ) return ((EasyPythonGrammarVisitor<? extends T>)visitor).visitIndex(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IndexContext index() throws RecognitionException {
		IndexContext _localctx = new IndexContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_index);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(149);
			match(OPEN_BRACK);
			setState(150);
			expr(0);
			setState(151);
			match(CLOSE_BRACK);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FieldContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(EasyPythonGrammarParser.ID, 0); }
		public FieldContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_field; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EasyPythonGrammarListener ) ((EasyPythonGrammarListener)listener).enterField(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EasyPythonGrammarListener ) ((EasyPythonGrammarListener)listener).exitField(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EasyPythonGrammarVisitor ) return ((EasyPythonGrammarVisitor<? extends T>)visitor).visitField(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FieldContext field() throws RecognitionException {
		FieldContext _localctx = new FieldContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_field);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(153);
			match(DOT);
			setState(154);
			match(ID);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 6:
			return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 12);
		case 1:
			return precpred(_ctx, 11);
		case 2:
			return precpred(_ctx, 10);
		case 3:
			return precpred(_ctx, 9);
		case 4:
			return precpred(_ctx, 8);
		case 5:
			return precpred(_ctx, 7);
		case 6:
			return precpred(_ctx, 6);
		case 7:
			return precpred(_ctx, 15);
		case 8:
			return precpred(_ctx, 14);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\62\u009f\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\3\2\7\2\32\n\2\f\2\16\2\35\13\2\3\2\3\2\3\3\3\3\3\3\3\3"+
		"\3\3\5\3&\n\3\3\4\3\4\3\4\6\4+\n\4\r\4\16\4,\3\4\3\4\3\5\3\5\3\5\3\5\3"+
		"\5\3\5\3\5\5\58\n\5\3\6\3\6\3\6\3\6\3\6\3\7\3\7\5\7A\n\7\3\b\3\b\3\b\3"+
		"\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\5\bQ\n\b\3\b\3\b\3\b\3\b\3"+
		"\b\5\bX\n\b\3\b\3\b\5\b\\\n\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b"+
		"\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\5\bs\n\b\3\b\3\b\3\b\3\b"+
		"\3\b\3\b\5\b{\n\b\3\b\3\b\3\b\5\b\u0080\n\b\3\b\7\b\u0083\n\b\f\b\16\b"+
		"\u0086\13\b\3\t\3\t\3\t\7\t\u008b\n\t\f\t\16\t\u008e\13\t\3\n\3\n\3\n"+
		"\7\n\u0093\n\n\f\n\16\n\u0096\13\n\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f"+
		"\2\3\16\r\2\4\6\b\n\f\16\20\22\24\26\2\b\4\2\f\f\37 \3\2-/\4\2\27\27!"+
		"\"\3\2\37 \4\2&\')*\4\2((++\u00b1\2\33\3\2\2\2\4%\3\2\2\2\6\'\3\2\2\2"+
		"\b\60\3\2\2\2\n9\3\2\2\2\f>\3\2\2\2\16[\3\2\2\2\20\u0087\3\2\2\2\22\u008f"+
		"\3\2\2\2\24\u0097\3\2\2\2\26\u009b\3\2\2\2\30\32\5\4\3\2\31\30\3\2\2\2"+
		"\32\35\3\2\2\2\33\31\3\2\2\2\33\34\3\2\2\2\34\36\3\2\2\2\35\33\3\2\2\2"+
		"\36\37\7\2\2\3\37\3\3\2\2\2 &\5\6\4\2!&\5\b\5\2\"&\5\n\6\2#&\5\f\7\2$"+
		"&\5\16\b\2% \3\2\2\2%!\3\2\2\2%\"\3\2\2\2%#\3\2\2\2%$\3\2\2\2&\5\3\2\2"+
		"\2\'(\7\25\2\2(*\7\61\2\2)+\5\4\3\2*)\3\2\2\2+,\3\2\2\2,*\3\2\2\2,-\3"+
		"\2\2\2-.\3\2\2\2./\7\62\2\2/\7\3\2\2\2\60\61\7\5\2\2\61\62\5\16\b\2\62"+
		"\63\7\33\2\2\63\67\5\4\3\2\64\65\7\7\2\2\65\66\7\33\2\2\668\5\4\3\2\67"+
		"\64\3\2\2\2\678\3\2\2\28\t\3\2\2\29:\7\b\2\2:;\5\16\b\2;<\7\33\2\2<=\5"+
		"\4\3\2=\13\3\2\2\2>@\7\4\2\2?A\5\16\b\2@?\3\2\2\2@A\3\2\2\2A\r\3\2\2\2"+
		"BC\b\b\1\2CD\7\30\2\2DE\5\16\b\2EF\7\31\2\2F\\\3\2\2\2GH\t\2\2\2H\\\5"+
		"\16\b\17IJ\7,\2\2JK\7\34\2\2K\\\5\16\b\7L\\\7,\2\2M\\\t\3\2\2NP\7\35\2"+
		"\2OQ\5\20\t\2PO\3\2\2\2PQ\3\2\2\2QR\3\2\2\2R\\\7\36\2\2ST\7\3\2\2TU\7"+
		",\2\2UW\7\30\2\2VX\5\22\n\2WV\3\2\2\2WX\3\2\2\2XY\3\2\2\2YZ\7\31\2\2Z"+
		"\\\5\6\4\2[B\3\2\2\2[G\3\2\2\2[I\3\2\2\2[L\3\2\2\2[M\3\2\2\2[N\3\2\2\2"+
		"[S\3\2\2\2\\\u0084\3\2\2\2]^\f\16\2\2^_\t\4\2\2_\u0083\5\16\b\17`a\f\r"+
		"\2\2ab\t\5\2\2b\u0083\5\16\b\16cd\f\f\2\2de\t\6\2\2e\u0083\5\16\b\rfg"+
		"\f\13\2\2gh\t\7\2\2h\u0083\5\16\b\fij\f\n\2\2jk\7\13\2\2k\u0083\5\16\b"+
		"\13lm\f\t\2\2mn\7\n\2\2n\u0083\5\16\b\nor\f\b\2\2ps\5\24\13\2qs\5\26\f"+
		"\2rp\3\2\2\2rq\3\2\2\2st\3\2\2\2tu\7\34\2\2uv\5\16\b\tv\u0083\3\2\2\2"+
		"wz\f\21\2\2x{\5\24\13\2y{\5\26\f\2zx\3\2\2\2zy\3\2\2\2{\u0083\3\2\2\2"+
		"|}\f\20\2\2}\177\7\30\2\2~\u0080\5\20\t\2\177~\3\2\2\2\177\u0080\3\2\2"+
		"\2\u0080\u0081\3\2\2\2\u0081\u0083\7\31\2\2\u0082]\3\2\2\2\u0082`\3\2"+
		"\2\2\u0082c\3\2\2\2\u0082f\3\2\2\2\u0082i\3\2\2\2\u0082l\3\2\2\2\u0082"+
		"o\3\2\2\2\u0082w\3\2\2\2\u0082|\3\2\2\2\u0083\u0086\3\2\2\2\u0084\u0082"+
		"\3\2\2\2\u0084\u0085\3\2\2\2\u0085\17\3\2\2\2\u0086\u0084\3\2\2\2\u0087"+
		"\u008c\5\16\b\2\u0088\u0089\7\32\2\2\u0089\u008b\5\16\b\2\u008a\u0088"+
		"\3\2\2\2\u008b\u008e\3\2\2\2\u008c\u008a\3\2\2\2\u008c\u008d\3\2\2\2\u008d"+
		"\21\3\2\2\2\u008e\u008c\3\2\2\2\u008f\u0094\7,\2\2\u0090\u0091\7\32\2"+
		"\2\u0091\u0093\7,\2\2\u0092\u0090\3\2\2\2\u0093\u0096\3\2\2\2\u0094\u0092"+
		"\3\2\2\2\u0094\u0095\3\2\2\2\u0095\23\3\2\2\2\u0096\u0094\3\2\2\2\u0097"+
		"\u0098\7\35\2\2\u0098\u0099\5\16\b\2\u0099\u009a\7\36\2\2\u009a\25\3\2"+
		"\2\2\u009b\u009c\7\26\2\2\u009c\u009d\7,\2\2\u009d\27\3\2\2\2\21\33%,"+
		"\67@PW[rz\177\u0082\u0084\u008c\u0094";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}