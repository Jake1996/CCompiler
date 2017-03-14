package SymbolTable;

public class TokenNameConstant {
	
	public static final int KEYWORD = 1;
	public static final int BRACKET = 2;
	public static final int IDENTIFIER = 3;
	public static final int OPERATOR = 4;
	public static final int INTEGERNUMBER = 5;
	public static final int REALNUMBER = 6;
	public static final int STRINGLITERAL = 7;
	public static final int CHARACTERLITERAL = 8;
	public static final int SEMICOLON = 9;
	
	//KEYWORDS
	public static final int WHILE = 101;
	public static final int PRINT = 102;
	public static final int SCAN = 103;
	public static final int BREAK = 104;
	public static final int CONTINUE = 105;
	public static final int RETURN = 106;
	public static final int INT = 107;
	public static final int FLOAT = 108;
	public static final int DOUBLE = 109;
	public static final int CHAR = 110;
	public static final int ARRAYINT = 111;
	public static final int ARRAYFLOAT = 112;
	public static final int ARRAYDOUBLE = 113;
	public static final int ARRAYCHAR = 114;
	
	//BRACKETS
	public static final int OPENFLOWER = 201;
	public static final int CLOSEFLOWER = 202;
	public static final int OPENPARAN = 203;
	public static final int CLOSEPARAN = 204;
	public static final int OPENSQUARE = 205;
	public static final int CLOSESQUARE = 206;
	
	//OPERATORS
	public static final int ADD = 401;
	public static final int ADDEQUAL = 402;
	public static final int INCREMENT = 403;
	public static final int SUBTRACT = 404;
	public static final int SUBTRACTEQUAL = 405;
	public static final int DECREMENT = 406;
	public static final int MULTIPLY = 407;
	public static final int MULTIPLYEQUAL = 408;
	public static final int DIVIDE = 409;
	public static final int DIVIDEEQUAL = 410;
	public static final int MODULUS = 411;
	public static final int MODULUSEQUAL = 412;
	public static final int GT = 413;
	public static final int GE = 414;
	public static final int LT = 415;
	public static final int LE = 416;
	public static final int EQ = 417;
	public static final int ASSIGN = 418;
	public static final int NE = 419;
	public static final int NOT = 420;
	public static final int AND = 421;
	public static final int OR = 422;
	public static String tokenName(int token) {
		
		if(token==WHILE)return "while";
		if(token==PRINT)return "printf";
		if(token==SCAN)return "scanf";
		if(token==BREAK)return "break"; 
		if(token==CONTINUE)return "continue"; 
		if(token==RETURN)return "return"; 
		if(token==INT)return "int"; 
		if(token==FLOAT)return "float"; 
		if(token==DOUBLE)return "double"; 
		if(token==CHAR)return "char"; 

		//brackets
		if(token==OPENFLOWER)return "{"; 
		if(token==CLOSEFLOWER)return "}"; 
		if(token==OPENPARAN)return "("; 
		if(token==CLOSEPARAN)return ")"; 
		if(token==OPENSQUARE)return "["; 
		if(token==CLOSESQUARE)return "]"; 
		
		//operators
		if(token==ADD)return "+"; 
		if(token==ADDEQUAL)return "+="; 
		if(token==INCREMENT)return "++"; 
		if(token==SUBTRACT)return "-"; 
		if(token==SUBTRACTEQUAL)return "-="; 
		if(token==DECREMENT)return "--"; 
		if(token==MULTIPLY)return "*"; 
		if(token==MODULUSEQUAL)return "*="; 
		if(token==DIVIDE)return "/"; 
		if(token==DIVIDEEQUAL)return "/="; 
		if(token==MODULUS)return "%"; 
		if(token==MODULUSEQUAL)return "%="; 
		if(token==GT)return ">"; 
		if(token==GE)return ">="; 
		if(token==LT)return "<"; 
		if(token==LE)return "<="; 
		if(token==EQ)return "=="; 
		if(token==ASSIGN)return "="; 
		if(token==NE)return "!="; 
		if(token==NOT)return "!"; 
		if(token==AND)return "&&"; 
		if(token==OR)return "||"; 
		return "";
	}
}
