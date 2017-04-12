package Parser;

import LexicalAnalyzer.Lexer;
public class Parser {
	public static Lexer lex;
	public String output;
//	public static void main(String args[]) {
//		String program = "int a;a=5;\n";//\nint b;b = 6;\nint[5][7] c;\na = b*c[1][2];";
//		Parser.lex = new Lexer(program);
//		Token t;
//		while((t=lex.getNextToken())!=null) System.out.println(t);
//	}
	public Parser(String program) {
		lex = new Lexer(program);
		output = new stmts(null).code;
	}
	
}
