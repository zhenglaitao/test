package com.zlt.test.compareto;

public class TestCompareTo {

	public static void main(String[] args) {
		String date="09:01";
		String date2="11:01";
		String date3="00:01";
		String date4="00:01";
		System.out.println(date.compareTo(date3));
		System.out.println(date.compareTo(date2));
		System.out.println(date2.compareTo(date3));
		System.out.println(date4.compareTo(date3));
	}
}
