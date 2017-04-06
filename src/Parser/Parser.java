package Parser;

import LexicalAnalyzer.Lexer;

public class Parser {
	public static Lexer lex;
	public String output;
	public Parser(String program) {
		lex = new Lexer(program);
		output = new stmts(null).code;
	}
	
}
