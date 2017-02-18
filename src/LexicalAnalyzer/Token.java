package LexicalAnalyzer;

public class Token {
	int type;
	int value;
	public Token(String s) {
		switch(s) {
		case "int" :	
		case "double" :	
		case "float" :	
		case "char" :	
		case "long" :	type = TokenNameConstant.KEYWORD; break;
		//use an automata on s to know the type
		
		}
		
	}
	
}
