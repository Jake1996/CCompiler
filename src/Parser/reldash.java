package Parser;

import SymbolTable.Token;
import SymbolTable.TokenNameConstant;

public class reldash extends bool {
	public reldash(String var) {
		Token t = getCurrentToken();
		if(t.tag == TokenNameConstant.LT) {
			consumeToken(TokenNameConstant.LT);
			String res = TemporaryGenerator.getTemporary();
			this.result = res;
			expr e = new expr();
			this.code = e.code;
			this.code += res+" = "+var+" < "+e.result+"\n";
		}
		else if(t.tag == TokenNameConstant.LE) {
			consumeToken(TokenNameConstant.LT);
			String res = TemporaryGenerator.getTemporary();
			this.result = res;
			expr e = new expr();
			this.code = e.code;
			this.code += res+" = "+var+" <= "+e.result+"\n";
		}
		else if(t.tag == TokenNameConstant.GE) {
			consumeToken(TokenNameConstant.GE);
			String res = TemporaryGenerator.getTemporary();
			this.result = res;
			expr e = new expr();
			this.code = e.code;
			this.code += res+" = "+var+" > "+e.result+"\n";
		}
		else if(t.tag == TokenNameConstant.GT) {
			consumeToken(TokenNameConstant.GT);
			String res = TemporaryGenerator.getTemporary();
			this.result = res;
			expr e = new expr();
			this.code = e.code;
			this.code += res+" = "+var+" >= "+e.result+"\n";
		}
		else {
			this.result = var;
			this.code = "";
		}
	}
}
