package DP.CodeStudio;

import java.util.Arrays;

//https://www.codingninjas.com/codestudio/problems/unbounded-knapsack_1215029
public class UnboundedKnapsack {
	
	public static int unboundedKnapsack(int n, int w, int[] profit, int[] weight) {
		int[][] dp = new int[n][w+1];
		for(int[] row:dp)
			Arrays.fill(row, -1);
		return ubKnapRecur(n-1,w,profit,weight, dp);
    }

	private static int ubKnapRecur(int index, int target, int[] profit, int[] weight, int[][] dp) {
		if(target ==0)
			return 0;
		if(index ==0)
			if(target >= weight[0])
				return profit[0] * (target/weight[0]);
			else
				return 0;
		if(dp[index][target]!=-1) return dp[index][target];
		int np = ubKnapRecur(index-1, target, profit, weight, dp);
		int p = 0;
		if(weight[index] <= target)
			p = profit[index] + ubKnapRecur(index, target-weight[index], profit, weight, dp);
		
		return dp[index][target] = Math.max(np, p);
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] profit = {3,4,5,1};
		int[] weight = {4,1,2,3};
		
		System.out.println(unboundedKnapsack(4, 7, profit, weight));
	}

}
