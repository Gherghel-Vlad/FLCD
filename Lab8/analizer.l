%{
#include <math.h>
#include <stdlib.h>
#include <string.h>
%}

%option noyywrap
%option yylineno

digit	[0-9]
nndigit	[1-9]
letter	[a-zA-Z_]
identifier {letter}({letter}|{digit})*
number	[+-]?{digit}|{nndigit}{digit}*

BOOLEAN_FORMAT (true|false)
CHAR_FORMAT (\'.\'?)
STRING_FORMAT (".*")
CONSTANT_FORMAT ({BOOLEAN_FORMAT}|{CHAR_FORMAT}|{STRING_FORMAT}|{number})

%{
	int idsCount = 0, constsCount = 0, line = 1;
	char ids[100][100];
	char consts[100][100];

    void printIdConst(char* word, char dict[][100], int* count) {
        int i, nr = -1;
        for (i = 0; i < *count; i++) {
            if (strcmp(word, dict[i]) == 0) {
                nr = i;
                break;
            }
        }
        if (nr == -1) {
            strcpy(dict[*count], word);
            *count = *count + 1;
            nr = *count - 1;
        }
        printf("%s | %d \n", word, nr);
    }
%}

%%

for {printf("%s | -1\n", yytext);}
if {printf("%s | -1\n", yytext);}
in {printf("%s | -1\n", yytext);}
input {printf("%s | -1\n", yytext);}
print {printf("%s | -1\n", yytext);}
else {printf("%s | -1\n", yytext);}
while {printf("%s | -1\n", yytext);}
do {printf("%s | -1\n", yytext);}
int {printf("%s | -1\n", yytext);}
char {printf("%s | -1\n", yytext);}
string {printf("%s | -1\n", yytext);}
bool {printf("%s | -1\n", yytext);}
list {printf("%s | -1\n", yytext);}
"..." {printf("%s | -1\n", yytext);}
"<=>" {printf("%s | -1\n", yytext);}
"==" {printf("%s | -1\n", yytext);}
"<=" {printf("%s | -1\n", yytext);}
">=" {printf("%s | -1\n", yytext);}
"!=" {printf("%s | -1\n", yytext);}
and {printf("%s | -1\n", yytext);}
or {printf("%s | -1\n", yytext);}
"+=" {printf("%s | -1\n", yytext);}
"-"= {printf("%s | -1\n", yytext);}
"*=" {printf("%s | -1\n", yytext);}
"/=" {printf("%s | -1\n", yytext);}
">" {printf("%s | -1\n", yytext);}
"<" {printf("%s | -1\n", yytext);}
"[" {printf("%s | -1\n", yytext);}
"]" {printf("%s | -1\n", yytext);}
"{" {printf("%s | -1\n", yytext);}
"}" {printf("%s | -1\n", yytext);}
";" {printf("%s | -1\n", yytext);}
":" {printf("%s | -1\n", yytext);}
"(" {printf("%s | -1\n", yytext);}
")" {printf("%s | -1\n", yytext);}
"," {printf("%s | -1\n", yytext);}
"+" {printf("%s | -1\n", yytext);}
"-" {printf("%s | -1\n", yytext);}
"*" {printf("%s | -1\n", yytext);}
"/" {printf("%s | -1\n", yytext);}
"=" {printf("%s | -1\n", yytext);}
"%" {printf("%s | -1\n", yytext);}
"\"" {printf("%s | -1\n", yytext);}
"'" {printf("%s | -1\n", yytext);}

{identifier} {printIdConst(yytext, ids, &idsCount);}

{CONSTANT_FORMAT} {printIdConst(yytext, consts, &constsCount);}

[ \t]	;

\n {line++;}

\r\n {line++;}

. {printf("ERROR for %s on line %d\n", yytext, line);}

%%

int lexic_main(char* filename)
{
    yyin = fopen(filename, "r");
    if(!yyin) {
        return 1;
    }
    printf("TOKEN | ST_POS \n");
    yylex();
    fclose(yyin);
    printf("\nST\n");
    printf("ID\n");
    int j = 0;
    for(j = 0; j < idsCount; j++) {
        printf("%s    %d\n",ids[j],j);
    }
    printf("CONST\n");
    for(j = 0; j < constsCount; j++) {
        printf("%s    %d\n",consts[j],j);
    }
    return 0;
}