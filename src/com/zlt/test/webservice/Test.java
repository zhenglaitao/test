package com.zlt.test.webservice;

public class Test {
	public String sayHello(String name){
		System.out.println("ni hao"+name);
		return "ni hao"+name;
	}
	public static void main(String[] args) {
		Test t = new Test();
		t.sayHello("aa");
	}
}
