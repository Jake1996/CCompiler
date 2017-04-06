package Parser;

import SymbolTable.TokenNameConstant;

public class stmts extends Node{
	public stmts(Label l) {
		code = "";
		if(getCurrentToken()==null||getCurrentToken().tag==TokenNameConstant.CLOSEFLOWER) {
			return;
		}
		stmt s = new stmt(l);
		code += s.code;
		if(getCurrentToken()==null) {
			return;
		}
		code += new stmts(l).code;
	}
}