package Parser;

import LexicalAnalyzer.Lexer;
import SymbolTable.Token;

public class Parser {
	public static Lexer lex;
	public static void main(String args[]) {
		Lexer l = new Lexer("for (int i = 1; i < N; i++) dp[i][0] = 1;for (int i = 1; i < N; i++) {for (int j = 1; j < N; j++) {if (i > j) {");
		Token s;
		while((s=l.getNextToken())!=null) {
			System.out.println(s);
		}
	}
	public Parser(String program) {
		lex = new Lexer(program);
		String output = new stmts(null).code;
		System.out.println(output);
	}
	
}
