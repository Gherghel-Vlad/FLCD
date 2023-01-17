
/* A Bison parser, made by GNU Bison 2.4.1.  */

/* Skeleton interface for Bison's Yacc-like parsers in C
   
      Copyright (C) 1984, 1989, 1990, 2000, 2001, 2002, 2003, 2004, 2005, 2006
   Free Software Foundation, Inc.
   
   This program is free software: you can redistribute it and/or modify
   it under the terms of the GNU General Public License as published by
   the Free Software Foundation, either version 3 of the License, or
   (at your option) any later version.
   
   This program is distributed in the hope that it will be useful,
   but WITHOUT ANY WARRANTY; without even the implied warranty of
   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
   GNU General Public License for more details.
   
   You should have received a copy of the GNU General Public License
   along with this program.  If not, see <http://www.gnu.org/licenses/>.  */

/* As a special exception, you may create a larger work that contains
   part or all of the Bison parser skeleton and distribute that work
   under terms of your choice, so long as that work isn't itself a
   parser generator using the skeleton or a modified version thereof
   as a parser skeleton.  Alternatively, if you modify or redistribute
   the parser skeleton itself, you may (at your option) remove this
   special exception, which will cause the skeleton and the resulting
   Bison output files to be licensed under the GNU General Public
   License without this special exception.
   
   This special exception was added by the Free Software Foundation in
   version 2.2 of Bison.  */


/* Tokens.  */
#ifndef YYTOKENTYPE
# define YYTOKENTYPE
   /* Put the tokens into the symbol table, so that GDB and other debuggers
      know about them.  */
   enum yytokentype {
     VAR = 258,
     CONST = 259,
     INT = 260,
     INPUT = 261,
     FOR = 262,
     IF = 263,
     WHILE = 264,
     ELSE = 265,
     IN = 266,
     PRINT = 267,
     AND = 268,
     OR = 269,
     GE = 270,
     LE = 271,
     EQUAL = 272,
     LIST = 273,
     BOOL = 274,
     STRING = 275,
     DOTDOTDOT = 276,
     EXCHANGE = 277,
     INCREMENT = 278,
     DECREMENT = 279,
     MULTIPLYEQ = 280,
     DIVIDEEQ = 281,
     DIFFERENT = 282
   };
#endif
/* Tokens.  */
#define VAR 258
#define CONST 259
#define INT 260
#define INPUT 261
#define FOR 262
#define IF 263
#define WHILE 264
#define ELSE 265
#define IN 266
#define PRINT 267
#define AND 268
#define OR 269
#define GE 270
#define LE 271
#define EQUAL 272
#define LIST 273
#define BOOL 274
#define STRING 275
#define DOTDOTDOT 276
#define EXCHANGE 277
#define INCREMENT 278
#define DECREMENT 279
#define MULTIPLYEQ 280
#define DIVIDEEQ 281
#define DIFFERENT 282




#if ! defined YYSTYPE && ! defined YYSTYPE_IS_DECLARED
typedef int YYSTYPE;
# define YYSTYPE_IS_TRIVIAL 1
# define yystype YYSTYPE /* obsolescent; will be withdrawn */
# define YYSTYPE_IS_DECLARED 1
#endif

extern YYSTYPE yylval;


