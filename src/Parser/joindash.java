package Parser;

import SymbolTable.Token;
import SymbolTable.TokenNameConstant;

public class joindash extends bool {
	public joindash(String var) {
		Token t = getCurrentToken();
		if(t.tag == TokenNameConstant.AND) {
			consumeToken(TokenNameConstant.AND);
			join j = new join();
			String res = TemporaryGenerator.getTemporary();
			this.result = res;
			this.code = j.code;
			this.code += res+" = "+var+" && "+j.result+"\n";
		}
		else {
			this.result = var;
			this.code = "";
		}
	}
}
