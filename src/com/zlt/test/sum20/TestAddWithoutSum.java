package com.zlt.test.sum20;

public class TestAddWithoutSum {
	
	
	static int AddWithoutArithmetic(int num1, int num2)
	{
	        if(num2 == 0)
	                return num1;
	 
	        int sum = num1 ^ num2;
	        int carry = (num1 & num2) << 1;
	 
	        return AddWithoutArithmetic(sum, carry);
	}
	
	public static void main(String[] args) {
		System.out.println(TestAddWithoutSum.AddWithoutArithmetic(17, 44));
//		
//		int i=22;
//		int j=49;
//		System.out.println(i & j);
//		System.out.println(i ^ j);
	}
}
