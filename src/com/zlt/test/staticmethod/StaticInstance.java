package com.zlt.test.staticmethod;

public class StaticInstance {
	
	public StaticInstance() {
		System.out.println("wo zou le");
	}

	public static void go(){
		
	}
	
	public static void main(String[] args) {
		StaticInstance.go();
		StaticInstance ss = new StaticInstance();
	}
}
