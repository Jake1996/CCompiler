package SymbolTable;

public class IntegerNumber extends Number {
	private int value;
	public IntegerNumber(int val) {
		super(TokenNameConstant.INTEGERNUMBER);
		value=val;
	}
	public Integer getValue() {
		return value;
	}
	@Override
	public String toString() {
		return "< Integer , " +value+ " >";
	}
}
