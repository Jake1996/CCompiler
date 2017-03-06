package SymbolTable;

import java.util.HashMap;

public class Table {
	private static HashMap<String, Token> hm = new HashMap<String, Token>();
	public static Token installId(String word) {
		Word w = new Word(word);
		if(!hm.containsKey(word)) {
			hm.put(word, w);			
		}
		return hm.get(word);
	}
	public static Token installNum(int num) {
		IntegerNumber n = new IntegerNumber(num);
		if(!hm.containsKey(num+"")) {
			hm.put(num+"", n);		
		}
		return hm.get(num+"");
	}
	public static Token installStringLiteral(String s) {
		StringLiteral sl = new StringLiteral(s);
		if(!hm.containsKey(s)) {
			hm.put(s, sl);		
		}
		return hm.get(s);
	}
	public static Token installReal(double num) {
		RealNumber n = new RealNumber(num);
		if(!hm.containsKey(num+"")) {
			hm.put(num+"", n);		
		}
		return hm.get(num+"");
	}
	public static Token installCharacter(char c) {
		CharacterLiteral cl = new CharacterLiteral(c);
		if(!hm.containsKey(c+"")) {
			hm.put(c+"", cl);		
		}
		return hm.get(c+"");
	}
}
