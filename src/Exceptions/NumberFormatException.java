package Exceptions;

public class NumberFormatException extends Exception {

	public NumberFormatException(String s,int line) {
		System.out.println("Number Format Exception in Line : "+line+" String :"+s);
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
}
