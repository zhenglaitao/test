package com.zlt.test.integer;

public class TestReverseInt {

	public static void main(String[] args) {
		int a = 123450;
		int x;
		int num =0;
		while(a>0){
			
			x = a%10;
			num = num*10+x;
			a = a/10;
			System.out.println(num);
		}
		System.out.println(num+"--");
	}
}
