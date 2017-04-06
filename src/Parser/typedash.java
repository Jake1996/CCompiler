package Parser;

import SymbolTable.Array;
import SymbolTable.IntegerNumber;
import SymbolTable.TokenNameConstant;
import SymbolTable.Type;

public class typedash extends Node {
	public boolean array = false;
	public Array t = null;
	public typedash(Type basic) {
		if(getCurrentToken().tag==TokenNameConstant.OPENSQUARE) {
			array = true;
			consumeToken(TokenNameConstant.OPENSQUARE);
			int num = ((IntegerNumber)getCurrentToken()).getValue();
			consumeToken(TokenNameConstant.INTEGERNUMBER);
			consumeToken(TokenNameConstant.CLOSESQUARE);
			typedash next = new typedash(basic);
			if(next.array) {
				t = new Array(num, next.t);
			}
			else {
				t = new Array(num, basic);
			}
		}
	}
}
