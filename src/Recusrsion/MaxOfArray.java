package Recusrsion;

public class MaxOfArray {
	
	public static int max(int[] arr, int idx) {
		if(idx==arr.length)
			return 0;
		return Math.max(arr[idx], max(arr,idx+1));
	}

	public static void main(String[] args) {
		int[] arr = {1,2,5,4,3};
		System.out.println(max(arr, 0));
	}

}
