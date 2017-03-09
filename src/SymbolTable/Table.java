package SymbolTable;

import java.util.HashMap;

public class Table {
	private static HashMap<String, Token> hm = new HashMap<String, Token>();
	public static Token installId(String word) {
		if(!hm.containsKey(word)) {
			Word w = new Word(word);
			hm.put(word, w);			
		}
		return hm.get(word);
	}
	public static void installToken(String s,Token t) {
		hm.put(s, t);
	}
	public static Token installNum(int num) {
		if(!hm.containsKey(num+"")) {
			IntegerNumber n = new IntegerNumber(num);
			hm.put(num+"", n);		
		}
		return hm.get(num+"");
	}
	public static Token installStringLiteral(String s) {
		if(!hm.containsKey(s)) {
			StringLiteral sl = new StringLiteral(s);
			hm.put(s, sl);		
		}
		return hm.get(s);
	}
	public static Token installReal(double num) {
		if(!hm.containsKey(num+"")) {
			RealNumber n = new RealNumber(num);
			hm.put(num+"", n);		
		}
		return hm.get(num+"");
	}
	public static Token installCharacter(String c) {
		if(!hm.containsKey(c)) {
			CharacterLiteral cl = new CharacterLiteral(c);
			hm.put(c+"", cl);		
		}
		return hm.get(c+"");
	}
	public static Token getToken(String s) {
		return hm.get(s);
	}
}
