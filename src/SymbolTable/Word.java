package SymbolTable;

public class Word extends Token {
	private String lexeme;
	private Type type = null;
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
	public Type getType() {
		return type;
	}
	public void setType(Type type) {
		this.type = type;
	}
}
