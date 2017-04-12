package Main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import Parser.Parser;

public class GCC {

	public static void main(String[] args) {
		String program;
		BufferedReader br;
		program = "while(5==4)\n{\n}";
		try {
			br = new BufferedReader(new FileReader(new File("/home/jake/Documents/workspace/CCompiler/input.c")));
			StringBuilder sb = new StringBuilder();
			String s;
			while((s = br.readLine())!=null) {
				sb.append(s);
				sb.append('\n');
			}
			br.close();
			program = sb.toString();
		} catch (Exception e) {

		}
		Parser parse = new Parser(program);
		System.out.println(parse.output);
		
	}
}
