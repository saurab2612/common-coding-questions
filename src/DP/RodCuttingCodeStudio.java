package DP;

import java.util.Arrays;

//https://www.codingninjas.com/codestudio/problems/rod-cutting-problem_800284
public class RodCuttingCodeStudio {
	
	public static int cutRod(int price[], int n) {
		int[][] dp = new int[n][n+1];
		for(int[] row: dp)
			Arrays.fill(row, -1);
		return cutRodRecur(n-1, price, n, dp);
	}

	private static int cutRodRecur(int index, int[] price, int target, int[][] dp) {
		if(target == 0)
			return 0;
		if(index == 0)
			if(1 <= target) return target * price[0];
			else return 0;
		
		
		if(dp[index][target] != -1) return dp[index][target];
		int np = cutRodRecur(index-1, price, target, dp);
		int p = 0;
		if(target>=index+1)
			p = price[index] + cutRodRecur(index, price, target - index -1, dp);
		
		return dp[index][target] =  Math.max(np, p);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
