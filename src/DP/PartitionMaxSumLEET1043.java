package DP;

import java.util.Arrays;

public class PartitionMaxSumLEET1043 {
	
	public static int maxSumAfterPartitioning(int[] arr, int k) {
        int[] dp = new int[arr.length];
        Arrays.fill(dp, -1);
		return maxSumUtil(0,k,arr,dp);
    }

	private static int maxSumUtil(int i, int k, int[] arr, int[] dp) {
		if(i == arr.length)
			return 0;
		
		if(dp[i]!=-1) return dp[i];
		int maxi = Integer.MIN_VALUE;
		int sum = 0;
		for(int j=i;j<Math.min(arr.length,i+k);j++) {
			if(arr[j]>maxi)
				maxi = arr[j];
			int sumi = (j-i+1) * maxi + maxSumUtil(j+1, k, arr, dp);
			if(sumi>sum)
				sum = sumi;
		}
		return dp[i] = sum;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
