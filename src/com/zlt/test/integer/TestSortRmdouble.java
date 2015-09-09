package com.zlt.test.integer;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

public class TestSortRmdouble {

	public static void main(String[] args) {
		int[] a = new int[]{4,6,3,2,6,43,6,0,8};
		Arrays.sort(a);
		Set<Integer> set = new TreeSet<Integer>();
		for (Integer object : a) {
			set.add(object);
		}
		for (Integer integer : set) {
			System.out.println(integer);
		}
	}
}
