package Parser;

public class stmts extends Node{
	public stmts() {
		code="";
		if(getCurrentToken()==null) {
			return;
		}
		Label l1 = new Label();
		stmt s = new stmt(l1);
		code+=s.code+l1+" :";
		if(getCurrentToken()==null) {
			return;
		}
		code += new stmts().code;
		
	}
}
