package com.zlt.test.statics;

public class TestStatic {
	static int a;
	static int b=3;
	int c=4;
	public void test1(){
		a=4;
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
	}
	public static void test2(){
		int a=5;
		System.out.println(a);
//		System.out.println(c);
	}
	public static void main(String[] args) {
		TestStatic a = new TestStatic();
		a.test1();
		System.out.println();
	}
}
