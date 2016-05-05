// Generated from /Users/ssdmitriev/Python3Compiler/src/main/java/antlr_dir/EasyPythonGrammar.g4 by ANTLR 4.5.1
package antlr_dir;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class EasyPythonGrammarLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.5.1", RuntimeMetaData.VERSION); }

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
		STR=44, BOOL=45, WS=46;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"DEF", "RETURN", "IF", "ELIF", "ELSE", "WHILE", "LAMBDA", "OR", "AND", 
		"NOT", "IS", "NONE", "TRUE", "FALSE", "CLASS", "PASS", "CONTINUE", "BREAK", 
		"NEWLINE", "DOT", "STAR", "OPEN_PAREN", "CLOSE_PAREN", "COMMA", "COLON", 
		"ASSIGN", "OPEN_BRACK", "CLOSE_BRACK", "ADD", "MINUS", "DIV", "MOD", "IDIV", 
		"OPEN_BRACE", "CLOSE_BRACE", "LESS_THAN", "GREATER_THAN", "EQUALS", "GT_EQ", 
		"LT_EQ", "NOT_EQ", "COMMENT", "ID", "NUM", "STR", "BOOL", "DIGIT", "ID_LETTER", 
		"ESC", "WS"
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
		"EQUALS", "GT_EQ", "LT_EQ", "NOT_EQ", "ID", "NUM", "STR", "BOOL", "WS"
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



	  // A queue where extra tokens are pushed on (see the NEWLINE lexer rule).
	  private java.util.LinkedList<Token> tokens = new java.util.LinkedList<>();

	  // The stack that keeps track of the indentation level.
	  private java.util.Stack<Integer> indents = new java.util.Stack<>();

	  // The amount of opened braces, brackets and parenthesis.
	  private int opened = 0;

	  // The most recently produced token.
	  private Token lastToken = null;

	  @Override
	  public void emit(Token t) {
	    super.setToken(t);
	    tokens.offer(t);
	  }

	  @Override
	  public Token nextToken() {

	    // Check if the end-of-file is ahead and there are still some DEDENTS expected.
	    if (_input.LA(1) == EOF && !this.indents.isEmpty()) {

	      // Remove any trailing EOF tokens from our buffer.
	      for (int i = tokens.size() - 1; i >= 0; i--) {
	        if (tokens.get(i).getType() == EOF) {
	          tokens.remove(i);
	        }
	      }

	      // First emit an extra line break that serves as the end of the statement.
	      this.emit(commonToken(EasyPythonGrammarParser.NEWLINE, "\n"));

	      // Now emit as much DEDENT tokens as needed.
	      while (!indents.isEmpty()) {
	        this.emit(createDedent());
	        indents.pop();
	      }

	      // Put the EOF back on the token stream.
	      this.emit(commonToken(EasyPythonGrammarParser.EOF, "<EOF>"));
	    }

	    Token next = super.nextToken();

	    if (next.getChannel() == Token.DEFAULT_CHANNEL) {
	      // Keep track of the last token on the default channel.
	      this.lastToken = next;
	    }

	    return tokens.isEmpty() ? next : tokens.poll();
	  }

	  private Token createDedent() {
	    CommonToken dedent = commonToken(EasyPythonGrammarParser.DEDENT, "");
	    dedent.setLine(this.lastToken.getLine());
	    return dedent;
	  }

	  private CommonToken commonToken(int type, String text) {
	    int stop = this.getCharIndex() - 1;
	    int start = text.isEmpty() ? stop : stop - text.length() + 1;
	    return new CommonToken(this._tokenFactorySourcePair, type, DEFAULT_TOKEN_CHANNEL, start, stop);
	  }

	  // Calculates the indentation of the provided spaces, taking the
	  // following rules into account:
	  //
	  // "Tabs are replaced (from left to right) by one to eight spaces
	  //  such that the total number of characters up to and including
	  //  the replacement is a multiple of eight [...]"
	  //
	  //  -- https://docs.python.org/3.1/reference/lexical_analysis.html#indentation
	  static int getIndentationCount(String spaces) {

	    int count = 0;

	    for (char ch : spaces.toCharArray()) {
	      switch (ch) {
	        case '\t':
	          count += 8 - (count % 8);
	          break;
	        default:
	          // A normal space char.
	          count++;
	      }
	    }

	    return count;
	  }

	  boolean atStartOfInput() {
	    return super.getCharPositionInLine() == 0 && super.getLine() == 1;
	  }


	public EasyPythonGrammarLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "EasyPythonGrammar.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	@Override
	public void action(RuleContext _localctx, int ruleIndex, int actionIndex) {
		switch (ruleIndex) {
		case 18:
			NEWLINE_action((RuleContext)_localctx, actionIndex);
			break;
		case 21:
			OPEN_PAREN_action((RuleContext)_localctx, actionIndex);
			break;
		case 22:
			CLOSE_PAREN_action((RuleContext)_localctx, actionIndex);
			break;
		case 26:
			OPEN_BRACK_action((RuleContext)_localctx, actionIndex);
			break;
		case 27:
			CLOSE_BRACK_action((RuleContext)_localctx, actionIndex);
			break;
		case 33:
			OPEN_BRACE_action((RuleContext)_localctx, actionIndex);
			break;
		case 34:
			CLOSE_BRACE_action((RuleContext)_localctx, actionIndex);
			break;
		}
	}
	private void NEWLINE_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 0:

			     String newLine = getText().replaceAll("[^\r\n]+", "");
			     String spaces = getText().replaceAll("[\r\n]+", "");
			     int next = _input.LA(1);

			     if (opened > 0 || next == '\r' || next == '\n' || next == '#') {
			       // If we're inside a list or on a blank line, ignore all indents,
			       // dedents and line breaks.
			       skip();
			     }
			     else {
			       emit(commonToken(NEWLINE, newLine));

			       int indent = getIndentationCount(spaces);
			       int previous = indents.isEmpty() ? 0 : indents.peek();

			       if (indent == previous) {
			         // skip indents of the same size as the present indent-size
			         skip();
			       }
			       else if (indent > previous) {
			         indents.push(indent);
			         emit(commonToken(EasyPythonGrammarParser.INDENT, spaces));
			       }
			       else {
			         // Possibly emit more than 1 DEDENT token.
			         while(!indents.isEmpty() && indents.peek() > indent) {
			           this.emit(createDedent());
			           indents.pop();
			         }
			       }
			     }
			   
			break;
		}
	}
	private void OPEN_PAREN_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 1:
			opened++;
			break;
		}
	}
	private void CLOSE_PAREN_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 2:
			opened--;
			break;
		}
	}
	private void OPEN_BRACK_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 3:
			opened++;
			break;
		}
	}
	private void CLOSE_BRACK_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 4:
			opened--;
			break;
		}
	}
	private void OPEN_BRACE_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 5:
			opened++;
			break;
		}
	}
	private void CLOSE_BRACE_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 6:
			opened--;
			break;
		}
	}
	@Override
	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 18:
			return NEWLINE_sempred((RuleContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean NEWLINE_sempred(RuleContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return atStartOfInput();
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\60\u0164\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t"+
		" \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t"+
		"+\4,\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\3\2"+
		"\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3"+
		"\5\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b"+
		"\3\b\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\r\3"+
		"\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\3\20\3\20\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\22\3\22\3\22"+
		"\3\22\3\22\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\23\3\24\3\24"+
		"\3\24\5\24\u00c8\n\24\3\24\3\24\5\24\u00cc\n\24\3\24\7\24\u00cf\n\24\f"+
		"\24\16\24\u00d2\13\24\5\24\u00d4\n\24\3\24\3\24\3\25\3\25\3\26\3\26\3"+
		"\27\3\27\3\27\3\30\3\30\3\30\3\31\3\31\3\32\3\32\3\33\3\33\3\34\3\34\3"+
		"\34\3\35\3\35\3\35\3\36\3\36\3\37\3\37\3 \3 \3!\3!\3\"\3\"\3\"\3#\3#\3"+
		"#\3$\3$\3$\3%\3%\3&\3&\3\'\3\'\3\'\3(\3(\3(\3)\3)\3)\3*\3*\3*\3+\3+\7"+
		"+\u0111\n+\f+\16+\u0114\13+\3,\3,\3,\7,\u0119\n,\f,\16,\u011c\13,\3-\6"+
		"-\u011f\n-\r-\16-\u0120\3-\3-\6-\u0125\n-\r-\16-\u0126\5-\u0129\n-\3-"+
		"\3-\3-\3-\3-\3-\3-\3-\3-\3-\3-\5-\u0136\n-\3.\3.\3.\7.\u013b\n.\f.\16"+
		".\u013e\13.\3.\3.\3.\3.\7.\u0144\n.\f.\16.\u0147\13.\3.\5.\u014a\n.\3"+
		"/\3/\3/\3/\3/\3/\3/\3/\3/\5/\u0155\n/\3\60\3\60\3\61\3\61\3\62\3\62\3"+
		"\62\3\63\6\63\u015f\n\63\r\63\16\63\u0160\3\63\3\63\4\u013c\u0145\2\64"+
		"\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20"+
		"\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37"+
		"= ?!A\"C#E$G%I&K\'M(O)Q*S+U\2W,Y-[.]/_\2a\2c\2e\60\3\2\t\4\2\13\13\"\""+
		"\4\2\f\f\17\17\4\2$$^^\4\2))^^\3\2\62;\6\2&&C\\aac|\n\2$$\61\61^^ddhh"+
		"ppttvv\u0172\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2"+
		"\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2"+
		"\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2"+
		"\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2"+
		"\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3"+
		"\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2"+
		"\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2"+
		"S\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2\2e\3\2\2\2\3g\3"+
		"\2\2\2\5k\3\2\2\2\7r\3\2\2\2\tu\3\2\2\2\13z\3\2\2\2\r\177\3\2\2\2\17\u0085"+
		"\3\2\2\2\21\u008c\3\2\2\2\23\u008f\3\2\2\2\25\u0093\3\2\2\2\27\u0097\3"+
		"\2\2\2\31\u009a\3\2\2\2\33\u009f\3\2\2\2\35\u00a4\3\2\2\2\37\u00aa\3\2"+
		"\2\2!\u00b0\3\2\2\2#\u00b5\3\2\2\2%\u00be\3\2\2\2\'\u00d3\3\2\2\2)\u00d7"+
		"\3\2\2\2+\u00d9\3\2\2\2-\u00db\3\2\2\2/\u00de\3\2\2\2\61\u00e1\3\2\2\2"+
		"\63\u00e3\3\2\2\2\65\u00e5\3\2\2\2\67\u00e7\3\2\2\29\u00ea\3\2\2\2;\u00ed"+
		"\3\2\2\2=\u00ef\3\2\2\2?\u00f1\3\2\2\2A\u00f3\3\2\2\2C\u00f5\3\2\2\2E"+
		"\u00f8\3\2\2\2G\u00fb\3\2\2\2I\u00fe\3\2\2\2K\u0100\3\2\2\2M\u0102\3\2"+
		"\2\2O\u0105\3\2\2\2Q\u0108\3\2\2\2S\u010b\3\2\2\2U\u010e\3\2\2\2W\u0115"+
		"\3\2\2\2Y\u0135\3\2\2\2[\u0149\3\2\2\2]\u0154\3\2\2\2_\u0156\3\2\2\2a"+
		"\u0158\3\2\2\2c\u015a\3\2\2\2e\u015e\3\2\2\2gh\7f\2\2hi\7g\2\2ij\7h\2"+
		"\2j\4\3\2\2\2kl\7t\2\2lm\7g\2\2mn\7v\2\2no\7w\2\2op\7t\2\2pq\7p\2\2q\6"+
		"\3\2\2\2rs\7k\2\2st\7h\2\2t\b\3\2\2\2uv\7g\2\2vw\7n\2\2wx\7k\2\2xy\7h"+
		"\2\2y\n\3\2\2\2z{\7g\2\2{|\7n\2\2|}\7u\2\2}~\7g\2\2~\f\3\2\2\2\177\u0080"+
		"\7y\2\2\u0080\u0081\7j\2\2\u0081\u0082\7k\2\2\u0082\u0083\7n\2\2\u0083"+
		"\u0084\7g\2\2\u0084\16\3\2\2\2\u0085\u0086\7n\2\2\u0086\u0087\7c\2\2\u0087"+
		"\u0088\7o\2\2\u0088\u0089\7d\2\2\u0089\u008a\7f\2\2\u008a\u008b\7c\2\2"+
		"\u008b\20\3\2\2\2\u008c\u008d\7q\2\2\u008d\u008e\7t\2\2\u008e\22\3\2\2"+
		"\2\u008f\u0090\7c\2\2\u0090\u0091\7p\2\2\u0091\u0092\7f\2\2\u0092\24\3"+
		"\2\2\2\u0093\u0094\7p\2\2\u0094\u0095\7q\2\2\u0095\u0096\7v\2\2\u0096"+
		"\26\3\2\2\2\u0097\u0098\7k\2\2\u0098\u0099\7u\2\2\u0099\30\3\2\2\2\u009a"+
		"\u009b\7P\2\2\u009b\u009c\7q\2\2\u009c\u009d\7p\2\2\u009d\u009e\7g\2\2"+
		"\u009e\32\3\2\2\2\u009f\u00a0\7V\2\2\u00a0\u00a1\7t\2\2\u00a1\u00a2\7"+
		"w\2\2\u00a2\u00a3\7g\2\2\u00a3\34\3\2\2\2\u00a4\u00a5\7H\2\2\u00a5\u00a6"+
		"\7c\2\2\u00a6\u00a7\7n\2\2\u00a7\u00a8\7u\2\2\u00a8\u00a9\7g\2\2\u00a9"+
		"\36\3\2\2\2\u00aa\u00ab\7e\2\2\u00ab\u00ac\7n\2\2\u00ac\u00ad\7c\2\2\u00ad"+
		"\u00ae\7u\2\2\u00ae\u00af\7u\2\2\u00af \3\2\2\2\u00b0\u00b1\7r\2\2\u00b1"+
		"\u00b2\7c\2\2\u00b2\u00b3\7u\2\2\u00b3\u00b4\7u\2\2\u00b4\"\3\2\2\2\u00b5"+
		"\u00b6\7e\2\2\u00b6\u00b7\7q\2\2\u00b7\u00b8\7p\2\2\u00b8\u00b9\7v\2\2"+
		"\u00b9\u00ba\7k\2\2\u00ba\u00bb\7p\2\2\u00bb\u00bc\7w\2\2\u00bc\u00bd"+
		"\7g\2\2\u00bd$\3\2\2\2\u00be\u00bf\7d\2\2\u00bf\u00c0\7t\2\2\u00c0\u00c1"+
		"\7g\2\2\u00c1\u00c2\7c\2\2\u00c2\u00c3\7m\2\2\u00c3&\3\2\2\2\u00c4\u00c5"+
		"\6\24\2\2\u00c5\u00d4\5e\63\2\u00c6\u00c8\7\17\2\2\u00c7\u00c6\3\2\2\2"+
		"\u00c7\u00c8\3\2\2\2\u00c8\u00c9\3\2\2\2\u00c9\u00cc\7\f\2\2\u00ca\u00cc"+
		"\7\17\2\2\u00cb\u00c7\3\2\2\2\u00cb\u00ca\3\2\2\2\u00cc\u00d0\3\2\2\2"+
		"\u00cd\u00cf\t\2\2\2\u00ce\u00cd\3\2\2\2\u00cf\u00d2\3\2\2\2\u00d0\u00ce"+
		"\3\2\2\2\u00d0\u00d1\3\2\2\2\u00d1\u00d4\3\2\2\2\u00d2\u00d0\3\2\2\2\u00d3"+
		"\u00c4\3\2\2\2\u00d3\u00cb\3\2\2\2\u00d4\u00d5\3\2\2\2\u00d5\u00d6\b\24"+
		"\2\2\u00d6(\3\2\2\2\u00d7\u00d8\7\60\2\2\u00d8*\3\2\2\2\u00d9\u00da\7"+
		",\2\2\u00da,\3\2\2\2\u00db\u00dc\7*\2\2\u00dc\u00dd\b\27\3\2\u00dd.\3"+
		"\2\2\2\u00de\u00df\7+\2\2\u00df\u00e0\b\30\4\2\u00e0\60\3\2\2\2\u00e1"+
		"\u00e2\7.\2\2\u00e2\62\3\2\2\2\u00e3\u00e4\7<\2\2\u00e4\64\3\2\2\2\u00e5"+
		"\u00e6\7?\2\2\u00e6\66\3\2\2\2\u00e7\u00e8\7]\2\2\u00e8\u00e9\b\34\5\2"+
		"\u00e98\3\2\2\2\u00ea\u00eb\7_\2\2\u00eb\u00ec\b\35\6\2\u00ec:\3\2\2\2"+
		"\u00ed\u00ee\7-\2\2\u00ee<\3\2\2\2\u00ef\u00f0\7/\2\2\u00f0>\3\2\2\2\u00f1"+
		"\u00f2\7\61\2\2\u00f2@\3\2\2\2\u00f3\u00f4\7\'\2\2\u00f4B\3\2\2\2\u00f5"+
		"\u00f6\7\61\2\2\u00f6\u00f7\7\61\2\2\u00f7D\3\2\2\2\u00f8\u00f9\7}\2\2"+
		"\u00f9\u00fa\b#\7\2\u00faF\3\2\2\2\u00fb\u00fc\7\177\2\2\u00fc\u00fd\b"+
		"$\b\2\u00fdH\3\2\2\2\u00fe\u00ff\7>\2\2\u00ffJ\3\2\2\2\u0100\u0101\7@"+
		"\2\2\u0101L\3\2\2\2\u0102\u0103\7?\2\2\u0103\u0104\7?\2\2\u0104N\3\2\2"+
		"\2\u0105\u0106\7@\2\2\u0106\u0107\7?\2\2\u0107P\3\2\2\2\u0108\u0109\7"+
		">\2\2\u0109\u010a\7?\2\2\u010aR\3\2\2\2\u010b\u010c\7#\2\2\u010c\u010d"+
		"\7?\2\2\u010dT\3\2\2\2\u010e\u0112\7%\2\2\u010f\u0111\n\3\2\2\u0110\u010f"+
		"\3\2\2\2\u0111\u0114\3\2\2\2\u0112\u0110\3\2\2\2\u0112\u0113\3\2\2\2\u0113"+
		"V\3\2\2\2\u0114\u0112\3\2\2\2\u0115\u011a\5a\61\2\u0116\u0119\5a\61\2"+
		"\u0117\u0119\5_\60\2\u0118\u0116\3\2\2\2\u0118\u0117\3\2\2\2\u0119\u011c"+
		"\3\2\2\2\u011a\u0118\3\2\2\2\u011a\u011b\3\2\2\2\u011bX\3\2\2\2\u011c"+
		"\u011a\3\2\2\2\u011d\u011f\5_\60\2\u011e\u011d\3\2\2\2\u011f\u0120\3\2"+
		"\2\2\u0120\u011e\3\2\2\2\u0120\u0121\3\2\2\2\u0121\u0128\3\2\2\2\u0122"+
		"\u0124\7\60\2\2\u0123\u0125\5_\60\2\u0124\u0123\3\2\2\2\u0125\u0126\3"+
		"\2\2\2\u0126\u0124\3\2\2\2\u0126\u0127\3\2\2\2\u0127\u0129\3\2\2\2\u0128"+
		"\u0122\3\2\2\2\u0128\u0129\3\2\2\2\u0129\u0136\3\2\2\2\u012a\u012b\7P"+
		"\2\2\u012b\u012c\7c\2\2\u012c\u0136\7P\2\2\u012d\u012e\7K\2\2\u012e\u012f"+
		"\7p\2\2\u012f\u0130\7h\2\2\u0130\u0131\7k\2\2\u0131\u0132\7p\2\2\u0132"+
		"\u0133\7k\2\2\u0133\u0134\7v\2\2\u0134\u0136\7{\2\2\u0135\u011e\3\2\2"+
		"\2\u0135\u012a\3\2\2\2\u0135\u012d\3\2\2\2\u0136Z\3\2\2\2\u0137\u013c"+
		"\7$\2\2\u0138\u013b\5c\62\2\u0139\u013b\n\4\2\2\u013a\u0138\3\2\2\2\u013a"+
		"\u0139\3\2\2\2\u013b\u013e\3\2\2\2\u013c\u013d\3\2\2\2\u013c\u013a\3\2"+
		"\2\2\u013d\u013f\3\2\2\2\u013e\u013c\3\2\2\2\u013f\u014a\7$\2\2\u0140"+
		"\u0145\7)\2\2\u0141\u0144\5c\62\2\u0142\u0144\n\5\2\2\u0143\u0141\3\2"+
		"\2\2\u0143\u0142\3\2\2\2\u0144\u0147\3\2\2\2\u0145\u0146\3\2\2\2\u0145"+
		"\u0143\3\2\2\2\u0146\u0148\3\2\2\2\u0147\u0145\3\2\2\2\u0148\u014a\7)"+
		"\2\2\u0149\u0137\3\2\2\2\u0149\u0140\3\2\2\2\u014a\\\3\2\2\2\u014b\u014c"+
		"\7V\2\2\u014c\u014d\7t\2\2\u014d\u014e\7w\2\2\u014e\u0155\7g\2\2\u014f"+
		"\u0150\7H\2\2\u0150\u0151\7c\2\2\u0151\u0152\7n\2\2\u0152\u0153\7u\2\2"+
		"\u0153\u0155\7g\2\2\u0154\u014b\3\2\2\2\u0154\u014f\3\2\2\2\u0155^\3\2"+
		"\2\2\u0156\u0157\t\6\2\2\u0157`\3\2\2\2\u0158\u0159\t\7\2\2\u0159b\3\2"+
		"\2\2\u015a\u015b\7^\2\2\u015b\u015c\t\b\2\2\u015cd\3\2\2\2\u015d\u015f"+
		"\t\2\2\2\u015e\u015d\3\2\2\2\u015f\u0160\3\2\2\2\u0160\u015e\3\2\2\2\u0160"+
		"\u0161\3\2\2\2\u0161\u0162\3\2\2\2\u0162\u0163\b\63\t\2\u0163f\3\2\2\2"+
		"\25\2\u00c7\u00cb\u00d0\u00d3\u0112\u0118\u011a\u0120\u0126\u0128\u0135"+
		"\u013a\u013c\u0143\u0145\u0149\u0154\u0160\n\3\24\2\3\27\3\3\30\4\3\34"+
		"\5\3\35\6\3#\7\3$\b\2\3\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}