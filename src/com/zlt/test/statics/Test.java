package com.zlt.test.statics;

class Test {
	public static void main(String[] args) {
	A a = new B();
	B b = new B();
	a.f();
	a.m();
	b.m();
	}
}

class A {
	public static void f() {
	System.out.println("hello,A");
	}

	public void m() {
	System.out.println("hello,A");
	}
}

class B extends A {
	public static void f() {
	System.out.println("hello,B");
	}

	public void m() {
	System.out.println("hello,B");
	}
}

