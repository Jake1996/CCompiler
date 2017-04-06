package Parser;

public class bool extends Node{
	public String result;
	public bool() {
		join j = new join();
		booldash bd = new booldash(j.result);
		this.code = j.code;
		this.code += bd.code;
		this.result = bd.result;
	}
}
