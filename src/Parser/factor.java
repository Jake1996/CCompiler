package Parser;

import SymbolTable.Number;
import SymbolTable.RealNumber;
import SymbolTable.Token;
import SymbolTable.TokenNameConstant;

public class factor extends bool {
	public factor() {
		Token t = getCurrentToken();
		switch(t.tag) {
		case TokenNameConstant.OPENPARAN : {
			consumeToken(TokenNameConstant.OPENPARAN);
			bool b =new  bool();
			this.code = b.code;
			this.result = b.result;
			consumeToken(TokenNameConstant.CLOSEPARAN);
		}
		break;
		case TokenNameConstant.INTEGERNUMBER : {
			consumeToken(TokenNameConstant.INTEGERNUMBER);
			String var = TemporaryGenerator.getTemporary();
			this.code = var+" = "+((Number)t).getValue();
			this.result = var;
		}
		break;
		case TokenNameConstant.REALNUMBER : {
			consumeToken(TokenNameConstant.REALNUMBER);
			String var = TemporaryGenerator.getTemporary();
			this.code = var+" = "+((RealNumber)t).getValue();
			this.result = var;
		}
		break;
		default : {
			unary u = new unary();
			this.code = u.code;
			this.result = u.result;
		}
		}
	}
}
