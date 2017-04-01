package SymbolTable;

public class Array extends Type {
	Type parent = null;
	int size; 
	public Array(int size,Type type) {
		super("[]",TokenNameConstant.ARRAY, type.width*size);
		parent = type;
		this.size = size;
	}
	public String toString() {
		return parent+"[ "+size+" ]";
	}
}
