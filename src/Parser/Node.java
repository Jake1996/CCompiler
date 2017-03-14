package Parser;

import SymbolTable.Token;

public class Node {
	public String code;
	private static Token cur= null;
	public static Token getCurrentToken() {
		if(cur==null) {
			cur = Parser.lex.getNextToken();
		}
		return cur;
	}
	public static void consumeToken() {
		cur = null;
	}
}
