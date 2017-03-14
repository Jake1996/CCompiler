package Parser;

import SymbolTable.Token;
import SymbolTable.TokenNameConstant;

public class stmt extends Node{
	public stmt(Label l) {
		Token tok = getCurrentToken();
		switch(tok.tag) {
		case TokenNameConstant.WHILE :
			
			break;
		case TokenNameConstant.BREAK :
			break;
		case TokenNameConstant.OPENFLOWER :
			break;
		case TokenNameConstant.IDENTIFIER :
			break;
			
		}
	}
}
