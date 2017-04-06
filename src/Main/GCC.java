package Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import Parser.Parser;

public class GCC {

	public static void main(String[] args) {
		//System.out.println("working");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String program;
//		StringBuilder sb = new StringBuilder();
//		String s;
//		try {
//			while((s = br.readLine())!=null) {
//				sb.append(s);
//			}
//			br.close();
//		} catch (IOException e) {
//			
//		}
//		program = sb.toString();
		program = "int a = 5;\nint b = 6;\nint[5][7] c;\na = b*c[1][2];";
		Parser parse = new Parser(program);
		System.out.println(parse.output);
	}
}
