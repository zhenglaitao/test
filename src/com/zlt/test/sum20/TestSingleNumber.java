package com.zlt.test.sum20;

public class TestSingleNumber {

	public static void main(String ss[]) {
		get(new int[] { 6,6,4, 5, 1 });
	}

	public static void get(int[] d) {
		int temp1 = 0;
		int count1 = 0;
		int temp0 = 0;
		int count0 = 0;
		for (int i = 0; i < 32; i++) {// 遍历32个bit
			count1 = count0 = temp1 = temp0 = 0;
			for (int j = 0; j < d.length; j++) {// 遍历数组
				if (isON(d[j], i) == 0) {// 当前bit为0
					temp0 ^= d[j];
					count0++;
				} else {// 当前bit为1
					temp1 ^= d[j];
					count1++;
				}
			}
			if ((count1 & 0x1) == 1) {// count1是奇数个
				if (temp0 == 0) {// 那么所有的三个数都在count1那边
					continue;
				} else {
					System.out.println(temp1);// 否则count1的异或结果就是一个数字
                                                     break;
				}
			} else {// count0是奇数个
				if (temp1 == 0) {// 那么所有的三个数都在count0这边
					continue;
				} else {// 否则count0就是一个数字
					System.out.println(temp0);
                                              break;
				}
			}
		}
	}

	// i的第m位是否为1
	static int isON(int i, int m) {
		int d=1 << m;
		int f=i & d;
		return f;
	}
}
