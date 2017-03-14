package Parser;

import SymbolTable.Token;
import SymbolTable.TokenNameConstant;

public class stmt extends Node{
	public stmt(Label l) {
		Token tok = getCurrentToken();
		switch(tok.tag) {
		case TokenNameConstant.WHILE : {
			consumeToken(TokenNameConstant.WHILE);
			consumeToken(TokenNameConstant.OPENPARAN);
			Label l1 = new Label();
			Label l2 = new Label();
			//bool
			consumeToken(TokenNameConstant.CLOSEPARAN);
			stmt s = new stmt(l2); //fix problem of wrong break over here
			/* this.code = bool.code;
			 * this.code += "cmp "+bool.value+",#0";
			 * this.code += "ontrue goto"+l2;
			 */
			this.code += s.code;
			this.code += "goto "+l1+"\n";
			this.code += l2+" :\n";
		}
		break;
		case TokenNameConstant.BREAK :
			this.code = "goto "+l;
			consumeToken(TokenNameConstant.BREAK);
			consumeToken(TokenNameConstant.SEMICOLON);
			break;
		case TokenNameConstant.OPENFLOWER : {
			consumeToken(TokenNameConstant.OPENFLOWER);
			Label l1 = new Label();
			stmts s = new stmts(l1);
			consumeToken(TokenNameConstant.CLOSEFLOWER);
			this.code = s.code+"\n"+l1+" :\n";
		}
		break;
		case TokenNameConstant.IDENTIFIER :
			break;

		}
	}
}
