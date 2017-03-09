package SymbolTable;

public class Token {
	int tag;
	public Token(int tag) {
		this.tag = tag;		
	}
	
	@Override
	public String toString() {
		return "< "+TokenNameConstant.tokenName(tag)+" >";
	}
}
