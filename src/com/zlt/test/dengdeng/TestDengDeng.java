package com.zlt.test.dengdeng;

public class TestDengDeng {
	/*
	public static void main(String[] args) {
		String s="aaa";
		String ss = new String ("aaa");
		System.out.println(s==ss);  //false
		System.out.println(s.equals(ss)); //true
	}
	*/
	 public static void main(String[] args) {
		  Integer int1 = 30; 
		  Integer int2 = 30; 
//		  Integer int1 = 128; 
//		  Integer int2 = 128; 
		  Integer int3 = 0; 
		  String s="aa";
		  String ss="aaa";
		  String sss =s+"a";
		  System.out.println(sss==ss);
		  System.out.println(sss.equals(ss));
		  System.out.println("--------------");
		  System.out.println(int1 == int2); //int 类型取值范围【-128,127】
		  System.out.println(int1.equals(int2));
		  System.out.println(int1 == int2 + int3);
		  Integer int4 = new Integer(30); 
		  Integer int5 = new Integer(30); 
		  Integer int6 = new Integer(0); 
		  
		  System.out.println(int4 == int5); 
		  System.out.println(int4 == int5 + int6); 
		 }
}
