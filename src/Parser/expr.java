package Parser;

public class expr extends bool {
	public expr() {
		term t = new term();
		exprdash ed = new exprdash(t.result);
		this.code = t.code;
		this.code += ed.code;
		this.result = ed.result;
	}
}
