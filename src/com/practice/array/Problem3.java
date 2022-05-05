package com.practice.array;

public class Problem3 {
	public static void main(String[] args) {
		int[] arr = {3,-1,2};
		int max = Integer.MIN_VALUE;
		int cur = 0;
		for(int i=0;i<arr.length;i++) {
			cur = cur + arr[i];
			if(cur>max)
				max=cur;
			if(cur<0)
				cur =0;
		}
		
		System.out.println(max);
		
	}

}
