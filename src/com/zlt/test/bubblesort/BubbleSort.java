package com.zlt.test.bubblesort;

public class BubbleSort {
	public static void main(String[] args) {
		int sort[] = {67, 44, 75, 66, 89, 86, 99, 77};
		System.out.println("第0次排序结果：67, 44, 75, 66, 89, 86, 99, 77");
		for(int i=0;i<sort.length;i++){
			for(int j=0;j<sort.length-i-1;j++){
				if(sort[j]<sort[j+1]){
					int temp = sort[j];
					sort[j] = sort[j+1];
					sort[j+1] = temp;
				}
			}
			
			System.out.print("第" + (i + 1) + "次排序结果：");
	        for(int a = 0; a < sort.length; a++){
	            System.out.print(sort[a] + "\t");
	        }
	        System.out.println("");
		}
		
        System.out.println("");
        System.out.print("最终排序结果：");
        for(int a = 0; a < sort.length; a++){
            System.out.print(sort[a] + "\t");
        }
	}
}
