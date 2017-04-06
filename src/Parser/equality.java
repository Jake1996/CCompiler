package Parser;

public class equality extends bool {
	public equality() {
		rel r = new rel();
		equalitydash ed = new equalitydash(r.result);
		this.code = r.code;
		this.code += ed.code;
		this.result = ed.result;
	}
}
