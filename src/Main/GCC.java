package Main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import Parser.Parser;

public class GCC {

	public static void main(String[] args) {
		String program;
		program = "int a;\na=5;\nint b;\nb = 6;\nint[5][7] c;\na = b*c[1][2];";
		BufferedReader br;
		try {
			br = new BufferedReader(new FileReader(new File("/home/jake/Documents/workspace/CCompiler/input.c")));
			StringBuilder sb = new StringBuilder();
			String s;
			while((s = br.readLine())!=null) {
				sb.append(s);
			}
			br.close();
			program = sb.toString();
		} catch (Exception e) {

		}
		Parser parse = new Parser(program);
		System.out.println(parse.output);
	}
}
