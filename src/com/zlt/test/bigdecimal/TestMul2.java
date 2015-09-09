package com.zlt.test.bigdecimal;

import java.math.BigDecimal;

public class TestMul2 {

	public static void main(String[] args) {
		double a = 80;
		System.out.println(TestMul2.getNum(a));;
	}
	
	public static int getNum(double a){
		int num = 0;
		BigDecimal b1 = new BigDecimal(""+a);
		while(b1.divide(new BigDecimal("2"),10,BigDecimal.ROUND_HALF_UP).doubleValue() > 10){
			b1 = new BigDecimal(b1.divide(new BigDecimal("2"),10,BigDecimal.ROUND_HALF_UP).doubleValue());
			num++;
		}
		return num;
	}
}
