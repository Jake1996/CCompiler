package SymbolTable;

public class Type extends Word {
	public int width=0;
	public static final Type
	INT = new Type("int", TokenNameConstant.INT, 4),
	FLOAT = new Type("float", TokenNameConstant.FLOAT, 4),
	DOUBLE = new Type("double", TokenNameConstant.DOUBLE, 8),
	LONG = new Type("long", TokenNameConstant.LONG, 8),
	CHAR = new Type("char", TokenNameConstant.CHAR, 1);
	public Type(String s,int tag,int w) {
		super(s,tag);
		width = w;
	}
}
