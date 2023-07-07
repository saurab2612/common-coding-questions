package DP.CodeStudio;

import java.util.Arrays;

//https://www.codingninjas.com/codestudio/problems/ways-to-make-coin-change_630471
public class Coinchange2CodeStudio {
	
	public static long countWaysToMakeChange(int denominations[], int value){
		
		long[][] dp = new long[denominations.length][value+1];
		for(long[] row: dp)
			Arrays.fill(row, -1);
		return countWaysRecur(denominations.length-1, value, denominations, dp);
	}

	private static long countWaysRecur(int index, int target, int[] arr, long[][] dp) {
		if(target == 0)
			return 1;
		if(index == 0)
			if(target%arr[0] == 0)
				return 1;
			else
				return 0;
		
		if(dp[index][target] != -1) return dp[index][target];
		long np = countWaysRecur(index-1, target, arr, dp);
		long p =0;
		if(arr[index]<=target)
			p = countWaysRecur(index, target-arr[index], arr, dp);
		
		return dp[index][target] = p + np;
						
	}

	public static void main(String[] args) {
		int[] arr = {1,2,3};
		System.out.println(countWaysToMakeChange(arr, 4));

	}

}
