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

bool     -> bool||join | join

join     -> join && equality | equality

equality -> equality == rel | equality ! = rel | rel

rel      -> expr < expr | expr<= expr | expr>= expr | expr > expr | expr

expr     -> expr + term | expr - term | term

term     -> term * unary | term / unary | unary

unary    -> !unary | ++unary | --unary | factor

factor   -> ( bool ) | num | real | true | false
```
