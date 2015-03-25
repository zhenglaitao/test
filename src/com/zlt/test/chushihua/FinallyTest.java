package com.zlt.test.chushihua;

public class FinallyTest {
	
	private final int params;
	  
	  public FinallyTest()
	  {
//	  System.out.println("aaa");
	  //params=5;
		  //调用本类其他构造函数，必须放在所在构造函数的第一行
	  this(10);//调用下面一个构造方法,参数为10,输出10;
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
