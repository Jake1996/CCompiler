# CCompiler
Compiler design mini project.

## Implemented in Java
Our mini compiler will work on while loops in C.

## Grammar for the language :
```
stmt     ->  while ( bool ) stmt

           | break ;
      
           | {stmt}
           
           | loc = bool;
           
loc      -> loc[bool] | id

bool     -> join||bool | join

join     -> equality && join | equality

equality -> rel == equality | rel ! = equality | rel

rel      -> expr < expr | expr<= expr | expr>= expr | expr > expr | expr

expr     -> term + expr | term - expr | term

term     -> unary * term | unary / term | unary

unary    -> !unary | ++unary | --unary | factor

factor   -> ( bool ) | num | real | true | false
```
