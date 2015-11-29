grammar decaf;

program
:
	extern_defs* 'class' id '{' field_declaration* method_declaration* '}'
;

extern_defs:
	'extern' method_type id '(' extern_type_list ')' ';'
;

extern_type_list:
	(extern_type ',')* extern_type
	;

extern_type: 
	'string' | type 
	;

field_declaration:
	var_or_array_declaration_list ';'
	| type id '=' constant ';'
	;

var_or_array_declaration_list:
	type (var_or_array_declaration ',')* var_or_array_declaration
	; 
	
var_or_array_declaration: 
	id | array_declaration 
;


array_declaration:
	id '[' int_constant ']'
	;

method_declaration:
	method_type id 	'(' method_declaration_arguments? ')' block
	;

method_declaration_arguments:
	(type id ',')* type id
	;
	
block: 
	'{' var_declaration* statement* '}'
	;

var_declaration: 
	type (id ',')* id ';' 
	; 

method_type: 'void' | type ;

type: 'int' | 'bool' ;

statement
	:
	assign ';'
	| method_call ';'
	| 'if' '(' expr ')' block ('else' block)?
	| 'while' '(' expr ')' block
	| 'for' '(' for_body ')'
	| 'return' ( '(' expr? ')' )? ';'
	| 'break' ';'
	| 'continue' ';'
	| block
 	;

for_body:
	(assign ',')* assign ';'
	expr ';'
	(assign ',')* assign 
;
	
assign
	:
	l_value '=' expr
	;

method_call
	:
	id '(' method_args ')'
	;

method_args:
	(method_arg ',')* method_arg?
	;
	
method_arg
	:
	expr | string_constant
	;

l_value	:
	id
	| id '[' expr ']'	
	;

expr	:	
	id
	| id '[' expr ']'
	| method_call
	| constant
	| '-' expr
	| '!' expr
	| '(' expr ')'
	| expr binary_op expr
	;


	
id	:
	Identifier
	;

binary_op
	:
	arithmetic_op | relation_op | eq_op | condition_op	
	;

arithmetic_op
	:
	'+' | '-' | '*' | '/' | '<<' | '>>' | '%'	
	;

relation_op
	:
	'<' | '>' | '<=' | '>='
	;

eq_op	
	:
	'==' | '!='
	;

condition_op
	:
	'&&' | '||'	
	;

constant
	:
	int_constant | char_constant | bool_constant
	;

	
bool_constant :	'true'|'false' ;
char_constant :	CharacterLiteral ;
string_constant : StringLiteral	;	
int_constant : IntegerLiteral ;
double_constant: DoubleLiteral;
	
// lexer rules	

CLASS: 'class';
EXTERN: 'extern';
STRING: 'string';
VOID: 'void';
BOOL: 'bool';
INT: 'int';
IF: 'if' ;
ELSE: 'else';
WHILE: 'while';
FOR: 'for';
RETURN: 'return';
BREAK: 'break';
CONTINUE: 'continue';
TRUE: 'true';
FALSE: 'false';


DoubleLiteral
	:
	Digit* '.' Digit+
	;
	
IntegerLiteral
    :   DecimalIntegerLiteral
    |   HexIntegerLiteral
;

fragment
DecimalIntegerLiteral:
	Digit+
;

fragment
Digit:
	[0-9]
;

HexIntegerLiteral:
	'0' [xX] HexDigit+
;

fragment
HexDigit:
	[a-fA-F0-9]
;

BooleanLiteral
    :   'true'
    |   'false'
    ;

CharacterLiteral
    :   '\'' SingleCharacter '\''
    |   '\'' EscapeSequence '\''
    ;

fragment
SingleCharacter
    :   ~['\\]
    ;

StringLiteral
    :   '"' StringCharacters? '"'
    ;

fragment
StringCharacters:
	StringCharacter+
;
	
fragment
StringCharacter:
	~["\\]
    | EscapeSequence
;

fragment
EscapeSequence:
	'\\' [btnfr"'\\]
;

LPAREN          : '(';
RPAREN          : ')';
LBRACE          : '{';
RBRACE          : '}';
LBRACK          : '[';
RBRACK          : ']';
SEMI            : ';';	
COMMA           : ',';
DOT				: '.';

ASSIGN          : '=';
GT              : '>';
LT              : '<';
LE              : '<=';
GE              : '>=';

BANG            : '!';

EQUAL           : '==';
NOTEQUAL        : '!=';

AND             : '&&';
OR              : '||';

LSHIFT_ASSIGN   : '<<';
RSHIFT_ASSIGN   : '>>';
MOD             : '%';
ADD             : '+';
SUB             : '-';
MUL             : '*';
DIV             : '/';

Identifier:
	Letter LetterOrDigit*
;
	
fragment
Letter: 
	[a-zA-Z$_] 
;

fragment
LetterOrDigit: 
	[a-zA-Z0-9$_] 
;

COMMENT:
   '//' ~('\n'|'\r')* '\r'? '\n' -> skip
    ;

WS  :
	[ \t\r\n\u000C]+ -> skip
    ;
