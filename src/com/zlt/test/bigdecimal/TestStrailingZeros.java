package com.zlt.test.bigdecimal;

import java.math.BigDecimal;

public class TestStrailingZeros {
	
	public static void main(String[] args) {
		BigDecimal a = new BigDecimal(1.232);
		BigDecimal a1 = new BigDecimal(0.001);
		BigDecimal a2 = new BigDecimal(10.0);
		BigDecimal a3 = new BigDecimal(11.001);
		System.out.println(a.stripTrailingZeros().toPlainString());
		System.out.println(a1.stripTrailingZeros().toPlainString());
		System.out.println(a2.stripTrailingZeros().toPlainString());
		System.out.println(a3.stripTrailingZeros().toPlainString());
	}
}
