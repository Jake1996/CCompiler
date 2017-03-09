# CCompiler
Compiler design mini project.

## Implemented in Java
Our mini compiler will work on while loops in C.

## Grammar for the language :
```
p        -> stmt

stmt     ->  while ( bool ) stmt

           | break ;
      
           | {stmt}
           
           | loc = bool;
           
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

term     -> unary termdash
termdash -> * term | / term | epsilon

unary    -> !unary | ++unary | --unary | factor

factor   -> ( bool ) | num | real | true | false | loc
```
