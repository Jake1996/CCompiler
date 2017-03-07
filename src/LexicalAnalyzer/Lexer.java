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
		Table.installToken("", new Token(TokenNameConstant.));
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
