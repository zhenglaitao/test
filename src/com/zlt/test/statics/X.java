package com.zlt.test.statics;

public class X {
	 Y y=new Y();
	 
	 //��̬��
	 static{
	  System.out.println("tttt");
	 }
	 
	 //���췽��
	 X(){
	  System.out.println("X");
	 }
	 
	 public static void main(String[] args) {
	    new Z();
	 }
	}
	class Y{
	 Y(){
	  System.out.println("Y");
	 }
	}
	class Z extends X{
	 Y y=new Y();
	 static{
	  System.out.println("tt");
	 }
	 Z(){
	  System.out.println("Z");
	 } 
	}
	
	//  tttt-tt-