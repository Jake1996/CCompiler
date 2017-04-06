package Parser;

import SymbolTable.Token;
import SymbolTable.TokenNameConstant;

public class stmtdash extends Node {
	public stmtdash(String result) {
		Token t = getCurrentToken();
		switch(t.tag) {
		case TokenNameConstant.ASSIGN : {
			bool b = new bool();
			this.code = b.code;
			this.code += result + " = " + b.result;
		}
		break;
		case TokenNameConstant.ADDEQUAL : {
			bool b = new bool();
			this.code = b.code;
			String var = TemporaryGenerator.getTemporary();
			this.code += var+" = "+ result+ "+" + b.result;
			this.code += result + " = " + var;
		}
		break;
		case TokenNameConstant.SUBTRACTEQUAL : {
			bool b = new bool();
			this.code = b.code;
			String var = TemporaryGenerator.getTemporary();
			this.code += var+" = "+ result+ "-" + b.result;
			this.code += result + " = " + var;		}
		break;
		case TokenNameConstant.MULTIPLYEQUAL : {
			bool b = new bool();
			this.code = b.code;
			String var = TemporaryGenerator.getTemporary();
			this.code += var+" = "+ result+ "*" + b.result;
			this.code += result + " = " + var;		}
		break;
		case TokenNameConstant.DIVIDEEQUAL : {
			bool b = new bool();
			this.code = b.code;
			String var = TemporaryGenerator.getTemporary();
			this.code += var+" = "+ result+ "/" + b.result;
			this.code += result + " = " + var;		}
		break;
		case TokenNameConstant.MODULUSEQUAL : {
			bool b = new bool();
			this.code = b.code;
			String var = TemporaryGenerator.getTemporary();
			this.code += var+" = "+ result+ "%" + b.result;
			this.code += result + " = " + var;		}
		break;
		}
	}
}
