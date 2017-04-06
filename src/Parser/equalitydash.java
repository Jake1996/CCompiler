package Parser;

import SymbolTable.Token;
import SymbolTable.TokenNameConstant;

public class equalitydash extends bool {
	public equalitydash(String var) {
		Token t = getCurrentToken();
		if(t.tag == TokenNameConstant.EQ) {
			consumeToken(TokenNameConstant.EQ);
			String res = TemporaryGenerator.getTemporary();
			this.result = res;
			equality e = new equality();
			this.code = e.code;
			this.code += res+" = "+var+" == "+e.result+"\n";
		}
		else if(t.tag == TokenNameConstant.NE) {
			consumeToken(TokenNameConstant.NE);
			String res = TemporaryGenerator.getTemporary();
			this.result = res;
			equality e = new equality();
			this.code = e.code;
			this.code += res+" = "+var+" != "+e.result+"\n";
		}
		else {
			this.result = var;
			this.code = "";
		}
	}
}
