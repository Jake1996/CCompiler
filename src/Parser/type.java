package Parser;

import SymbolTable.Token;
import SymbolTable.TokenNameConstant;
import SymbolTable.Type;

public class type extends Node{
	public Type type;
	public type() {
		Token k = getCurrentToken();
		switch(k.tag) {
		case TokenNameConstant.INT :
			type = Type.INT;
			break;
		case TokenNameConstant.FLOAT :
			type = Type.FLOAT;
			break;
		case TokenNameConstant.LONG :
			type = Type.LONG;
			break;
		case TokenNameConstant.DOUBLE :
			type = Type.DOUBLE;
			break;
		case TokenNameConstant.CHAR :
			type = Type.CHAR;
			break;
		}
		consumeToken(k.tag);
		typedash td = new typedash(type);
		if(td.array) {
			type = td.t;
		}
	}
}
