package SymbolTable;

public class CharacterLiteral extends Token {
	String value;
	public CharacterLiteral(String c) {
		super(TokenNameConstant.CHARACTERLITERAL);
		value=c;
	}
	@Override
	public String toString() {
		return "< CharacterLiteral , " +value+ " >";
	}
}
