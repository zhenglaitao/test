package com.zlt.test.chushihua;

public class FinallyTest {
	
	private final int params;
	  
	  public FinallyTest()
	  {
//	  System.out.println("aaa");
	  //params=5;
		  //���ñ����������캯��������������ڹ��캯���ĵ�һ��
	  this(10);//��������һ�����췽��,����Ϊ10,���10;
	  System.out.println("aaa");
	  }
	  public FinallyTest(int para)
	  {
	  System.out.println("aaabbb"+para);
	  params=para;
	  }
	  public static void main(String[] args)
	  {
//	  FinallyTest ft=new FinallyTest(20);
//	  System.out.println(ft.params); 
	  FinallyTest ft2=new FinallyTest();
	  System.out.println(ft2.params); 
	  }
}
