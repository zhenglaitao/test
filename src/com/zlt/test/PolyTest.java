
package com.zlt.test;

public class PolyTest {

	public static void main(String[] args) {
		
		B b = new B();
        C c = new C(); 
        D d = new D(); 
        
        
		A a1 = new A();
        A a2 = new B();
        a1.show(new D());
        A s = (A)b;//(super)o
        //this.show(O)��super.show(O)��this.show((super)O)��super.show((super)O)��
        System.out.println(a1.show(b));   //        A and A
        System.out.println(a1.show(c));   //        A and A
        System.out.println(a1.show(d));   //        A and D

        System.out.println(a2.show(b));   //        B and A
        System.out.println(a2.show(c));   //        B and A()
        System.out.println(a2.show(d));   //        A and D
        
        System.out.println(b.show(b));     //        B and B
        System.out.println(b.show(c));     //        B and B
        System.out.println(b.show(d));     //        A and D
	}
}
class A {
    public String show(D obj){
           return ("A and D");
    } 
    public String show(A obj){
           return ("A and A");
    } 
} 
class B extends A{
    public String show(B obj){
           return ("B and B");
    }
    public String show(A obj){
           return ("B and A");
    } 
}
class C extends B{} 
class D extends B{} 