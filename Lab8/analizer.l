%{
#include <stdlib.h>
#include <string.h>
#include "y.tab.h"
%}

%option noyywrap

digit	[0-9]
nndigit	[1-9]
letter	[a-zA-Z_]
identifier {letter}({letter}|{digit})*
number	[+-]?{digit}|{nndigit}{digit}*

BOOLEAN_FORMAT (true|false)
CHAR_FORMAT (\'.\'?)
STRING_FORMAT (".*")
CONSTANT_FORMAT ({BOOLEAN_FORMAT}|{CHAR_FORMAT}|{STRING_FORMAT}|{number})

%%

for {return FOR;}
if {return IF;}
in {return IN;}
input {return INPUT;}
print {return PRINT;}
else {return ELSE;}
while {return WHILE;}
int {return INT;}
string {return STRING;}
bool {return BOOL;}
list {return LIST;}
"..." {return DOTDOTDOT;}
"<=>" {return EXCHANGE;}
"==" {return EQUAL;}
"<=" {return LE;}
">=" {return GE;}
"!=" {return DIFFERENT;}
and {return AND;}
or {return OR;}
"+=" {return INCREMENT;}
"-=" {return DECREMENT;}
"*=" {return MULTIPLYEQ;}
"/=" {return DIVIDEEQ;}
">" {return '>';}
"<" {return '<';}
"[" {return '[';}
"]" {return ']';}
"{" {return '{';}
"}" {return '}';}
";" {return ';';}
":" {return ':';}
"(" {return '(';}
")" {return ')';}
"," {return ',';}
"+" {return '+';}
"-" {return '-';}
"*" {return '*';}
"/" {return '/';}
"=" {return '=';}
"%" {return '%';}
"\"" {return '"';}
"'" {return ''';}


{identifier} {return VAR;}

{CONSTANT_FORMAT} {return CONST;}

[ \t]	;

\n ;

\r\n ;

. {printf("ERROR for %s\n", yytext);}

%%