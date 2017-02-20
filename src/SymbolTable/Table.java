package SymbolTable;

import java.util.HashMap;

public class Table {
	private static HashMap<String, Token> hm = new HashMap<>();
	public static Token installId(String word) {
		Word w = new Word(word);
		hm.put(word, w);
		return w;
	}
	public static Token installNum(int num) {
		Number n = new Number(num);
		hm.put(num+"", n);
		return n;
	}
}
