package Parser;

import SymbolTable.Token;
import SymbolTable.TokenNameConstant;

public class exprdash extends bool {
	public exprdash(String var) {
		Token t = getCurrentToken();
		if(t.tag == TokenNameConstant.ADD) {
			consumeToken(TokenNameConstant.ADD);
			String res = TemporaryGenerator.getTemporary();
			this.result = res;
			expr e = new expr();
			this.code = e.code;
			this.code += res+" = "+var+" + "+e.result+"\n";
		}
		else if(t.tag == TokenNameConstant.SUBTRACT) {
			consumeToken(TokenNameConstant.SUBTRACT);
			String res = TemporaryGenerator.getTemporary();
			this.result = res;
			expr e = new expr();
			this.code = e.code;
			this.code += res+" = "+var+" - "+e.result+"\n";
		}
		else {
			this.result = var;
			this.code = "";
		}
	}
}
