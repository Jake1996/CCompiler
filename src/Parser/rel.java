package Parser;

public class rel extends bool {
	public rel() {
		expr e = new expr();
		reldash rd = new reldash(e.result);
		this.code = e.code;
		this.code += rd.code;
		this.result = rd.result;
	}
}
