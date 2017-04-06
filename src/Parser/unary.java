package Parser;

import SymbolTable.Token;
import SymbolTable.TokenNameConstant;

public class unary extends bool {
	public unary() {
		Token t = getCurrentToken();
		switch(t.tag) {
		case TokenNameConstant.INCREMENT : {
			consumeToken(TokenNameConstant.INCREMENT);
			loc l = new loc();
			String var = TemporaryGenerator.getTemporary();
			this.result = var;
			this.code = l.code +"\n";
			this.code += var+" = "+l.result+" + 1\n";
			this.code += l.result+ " = "+var+"\n";
		}
		break;
		case TokenNameConstant.DECREMENT : {
			consumeToken(TokenNameConstant.DECREMENT);
			loc l = new loc();
			String var = TemporaryGenerator.getTemporary();
			this.result = var;
			this.code = l.code +"\n";
			this.code += var+" = "+l.result+" - 1\n";
			this.code += l.result+ " = "+var+"\n";
		}
		break;
		default :  {
			loc l = new loc();
			this.code = l.code;
			this.result = l.result;
			if(getCurrentToken().tag==TokenNameConstant.DECREMENT||getCurrentToken().tag==TokenNameConstant.INCREMENT) {
				String var = TemporaryGenerator.getTemporary();
				this.result = var;
				this.code = l.code;
				if(getCurrentToken().tag==TokenNameConstant.DECREMENT) {
					this.code += var+" = "+l.result+" - 1\n";
					consumeToken(TokenNameConstant.DECREMENT);
				}
				else if(getCurrentToken().tag==TokenNameConstant.INCREMENT) {
					this.code += var+" = "+l.result+" + 1\n";
					consumeToken(TokenNameConstant.INCREMENT);
				}
				this.code += l.result+ " = "+var+"\n";
			}
		}
		}
	}
}
