package com.zlt.test.sum20;

public class TestSum20 {

	static int[] array = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13,
		14, 15, 16, 17, 18, 19 };


		private static void count(int index, String str, int sum) {
		if ((sum - array[index]) == 0)// 找到一个组合
		{
		System.out.println("[" + str + "" + array[index] + "]=20");
		} else if ((sum - array[index]) > 0)// 继续找
		{
		str += array[index] + ",";
		sum = sum - array[index];
		for (int j = index + 1; j < array.length; j++)
		count(j, str, sum);
		}
		}


		public static void main(String[] args) {
		for (int i = 0; i < array.length; i++) {
		count(i, "", 20);
		}
		}
}
