package com.practice.array;

import java.util.Arrays;

public class Problem5 {

	public static void main(String[] args) {
		int[] arr = {12, 4, 7, 9, 2, 23, 25, 41, 
				30, 40, 28, 42, 30, 44, 48, 
				43, 50}  ;
		Arrays.sort(arr);
		int m = 7;
		int min = Integer.MAX_VALUE;
		for(int i=0;i+m-1<arr.length;i++) {
			if(arr[i+m-1] - arr[i] < min)
				min = arr[i+m-1] - arr[i];
		}
		System.out.println(min);
	}

}
