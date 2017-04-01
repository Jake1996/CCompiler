package SymbolTable;

public class Word extends Token {
	private String lexeme;
	public Word(String s) {
		super(TokenNameConstant.IDENTIFIER);
		lexeme=s;
	}
	public Word(String s, int tag) {
		super(tag);
		lexeme=s;		
	}
	public String getLexeme() {
		return lexeme;
	}
	@Override
	public String toString() {
		return "< Identifier , " +lexeme+ " >";
	}
}
