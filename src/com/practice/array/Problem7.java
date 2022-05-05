package com.practice.array;

public class Problem7 {

	public static void main(String[] args) {
		int[] arr = {1,1,5};
		int temp1 = -1;
		int temp2 = -1;
		for(int i=arr.length-1;i>0;i--) {
			if(arr[i-1]<arr[i])
				temp1=i-1;
		}
		if(temp1!=-1) {
		for(int i=arr.length-1;i>temp1;i--) {
			if(arr[i]>arr[temp1]) {
				temp2=i;
			}
		}
		
		int k = arr[temp1];
		arr[temp1] = arr[temp2];
		arr[temp2] = k;
		}
		
		reverseArray(arr,temp1+1);
		
		for(int i=0;i<arr.length;i++) {
			System.out.println(arr[i]);
		}
		
	}

	private static void reverseArray(int[] arr, int begin) {
		
		int mid = (arr.length + begin -1)/2;
		for(int i =begin,j=arr.length-1;i<=mid;i++,j--) {
			int temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
		}
		
	}

}
