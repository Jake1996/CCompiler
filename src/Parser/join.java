package Parser;

public class join extends bool {
	public join() {
		equality e = new equality();
		joindash jd = new joindash(e.result);
		this.code = e.code;
		this.code += jd.code;
		this.result = jd.result;
	}
}
