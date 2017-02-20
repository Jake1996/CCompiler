package SymbolTable;

public class CharacterLiteral extends Token {
	char value;
	public CharacterLiteral(char c) {
		super(TokenNameConstant.CHARACTERLITERAL);
		value=c;
	}
}
