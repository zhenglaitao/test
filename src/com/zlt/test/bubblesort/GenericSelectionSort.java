package com.zlt.test.bubblesort;

import java.util.Arrays;

public class GenericSelectionSort{
	
	 public static void main(String[] args) {
	        Integer[] iArr = {1,3,5,4,9,6,7,11,2,3};
	        GenericSelectionSort.<Integer>selectionSort(iArr);
	        System.out.println(Arrays.toString(iArr));
	    }
	    public static <E extends Comparable<E>> void selectionSort(E[] list){
	        int min;
	        E tmp;
	        for(int i = 0; i < list.length-1; i ++){
	            min = i;
	            for( int j = i+1 ; j < list.length; j ++){
	                if(list[j].compareTo(list[min]) > 0){
	                    min = j;
	                }
	            }
	             
	            tmp = list[i];
	            list[i] = list[min];
	            list[min] = tmp;
	        }
	    }
}
