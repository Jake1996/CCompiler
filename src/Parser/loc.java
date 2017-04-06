package Parser;

import SymbolTable.TokenNameConstant;
import SymbolTable.Word;

public class loc extends bool {
	public loc() {
		Word t = (Word)getCurrentToken();
		consumeToken(TokenNameConstant.IDENTIFIER);
		if(t.getType()==null) {
			System.out.println("Undefined variable : "+t.getLexeme()+" on line :"+Parser.lex.getLineNo());
		}
		locdash ld = new locdash(t.getType());
		if(ld.indirect) {
			this.result = ((Word)t).getLexeme()+"["+ld.result+"]";
			this.code = ld.code;
		}
		else {
			this.result = t.getLexeme();
		}
		
	}
}
