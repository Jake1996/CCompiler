package Parser;

import SymbolTable.Token;
import SymbolTable.TokenNameConstant;
import SymbolTable.Type;

public class type extends Node{
	public Type type;
	public type() {
		Token k = getCurrentToken();
		typedash td = new typedash();
		if(td.array) {
			
		}
		else {
			switch(k.tag) {
			case TokenNameConstant.INT :
				type = type.INT;
				break;
			case TokenNameConstant.FLOAT :
				type = type.FLOAT;
				break;
			case TokenNameConstant.LONG :
				type = type.LONG;
				break;
			case TokenNameConstant.DOUBLE :
				type = type.DOUBLE;
				break;
			case TokenNameConstant.CHAR :
				type = type.CHAR;
				break;
			}
			consumeToken(k.tag);
		}
	}
}
