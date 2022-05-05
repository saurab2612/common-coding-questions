package com.practice.array;

public class Problem6 {
	public static void main(String[] args) {
		int[] arr = {5,6,7,8,9,1,2,3,4};
		int k = 4;
		System.out.println(modifiedBinarySearch(arr, 0, arr.length-1, k));
		
	}
	
	public static int modifiedBinarySearch(int[] arr, int begin, int end, int k) {
		if(end<begin || begin>end)
			return -1;
		int mid=(end+begin)/2;
		if(arr[mid] == k)
			return mid;
		else if(arr[begin] <=arr[mid-1]) {
			if(k <= arr[mid-1] && k>= arr[begin])
				return modifiedBinarySearch(arr, begin, mid-1, k);
			else
				return modifiedBinarySearch(arr, mid+1, end, k);
		} else if(arr[mid+1] <= arr[end]) {
			if(k>=arr[mid+1] && k<=arr[end])
				return modifiedBinarySearch(arr, mid+1, end, k);
			else
				return modifiedBinarySearch(arr, begin, mid-1, k);
		}
		return -1;
			
	}
}
