package Parser;

public class Label {
	private static int labelcount=0;
	public int labelNo;
	public Label() {
		labelNo = labelcount++;
	}
	@Override
	public String toString() {
		return "L"+labelNo;
	}
}
