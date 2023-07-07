package DP.CodeStudio;

import java.util.Arrays;

public class BurstBalloonsLEET312 {
	
	public static int maxCoins(int[] nums) {
		
		int[][] dp = new int[nums.length+1][nums.length+1];
		for(int[] row: dp)
			Arrays.fill(row, -1);
		
		int[] numsNew = new int[nums.length+2];
		numsNew[0] = 1;
		numsNew[nums.length+1] = 1;
		for(int i=1;i<=nums.length;i++)
			numsNew[i] = nums[i-1];
		
		
         return maxCoinsRecur(1,nums.length,numsNew, dp);
    }

	private static int maxCoinsRecur(int i, int j, int[] numsNew, int[][] dp) {
		if(i>j) return 0;
		
		if(dp[i][j] != -1) return dp[i][j];
		int min = -1000000000;
		for(int k=i;k<=j;k++) {
			int coins = numsNew[i-1] * numsNew[k] * numsNew[j+1] + maxCoinsRecur(i, k-1, numsNew,dp) + maxCoinsRecur(k+1, j, numsNew,dp);
			if(coins>min)
				min = coins;
		}
		return dp[i][j] = min;
	}

	public static void main(String[] args) {
		int[] arr = {3,1,5,8};
		System.out.println(maxCoins(arr));

	}

}
