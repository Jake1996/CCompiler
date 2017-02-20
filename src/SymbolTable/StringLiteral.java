package SymbolTable;

public class StringLiteral extends Token{
	String value;
	public StringLiteral(String val) {
		super(TokenNameConstant.STRINGLITERAL);
		value = val;
	}
}
