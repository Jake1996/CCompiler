package SymbolTable;

public abstract class Number extends Token {
	public Number(int tag) {
		super(tag);
	}
	abstract public java.lang.Number getValue();
}