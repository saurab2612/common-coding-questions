package com.practice.array;

public class Problem1 {
	
	public static void main(String[] args) {
		
		int[] arr= {1,2,3,9,-1,4,5,6};
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		
		for(int i=0; i<arr.length;i++) {
			if(arr[i]>max)
				max=arr[i];
			if(arr[i]<min){
				min=arr[i];
			}
		}
		
		System.out.println("max : " + max);
		System.out.println("Min : " + min);
		
	}

}
