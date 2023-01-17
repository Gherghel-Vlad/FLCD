%{
#include <stdio.h>
#include <stdlib.h>

extern FILE* yyin;
int yyerror();

%}

%error-verbose
%token VAR
%token CONST
%token INT
%token INPUT
%token FOR
%token IF
%token WHILE
%token ELSE
%token IN
%token PRINT
%token AND
%token OR
%token GE
%token LE
%token EQUAL
%token LIST
%token BOOL
%token STRING
%token DOTDOTDOT
%token EXCHANGE
%token INCREMENT
%token DECREMENT
%token MULTIPLYEQ
%token DIVIDEEQ
%token DIFFERENT
%%

S : program
  ;

program : stmt_list
        ;

stmt_list : stmt stmt_list
          | stmt
          ;

relation : '<' | '>' | LE | GE | DIFFERENT | EQUAL ;

booloper : AND | OR ;

arithoper : '+' | '-' | '*' | '/' ;

ifstmt : IF '(' compcond ')' '{' stmt_list '}' ;

condition : expression relation expression ;

boolcond : compcond booloper compcond ;

compcond : condition | boolcond | BOOL ;

expression : expression arithoper term | term ;

exchstmt : VAR EXCHANGE VAR ';' ;

term : CONST | VAR ;

stmt : assignstmt | iostmt | ifstmt | whilestmt | forstmt | exchstmt ;

assignoper : '=' | INCREMENT | DECREMENT | MULTIPLYEQ | DIVIDEEQ ;

assignstmt : VAR assignoper expression ';'
           ;

instmt : INPUT '(' VAR ')' ';';

outstmt : PRINT '(' expression ')' ';'
        ;

iostmt : instmt | outstmt ;

whilestmt : WHILE '(' compcond ')' '{' stmt_list '}' ;

forstmt : FOR '(' VAR 'in' VAR ')' '{' stmt_list '}'
        | FOR '(' VAR 'in' constlist ')' '{' stmt_list '}'
        ;

constlist : '[]' | '[' term_list ']' | '[' term '...' term ']' ;

term_list : term ',' term_list | term ;

%%

int yyerror()
{
    printf("syntax error\n");
}

int parser_main(char* filename)
{
    yyin = fopen(filename, "r");
    if(!yyin)
    {
        printf("error reading from file");
        return 1;
    }
    if(0==yyparse()) printf("result yyparse: OK\n");
}