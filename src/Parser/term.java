package Parser;

public class term extends bool {
	public term() {
		factor f = new factor();
		termdash td = new termdash(f.result);
		this.code = f.code;
		this.code += td.code;
		this.result = td.result;
	}
}