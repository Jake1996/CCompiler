package LexicalAnalyzer;

import Exceptions.NumberFormatException;
import Helper.*;
import SymbolTable.*;

public class Lexer {
	private char arr[];
	private int lexemeBegin;
	private int lexemeEnd;
	private int line;
	public Lexer(String program) {
		arr = program.toCharArray();
		lexemeBegin = 0;
		lexemeEnd = 0;
		line = 1;
		initialize();
	}
	
	public void initialize()  {
		Table.installToken(";", new Token(TokenNameConstant.SEMICOLON));
		
		//reserved words
		Table.installToken("while", new Token(TokenNameConstant.WHILE));
		Table.installToken("printf", new Token(TokenNameConstant.PRINT));
		Table.installToken("scanf", new Token(TokenNameConstant.SCAN));
		Table.installToken("break", new Token(TokenNameConstant.BREAK));
		Table.installToken("continue", new Token(TokenNameConstant.CONTINUE));
		Table.installToken("return", new Token(TokenNameConstant.RETURN));
		Table.installToken("int", new Token(TokenNameConstant.INT));
		Table.installToken("float", new Token(TokenNameConstant.FLOAT));
		Table.installToken("double", new Token(TokenNameConstant.DOUBLE));
		Table.installToken("char", new Token(TokenNameConstant.CHAR));

		//brackets
		Table.installToken("{", new Token(TokenNameConstant.OPENFLOWER));
		Table.installToken("}", new Token(TokenNameConstant.CLOSEFLOWER));
		Table.installToken("(", new Token(TokenNameConstant.OPENPARAN));
		Table.installToken(")", new Token(TokenNameConstant.CLOSEPARAN));
		Table.installToken("[", new Token(TokenNameConstant.OPENSQUARE));
		Table.installToken("]", new Token(TokenNameConstant.CLOSESQUARE));
		
		//operators
		Table.installToken("+", new Token(TokenNameConstant.ADD));
		Table.installToken("+=", new Token(TokenNameConstant.ADDEQUAL));
		Table.installToken("++", new Token(TokenNameConstant.INCREMENT));
		Table.installToken("-", new Token(TokenNameConstant.SUBTRACT));
		Table.installToken("-=", new Token(TokenNameConstant.SUBTRACTEQUAL));
		Table.installToken("--", new Token(TokenNameConstant.DECREMENT));
		Table.installToken("*", new Token(TokenNameConstant.MULTIPLY));
		Table.installToken("*=", new Token(TokenNameConstant.MODULUSEQUAL));
		Table.installToken("/", new Token(TokenNameConstant.DIVIDE));
		Table.installToken("/=", new Token(TokenNameConstant.DIVIDEEQUAL));
		Table.installToken("%", new Token(TokenNameConstant.MODULUS));
		Table.installToken("%=", new Token(TokenNameConstant.MODULUSEQUAL));
		Table.installToken(">", new Token(TokenNameConstant.GT));
		Table.installToken(">=", new Token(TokenNameConstant.GE));
		Table.installToken("<", new Token(TokenNameConstant.LT));
		Table.installToken("<=", new Token(TokenNameConstant.LE));
		Table.installToken("==", new Token(TokenNameConstant.EQ));
		Table.installToken("=", new Token(TokenNameConstant.ASSIGN));
		Table.installToken("!=", new Token(TokenNameConstant.NE));
		Table.installToken("!", new Token(TokenNameConstant.NOT));
		Table.installToken("&&", new Token(TokenNameConstant.AND));
		Table.installToken("||", new Token(TokenNameConstant.OR));
	
	}
	public Token getNextToken() {
		try {
			while(true) {
				if(arr[lexemeBegin]=='/') {
					lexemeBegin++;
					if(arr[lexemeBegin]=='/') { //Single line comment
						lexemeBegin++;
						while(arr[lexemeBegin]!='\n') {
							lexemeBegin++;
						}
						line++;
					}
					else if(arr[lexemeBegin]=='*') { //multi line comment
						lexemeBegin++;
						while(arr[lexemeBegin]!='*'&&arr[lexemeBegin+1]!='/') {
							if(arr[lexemeBegin]=='\n')
								line++;
							lexemeBegin++;
						}
						lexemeBegin++;
					}
				}
				else if(arr[lexemeBegin]==' ') { //ignore whitespace
					lexemeBegin++;
				}
				else if(arr[lexemeBegin]=='\n') { //ignore new lines
					lexemeBegin++;
					line++;
				}
				else {
					break;
				}
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			return null;
		}
		lexemeEnd = lexemeBegin;
		if(lexemeBegin>=arr.length) return null;
		if(CharacterHelper.isLetter(arr[lexemeBegin])) { //Identifier
			StringBuilder s = new StringBuilder();
			while(lexemeEnd<arr.length&&(CharacterHelper.isLetterNumber(arr[lexemeEnd]))) {
				s.append(arr[lexemeEnd]);
				lexemeEnd++;
			}
			lexemeBegin = lexemeEnd;
			return Table.installId(s.toString());
		}
		else if(Character.isDigit(arr[lexemeBegin])) { //number
			StringBuilder s = new StringBuilder();
			int state=0;
			while(lexemeEnd<arr.length) {
				switch(state) {
				case 0:
					if(Character.isDigit(arr[lexemeEnd])) {}
					else if(arr[lexemeEnd]=='.') {
						state = 1;
					}
					else if(arr[lexemeEnd]=='e'||arr[lexemeEnd]=='E') {
						state = 3;
					}
					else {
						lexemeBegin=lexemeEnd;
						try {
							int num = Integer.parseInt(s.toString());
							return Table.installNum(num);
						}
						catch (Exception e) {
							double num = Double.parseDouble(s.toString());
							return Table.installReal(num);
						}
					}
					break;
				case 1:
					if(Character.isDigit(arr[lexemeEnd])) {
						state = 2;
					}
					else {
						new NumberFormatException(s.toString(), line);
					}
					break;
				case 2: 
					if(Character.isDigit(arr[lexemeEnd])) {}
					else if(arr[lexemeEnd]=='e'||arr[lexemeEnd]=='E') {
						state = 3;
					}
					else {
						lexemeBegin=lexemeEnd;
						try {
							int num = Integer.parseInt(s.toString());
							return Table.installNum(num);
						}
						catch (Exception e) {
							double num = Double.parseDouble(s.toString());
							return Table.installReal(num);
						}
					}
					break;
				case 3:
					if(Character.isDigit(arr[lexemeEnd])) {
						state = 5;
					}
					else if(arr[lexemeEnd]=='+'||arr[lexemeEnd]=='-') {
						state=4;
					}
					else {
						new NumberFormatException(s.toString(), line);
					}
					break;
				case 4:
					if(Character.isDigit(arr[lexemeEnd])) {
						state = 5;
					}
					else {
						new NumberFormatException(s.toString(), line);
					}
					break;
				case 5:
					if(Character.isDigit(arr[lexemeEnd])) {}
					else {
						lexemeBegin=lexemeEnd;
						try {
							int num = Integer.parseInt(s.toString());
							return Table.installNum(num);
						}
						catch (Exception e) {
							double num = Double.parseDouble(s.toString());
							return Table.installReal(num);
						}
					}
					break;
				}
				s.append(arr[lexemeEnd]);
				lexemeEnd++;
			}
			try {
				int num = Integer.parseInt(s.toString());
				return Table.installNum(num);
			}
			catch (Exception e) {
				double num = Double.parseDouble(s.toString());
				return Table.installReal(num);
			}
		}
		else {  //special character
			if(arr[lexemeEnd]=='('||arr[lexemeEnd]==')'||arr[lexemeEnd]=='{'||arr[lexemeEnd]=='}'
					||arr[lexemeEnd]=='['||arr[lexemeEnd]==']'||arr[lexemeEnd]==';') {
				lexemeEnd++;
				lexemeBegin = lexemeEnd;
				return Table.getToken(arr[lexemeEnd-1]+"");
			}
			else if(arr[lexemeEnd]=='<') {
				if(arr[lexemeEnd+1]=='=') {
					lexemeEnd+=2;
					lexemeBegin = lexemeEnd;
					return Table.getToken("<=");
				}
				else {
					lexemeEnd++;
					lexemeBegin=lexemeEnd;
					return Table.getToken("<");
				}
			}
			else if(arr[lexemeEnd]=='>') {
				if(arr[lexemeEnd+1]=='=') {
					lexemeEnd+=2;
					lexemeBegin = lexemeEnd;
					return Table.getToken(">=");
				}
				else {
					lexemeEnd++;
					lexemeBegin=lexemeEnd;
					return Table.getToken(">");
				}
			}
			else if(arr[lexemeEnd]=='!') {
				if(arr[lexemeEnd+1]=='=') {
					lexemeEnd+=2;
					lexemeBegin = lexemeEnd;
					return Table.getToken("!=");
				}
				else {
					lexemeEnd++;
					lexemeBegin=lexemeEnd;
					return Table.getToken("!");
				}
			}
			else if(arr[lexemeEnd]=='=') {
				if(arr[lexemeEnd+1]=='=') {
					lexemeEnd+=2;
					lexemeBegin = lexemeEnd;
					return Table.getToken("==");
				}
				else {
					lexemeEnd++;
					lexemeBegin=lexemeEnd;
					return Table.getToken("=");
				}
			}
			else if(arr[lexemeEnd]=='+') {
				if(arr[lexemeEnd+1]=='=') {
					lexemeEnd+=2;
					lexemeBegin = lexemeEnd;
					return Table.getToken("+=");
				}
				else if(arr[lexemeEnd+1]=='+') {
					lexemeEnd+=2;
					lexemeBegin = lexemeEnd;
					return Table.getToken("++");
				}
				else {
					lexemeEnd++;
					lexemeBegin=lexemeEnd;
					return Table.getToken("+");
				}
			}
			else if(arr[lexemeEnd]=='-') {
				if(arr[lexemeEnd+1]=='=') {
					lexemeEnd+=2;
					lexemeBegin = lexemeEnd;
					return Table.getToken("-=");
				}
				else if(arr[lexemeEnd+1]=='-') {
					lexemeEnd+=2;
					lexemeBegin = lexemeEnd;
					return Table.getToken("--");
				}
				else {
					lexemeEnd++;
					lexemeBegin=lexemeEnd;
					return Table.getToken("-");
				}
			}
			else if(arr[lexemeEnd]=='*') {
				if(arr[lexemeEnd+1]=='=') {
					lexemeEnd+=2;
					lexemeBegin = lexemeEnd;
					return Table.getToken("*=");
				}
				else {
					lexemeEnd++;
					lexemeBegin=lexemeEnd;
					return Table.getToken("*");
				}
			}else if(arr[lexemeEnd]=='/') {
				if(arr[lexemeEnd+1]=='=') {
					lexemeEnd+=2;
					lexemeBegin = lexemeEnd;
					return Table.getToken("/=");
				}
				else {
					lexemeEnd++;
					lexemeBegin=lexemeEnd;
					return Table.getToken("/");
				}
			}
			else if(arr[lexemeEnd]=='%') {
				if(arr[lexemeEnd+1]=='=') {
					lexemeEnd+=2;
					lexemeBegin = lexemeEnd;
					return Table.getToken("%=");
				}
				else {
					lexemeEnd++;
					lexemeBegin=lexemeEnd;
					return Table.getToken("%");
				}
			}
			else if(arr[lexemeEnd]=='&') {
				lexemeEnd+=2;
				lexemeBegin = lexemeEnd;
				return Table.getToken("&&");
			}
			else if(arr[lexemeEnd]=='|') {
				lexemeEnd+=2;
				lexemeBegin = lexemeEnd;
				return Table.getToken("||");
			}
			//for string literals
			else if(arr[lexemeEnd]=='"') {//String Literal
				StringBuilder s = new StringBuilder();
				lexemeEnd++;
				s.append('"');
				while(lexemeEnd<arr.length&&arr[lexemeEnd]!='"') {				
					s.append(arr[lexemeEnd]);
					lexemeEnd++;
				}
				lexemeEnd++;
				lexemeBegin=lexemeEnd;
				s.append('"');
				return Table.installStringLiteral(s.toString());
			}
			else if(arr[lexemeEnd]=='\'') {//Character Literal
				StringBuilder s = new StringBuilder();
				lexemeEnd++;
				s.append('\'');
				while(lexemeEnd<arr.length&&arr[lexemeEnd]!='\'') {				
					s.append(arr[lexemeEnd]);
					lexemeEnd++;
				}
				lexemeEnd++;
				lexemeBegin=lexemeEnd;
				s.append('\'');
				return Table.installCharacter(s.toString());
			}

		}
		return null;
	}
}
