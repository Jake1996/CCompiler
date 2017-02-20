package SymbolTable;

public class Number extends Token {
	private int value;
	public Number(int val) {
		super(TokenNameConstant.NUMBER);
		value=val;
	}
	public int getValue() {
		return value;
	}
}
