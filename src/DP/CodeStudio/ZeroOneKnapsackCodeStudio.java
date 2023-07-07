package DP.CodeStudio;

import java.util.Arrays;

//https://www.codingninjas.com/codestudio/problems/0-1-knapsack_920542?source=youtube&campaign=striver_dp_videos&utm_source=youtube&utm_medium=affiliate&utm_campaign=striver_dp_videos
public class ZeroOneKnapsackCodeStudio {
	
	static int knapsack(int[] weight, int[] value, int n, int maxWeight) {
		
		int[][] dp = new int[n][maxWeight + 1];
		for(int[] row: dp)
			Arrays.fill(row, -1);
        return knapsackRecur(n-1, weight, value, maxWeight, dp);

    }
//define : max cprofit that can be generated using 0-index and maxweight
	private static int knapsackRecur(int index, int[] weight, int[] value, int maxWeight, int[][] dp) {
		if(maxWeight == 0)
			return 0;
		if(index == 0)
			if(weight[0] <= maxWeight)
				return value[0];
			else
				return 0;
		
		if(dp[index][maxWeight]!=-1) return dp[index][maxWeight];
		int np = knapsackRecur(index-1, weight, value, maxWeight, dp);
		int p = 0;
		if(weight[index]<=maxWeight)
			p = value[index] + knapsackRecur(index-1, weight, value, maxWeight-weight[index], dp);
		
		return dp[index][maxWeight] = Math.max(np, p);
	}

	public static void main(String[] args) {
		

	}

}
