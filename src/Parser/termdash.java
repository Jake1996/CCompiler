package Parser;

import SymbolTable.Token;
import SymbolTable.TokenNameConstant;

public class termdash extends bool {
	public termdash(String var) {
		Token t = getCurrentToken();
		if(t.tag == TokenNameConstant.MULTIPLY) {
			consumeToken(TokenNameConstant.MULTIPLY);
			String res = TemporaryGenerator.getTemporary();
			this.result = res;
			term te = new term();
			this.code = te.code;
			this.code += res+" = "+var+" * "+te.result+"\n";
		}
		else if(t.tag == TokenNameConstant.DIVIDE) {
			consumeToken(TokenNameConstant.DIVIDE);
			String res = TemporaryGenerator.getTemporary();
			this.result = res;
			term te = new term();
			this.code = te.code;
			this.code += res+" = "+var+" / "+te.result+"\n";
		}
		else {
			this.result = var;
			this.code = "";
		}
	}
}
