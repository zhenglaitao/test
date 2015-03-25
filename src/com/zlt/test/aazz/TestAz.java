package com.zlt.test.aazz;

import java.util.Arrays;

public class TestAz {
	
	
	public static String test(String test){
		StringBuffer sb = new StringBuffer();
		for(int i =0;i<test.length();i++){
			if(test.charAt(i)>='a' && test.charAt(i)<='z' ||test.charAt(i)>='A' && test.charAt(i)<='Z'){
				sb.append(test.charAt(i));
			}
		}
		return sb.toString();
	}
	
	public static void main(String[] args) {
		String s="asFSD8$%%@zdf;";
		System.out.println(TestAz.test(s));
		char[] real = TestAz.test(s).toCharArray();
		Arrays.sort(real);
		System.out.println(Arrays.toString(real));
	}
}
