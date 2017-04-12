# CCompiler
Compiler design mini project.

## Implemented in Java
Our mini compiler will work on while loops in C.
Using RDP without backtracking

## Run Instructions
Goto bin/Main/GCC.java and change the location of the file to the input file
From bin folder execute :
$java Main.GCC

## Implemented Functionalities :
```
 - > Error detection using skipping tokens till the required token is found
 - > Intermediate code generation
 - > Symbol Table , Implicit Stack with function calls
 - > Each non-terminal is a class which represents the parset tree
 - > printf function call
 - > Nested while loops can be done with break and continue
 - > Nested scopes have been taken care of (Container class)
```

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
           | printf ("");
stmtdash -> ;|= bool|*= bool|/= bool|-= bool|%= bool;

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

PROJECT BY :
Imran Ahmed Manzoor - 01FB14ECS085
Jainam M - 01FB14ECS086
Jatin PM - 01FB14ECS087