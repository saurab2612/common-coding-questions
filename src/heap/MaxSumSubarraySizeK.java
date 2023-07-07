package heap;

import java.util.ArrayList;

public class MaxSumSubarraySizeK {
	
	static int maximumSumSubarray(int K, ArrayList<Integer> Arr,int N){
		int i=0;
		int j=0;
		int sum =0;
		int max=Integer.MIN_VALUE;
		while(j< N) {
			sum = sum + Arr.get(j);
			if(j-i+1 < K) {
				j++;
			}else if(j-i+1 == K) {
				max= Math.max(sum, max);
				sum = sum - Arr.get(i);
				i++;
				j++;
			}
		}
		return max;
		
    }

	public static void main(String[] args) {
		ArrayList<Integer> arr = new ArrayList<>();
		arr.add(100);
		arr.add(200);
		arr.add(300);
		arr.add(400);
		maximumSumSubarray(2, arr, 4);
		
	}

}
