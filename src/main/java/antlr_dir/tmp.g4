grammar EasyPythonGrammar;

tokens { INDENT, DEDENT }

program
    : stat*
    ;

stat
    : blockStat
    | ifStat
    | whileStat
    | returnStat
    | expr
    ;

blockStat
    : NEWLINE INDENT stat* DEDENT
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
    | expr AND expr # And
    | expr OR expr # Or
    | expr (index | field) ASSIGN expr #PutField
    | ID ASSIGN expr # Assign
    | ID # Var
    | (NUM | STR | BOOL) # Constant
    | OPEN_BRACK functionArgs? CLOSE_BRACK # Array
    | DEF OPEN_PAREN functionParams? CLOSE_PAREN blockStat # Function
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

fragment SPACES
    : [ \t]+
    ;

fragment COMMENT
    : '#' ~[\r\n]*
    ;

ID : ID_LETTER (ID_LETTER | DIGIT)* ;
NUM : (DIGIT+ ('.' DIGIT+)?) | 'NaN' | 'Infinity' ;
STR : ('"' (ESC | ~["\\])*? '"') | ('\'' (ESC | ~[\'\\])*? '\'') ;
BOOL : TRUE | FALSE ;

fragment DIGIT : [0-9] ;
fragment ID_LETTER : [a-zA-Z_$] ;
fragment ESC : '\\' ["\\/bfnrt] ;
