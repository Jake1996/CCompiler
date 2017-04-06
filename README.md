# CCompiler
Compiler design mini project.

## Implemented in Java
Our mini compiler will work on while loops in C.

## Grammar for the language :
```
p        -> stmts

stmts    -> stmt stmts | epsilon

stmt     ->  while ( bool ) stmt
           | break ;
           | continue ;
           | {stmts}
           | type id;
           | unary stmtdash;
stmtdash -> ;|= bool;

type     -> int typedash| float typedash| char typedash| double typedash
typedash -> [num]typedash | epsilon

loc      -> id locdash
locdash  -> [bool]locdash | epsilon

bool     -> join booldash
booldash -> ||bool | epsilon

join     -> equality joindash
joindash -> && join | epsilon

equality -> rel equalitydash
equalitydash -> == equality | ! = equality | epsilon

rel      -> expr reldash
reldash  -> < expr | <= expr | >= expr | > expr | epsilon

expr     -> term exprdash
exprdash -> + expr | - expr | epsilon

term     -> factor termdash
termdash -> * term | / term | epsilon

factor   -> ( bool ) | num | real | true | false | unary

unary    -> ++loc | --loc | loc unarydash
unarydash-> ++ | -- | epsilon

```
