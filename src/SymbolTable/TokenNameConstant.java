package SymbolTable;

public class TokenNameConstant {
	public static int KEYWORD = 1;
	public static int BRACKET = 2;
	public static int IDENTIFIER = 3;
	public static int OPERATOR = 4;
	public static int INTEGERNUMBER = 5;
	public static int REALNUMBER = 6;
	public static int STRINGLITERAL = 7;
	public static int CHARACTERLITERAL = 8;
	public static int SEMICOLON = 9;
	
	//KEYWORDS
	public static int WHILE = 101;
	public static int PRINT = 102;
	public static int SCAN = 103;
	public static int BREAK = 104;
	public static int CONTINUE = 105;
	public static int RETURN = 106;
	public static int INT = 107;
	public static int FLOAT = 108;
	public static int DOUBLE = 109;
	public static int CHAR = 110;
	public static int ARRAYINT = 111;
	public static int ARRAYFLOAT = 112;
	public static int ARRAYDOUBLE = 113;
	public static int ARRAYCHAR = 114;
	
	//BRACKETS
	public static int OPENFLOWER = 201;
	public static int CLOSEFLOWER = 202;
	public static int OPENPARAN = 203;
	public static int CLOSEPARAN = 204;
	public static int OPENSQUARE = 205;
	public static int CLOSESQUARE = 206;
	
	//OPERATORS
	public static int ADD = 401;
	public static int ADDEQUAL = 402;
	public static int INCREMENT = 403;
	public static int SUBTRACT = 404;
	public static int SUBTRACTEQUAL = 405;
	public static int DECREMENT = 406;
	public static int MULTIPLY = 407;
	public static int MULTIPLYEQUAL = 408;
	public static int DIVIDE = 409;
	public static int DIVIDEEQUAL = 410;
	public static int MODULUS = 411;
	public static int MODULUSEQUAL = 412;
	public static int GT = 413;
	public static int GE = 414;
	public static int LT = 415;
	public static int LE = 416;
	public static int EQ = 417;
	public static int ASSIGN = 418;
	public static int NE = 419;
	public static int NOT = 420;
	public static int AND = 421;
	public static int OR = 422;
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
