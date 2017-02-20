package Exceptions;

public class CharacterFormatException extends Exception {
	
	public CharacterFormatException(String s,int line) {
		System.out.println("Character Format Exception in Line : "+line+" String :"+s);
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
}
