package Parser;

public class join extends bool {
	public join() {
		equality e = new equality();
		equalitydash ed = new equalitydash(e.result);
		this.code = e.code;
		this.code += ed.code;
		this.result = ed.result;
	}
}
