grammar EasyPythonGrammar;

tokens { INDENT, DEDENT }

@lexer::members {

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
}

program
    : stat* EOF
    ;

stat
    : blockStat
    | ifStat
    | whileStat
    | returnStat
    | expr
    ;

blockStat
    : NEWLINE INDENT stat+ DEDENT
    ;

ifStat
    : IF expr COLON stat (ELSE COLON stat)?
    ;

whileStat
    : WHILE expr COLON stat
    ;

returnStat
    : RETURN expr?
    ;

expr
    : OPEN_PAREN expr CLOSE_PAREN # Parens
    | expr (index | field) # GetField
    | expr OPEN_PAREN functionArgs? CLOSE_PAREN # FunctionCall
    | op=(NOT | MINUS | ADD) expr  # UnaryExpr
    | expr op=(STAR | DIV | MOD) expr # MulDivMod
    | expr op=(ADD | MINUS) expr  # AddSub
    | expr op=(LESS_THAN | LT_EQ | GREATER_THAN | GT_EQ) expr # Cmp
    | expr op=(EQUALS | NOT_EQ ) expr # Eq
    | expr AND expr # And
    | expr OR expr # Or
    | expr (index | field) ASSIGN expr #PutField
    | ID ASSIGN expr # Assign
    | ID # Var
    | (NUM | STR | BOOL) # Constant
    | OPEN_BRACK functionArgs? CLOSE_BRACK # Array
    | 'def' ID OPEN_PAREN functionParams? CLOSE_PAREN blockStat # Function
    ;

functionArgs
    : expr (',' expr)*
    ;

functionParams
    : ID (',' ID)*
    ;


index
    : '[' expr ']'
    ;

field
    : '.' ID
    ;



DEF : 'def';
RETURN : 'return';
IF : 'if';
ELIF : 'elif';
ELSE : 'else';
WHILE : 'while';
LAMBDA : 'lambda';
OR : 'or';
AND : 'and';
NOT : 'not';
IS : 'is';
NONE : 'None';
TRUE : 'True';
FALSE : 'False';
CLASS : 'class';
PASS : 'pass';
CONTINUE : 'continue';
BREAK : 'break';

NEWLINE
 : ( {atStartOfInput()}?   WS
   | ( '\r'? '\n' | '\r' ) [ \t]*
   )
   {
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
   }
 ;



DOT : '.';
STAR : '*';
OPEN_PAREN : '(' {opened++;};
CLOSE_PAREN : ')' {opened--;};
COMMA : ',';
COLON : ':';
ASSIGN : '=';
OPEN_BRACK : '[' {opened++;};
CLOSE_BRACK : ']' {opened--;};
ADD : '+';
MINUS : '-';
DIV : '/';
MOD : '%';
IDIV : '//';
OPEN_BRACE : '{' {opened++;};
CLOSE_BRACE : '}' {opened--;};
LESS_THAN : '<';
GREATER_THAN : '>';
EQUALS : '==';
GT_EQ : '>=';
LT_EQ : '<=';
NOT_EQ : '!=';

fragment COMMENT
 : '#' ~[\r\n]*
 ;
ID : ID_LETTER (ID_LETTER | DIGIT)* ;

NUM : (DIGIT+ ('.' DIGIT+)?) | 'NaN' | 'Infinity' ;
STR : ('"' (ESC | ~["\\])*? '"') | ('\'' (ESC | ~[\'\\])*? '\'') ;
BOOL : 'True' | 'False' ;

fragment DIGIT : [0-9] ;
fragment ID_LETTER : [a-zA-Z_$] ;
fragment ESC : '\\' ["\\/bfnrt] ;

WS  :   [ \t]+ -> channel(HIDDEN)
    ;
