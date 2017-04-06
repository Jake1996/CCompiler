package Parser;

import SymbolTable.Token;
import SymbolTable.TokenNameConstant;
import SymbolTable.Word;

public class stmt extends Node{
	public stmt(Label l) {
		Token tok = getCurrentToken();
		int cond = tok.tag;
		if (cond/100==TokenNameConstant.TYPE) cond = TokenNameConstant.TYPE;
		switch(cond) {
		case TokenNameConstant.WHILE : {
			consumeToken(TokenNameConstant.WHILE);
			consumeToken(TokenNameConstant.OPENPARAN);
			Label l1 = new Label();
			Label l2 = new Label();
			Label temps,tempe;
			temps = start;
			tempe = end;
			start = l1;
			end = l2;
			bool b = new bool();
			consumeToken(TokenNameConstant.CLOSEPARAN);
			stmt s = new stmt(l2); //fix problem of wrong break over here
			this.code = l1+" :\n";
			this.code += b.code;
			this.code += "ifFalse "+ b.result +" goto "+l2;
			this.code += s.code;
			this.code += "goto "+l1+"\n";
			this.code += l2+" :\n";
			start = temps;
			end = tempe;
		}
		break;
		case TokenNameConstant.BREAK : {
			if(end!=null)
				this.code = "goto "+end;
			else 
				error();
			consumeToken(TokenNameConstant.BREAK);
			consumeToken(TokenNameConstant.SEMICOLON);
		}
		break;
		case TokenNameConstant.CONTINUE : {
			if(start!=null)
				this.code = "goto "+start;
			else 
				error();
			consumeToken(TokenNameConstant.CONTINUE);
			consumeToken(TokenNameConstant.SEMICOLON);
		}
		break;
		case TokenNameConstant.OPENFLOWER : {
			consumeToken(TokenNameConstant.OPENFLOWER);
			stmts s = new stmts(null);
			consumeToken(TokenNameConstant.CLOSEFLOWER);
			this.code = s.code+"\n";
		}
		break;
		case TokenNameConstant.TYPE : {
			type t = new type();
			Word id = (Word)getCurrentToken();
			id.setType(t.type);
		}
		break;
		case TokenNameConstant.IDENTIFIER : {
			unary u = new unary();
			Token t = getCurrentToken();
			if(t.tag == TokenNameConstant.SEMICOLON) {
				consumeToken(TokenNameConstant.SEMICOLON);
				this.code = u.code;
			}
			else {
				stmtdash sd = new stmtdash(u.result);
				this.code = sd.code;
			}
		}
		break;

		}
	}
}
