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
		for (int i = 0; i < 32; i++) {// ����32��bit
			count1 = count0 = temp1 = temp0 = 0;
			for (int j = 0; j < d.length; j++) {// ��������
				if (isON(d[j], i) == 0) {// ��ǰbitΪ0
					temp0 ^= d[j];
					count0++;
				} else {// ��ǰbitΪ1
					temp1 ^= d[j];
					count1++;
				}
			}
			if ((count1 & 0x1) == 1) {// count1��������
				if (temp0 == 0) {// ��ô���е�����������count1�Ǳ�
					continue;
				} else {
					System.out.println(temp1);// ����count1�����������һ������
                                                     break;
				}
			} else {// count0��������
				if (temp1 == 0) {// ��ô���е�����������count0���
					continue;
				} else {// ����count0����һ������
					System.out.println(temp0);
                                              break;
				}
			}
		}
	}

	// i�ĵ�mλ�Ƿ�Ϊ1
	static int isON(int i, int m) {
		int d=1 << m;
		int f=i & d;
		return f;
	}
}
