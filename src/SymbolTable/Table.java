package SymbolTable;

import java.util.HashMap;

public class Table {
	private static Container c = new Container();
	private static HashMap<String, Token> hm = new HashMap<String, Token>();
//	public static Token installId(String word) {
//		if(!hm.containsKey(word)) {
////			if(!c.hm.containsKey(word)) {
//			if(c.search(word)==null) {
//				Word w = new Word(word);
//				c.hm.put(word, w);
//			}
//			return c.search(word);
//		}
//		else
//			return hm.get(word);
//	}
	public static Token installId(Word word) {
		c.hm.put(word.getLexeme(), word);
		return word;
	}
	public static void installToken(String s,Token t) {
		hm.put(s, t);
	}
	public static Token installNum(int num) {
		if(!c.hm.containsKey(num+"")) {
			IntegerNumber n = new IntegerNumber(num);
			c.hm.put(num+"", n);		
		}
		return c.hm.get(num+"");
	}
	public static Token installStringLiteral(String s) {
		if(!c.hm.containsKey(s)) {
			StringLiteral sl = new StringLiteral(s);
			c.hm.put(s, sl);		
		}
		return c.hm.get(s);
	}
	public static Token installReal(double num) {
		if(!c.hm.containsKey(num+"")) {
			RealNumber n = new RealNumber(num);
			c.hm.put(num+"", n);		
		}
		return c.hm.get(num+"");
	}
	public static Token installCharacter(String ch) {
		if(!c.hm.containsKey(ch)) {
			CharacterLiteral cl = new CharacterLiteral(ch);
			c.hm.put(ch+"", cl);		
		}
		return c.hm.get(ch+"");
	}
	public static Token getToken(String s) {
		if(hm.containsKey(s))
			return hm.get(s);
		return c.search(s);
	}
	public static Token getReserved(String s) {
		if(hm.containsKey(s)) return hm.get(s);
		else return null;
	}
	public static void newscope() {
		c = c.goIn();
	}
	public static void oldscope() {
		c = c.getOut();
	}
}
