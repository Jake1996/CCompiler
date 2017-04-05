package Parser;

public class TemporaryGenerator {
	private static int pos = 0;
	public static String getTemporary() {
		 String result = "t"+pos;
		 pos++;
		 return result;
	}
}
