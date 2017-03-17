package Parser;

import SymbolTable.Token;

public class Node {
	public String code;
	private static Token cur= null;
	protected Label start = null;
	protected Label end = null;
	public static void error() {
		System.out.println("Error at line : "+ Parser.lex.getLineNo()+" with token :"+cur);
	}
	public static Token getCurrentToken() {
		if(cur==null) {
			cur = Parser.lex.getNextToken();
		}
		return cur;
	}
	public static void consumeToken(int tag) {
		if(cur.tag!=tag) {
			error();
			while(cur.tag!=tag)  {
				cur = null;
				cur = Parser.lex.getNextToken();
			}
		}
		cur = null;
	}
}
