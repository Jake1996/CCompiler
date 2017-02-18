package Helper;

public class CharacterHelper {
	public static boolean isLetter(char c) {
		if(Character.isLetter(c)||c=='_') return true;
		return false;
	}
	public static boolean isLetterNumber(char c) {
		if(Character.isLetter(c)||c=='_'||Character.isDigit(c)) return true;
		return false;
	}
}
