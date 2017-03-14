package Parser;

public class stmts extends Node{
	public stmts(Label l) {
		code = "";
		if(getCurrentToken()==null) {
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
