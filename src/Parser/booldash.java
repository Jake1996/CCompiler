package Parser;

import SymbolTable.Token;
import SymbolTable.TokenNameConstant;

public class booldash extends bool {
	public booldash(String var) {
		Token t = getCurrentToken();
		if(t.tag == TokenNameConstant.OR) {
			consumeToken(TokenNameConstant.OR);
			bool b = new bool();
			b.init();
			String res = TemporaryGenerator.getTemporary();
			this.result = res;
			this.code = b.code;
			this.code += res +" = "+var+" || "+b.result+"\n";
		}
		else {
			this.result = var;
			this.code = "";
		}
	}
}
