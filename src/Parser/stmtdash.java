package Parser;

import SymbolTable.Token;
import SymbolTable.TokenNameConstant;

public class stmtdash extends Node {
	public stmtdash(String result) {
		Token t = getCurrentToken();
		switch(t.tag) {
		case TokenNameConstant.ASSIGN : {
			consumeToken(TokenNameConstant.ASSIGN);
			bool b = new bool();
			b.init();
			this.code = b.code;
			this.code += result + " = " + b.result+"\n";
		}
		break;
		case TokenNameConstant.ADDEQUAL : {
			consumeToken(TokenNameConstant.ADDEQUAL);
			bool b = new bool();
			b.init();
			this.code = b.code;
			String var = TemporaryGenerator.getTemporary();
			this.code += var+" = "+ result+ "+" + b.result+"\n";
			this.code += result + " = " + var;
		}
		break;
		case TokenNameConstant.SUBTRACTEQUAL : {
			consumeToken(TokenNameConstant.SUBTRACTEQUAL);
			bool b = new bool();
			b.init();
			this.code = b.code;
			String var = TemporaryGenerator.getTemporary();
			this.code += var+" = "+ result+ "-" + b.result+"\n";
			this.code += result + " = " + var;		}
		break;
		case TokenNameConstant.MULTIPLYEQUAL : {
			consumeToken(TokenNameConstant.MULTIPLYEQUAL);
			bool b = new bool();
			b.init();
			this.code = b.code;
			String var = TemporaryGenerator.getTemporary();
			this.code += var+" = "+ result+ "*" + b.result+"\n";
			this.code += result + " = " + var;		}
		break;
		case TokenNameConstant.DIVIDEEQUAL : {
			consumeToken(TokenNameConstant.DIVIDEEQUAL);
			bool b = new bool();
			b.init();
			this.code = b.code;
			String var = TemporaryGenerator.getTemporary();
			this.code += var+" = "+ result+ "/" + b.result+"\n";
			this.code += result + " = " + var;		}
		break;
		case TokenNameConstant.MODULUSEQUAL : {
			consumeToken(TokenNameConstant.MODULUSEQUAL);
			bool b = new bool();
			b.init();
			this.code = b.code;
			String var = TemporaryGenerator.getTemporary();
			this.code += var+" = "+ result+ "%" + b.result+"\n";
			this.code += result + " = " + var;		}
		break;
		}
		consumeToken(TokenNameConstant.SEMICOLON);
	}
}
