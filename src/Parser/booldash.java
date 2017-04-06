package Parser;

import SymbolTable.Token;
import SymbolTable.TokenNameConstant;

public class booldash extends bool {
	public booldash(String var) {
		Token t = getCurrentToken();
		if(t.tag == TokenNameConstant.OR) {
			
		}
		else {
			this.result = var;
			this.code = "";
		}
	}
}
