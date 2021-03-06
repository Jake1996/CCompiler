package Parser;

import SymbolTable.Array;
import SymbolTable.Token;
import SymbolTable.TokenNameConstant;
import SymbolTable.Type;

public class locdash extends bool {
	public boolean indirect = false;
	public locdash(Type t) {
		Token token = getCurrentToken();
		if(token.tag!=TokenNameConstant.OPENSQUARE) 
			return;
		indirect = true;
		Array a = (Array)t; 
		consumeToken(TokenNameConstant.OPENSQUARE);
		bool b = new bool();
		b.init();
		consumeToken(TokenNameConstant.CLOSESQUARE);
		String ref1 = TemporaryGenerator.getTemporary();
		String ref2 = TemporaryGenerator.getTemporary();
		locdash ld = new locdash(a.getType());
		if(ld.indirect) {
			this.code = b.code;
			this.code += ld.code;
			this.code += ref1+" = "+ a.getType().width +" * "+b.result+"\n";
			this.code += ref2+" = "+ref1+" + " +ld.result+"\n";
			this.result = ref2;
		}
		else {
			this.code = b.code;
			this.code += ref1+" = "+ a.getType().width +" * "+b.result+"\n";
			this.result = ref1;			
		}
	}
}
