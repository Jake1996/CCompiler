package SymbolTable;

public class RealNumber extends Number {
	private double value;
	public RealNumber(double val) {
		super(TokenNameConstant.REALNUMBER);
		value=val;
	}
	public Double getValue() {
		return value;
	}
	@Override
	public String toString() {
		return "< Real , " +value+ " >";
	}
}