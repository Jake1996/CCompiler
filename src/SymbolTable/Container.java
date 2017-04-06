package SymbolTable;

import java.util.HashMap;

public class Container {
	public HashMap<String, Token> hm = new HashMap<String, Token>();
	Container in = null;
	public Container getOut() {
		return in;
	}
	public Container goIn() {
		Container ret = new Container();
		ret.in = this;
		return ret;
	}
	public Token search(String s) {
		Token ret = null;
		Container cur = this;
		while(cur!=null) {
			if(cur.hm.containsKey(s)) {
				ret = cur.hm.get(s);
				break;
			}
			else {
				cur = cur.in;
			}
		}
		if(ret==null) {
			System.out.println("Error : Undefined");
		}
		return ret;
	}
}
