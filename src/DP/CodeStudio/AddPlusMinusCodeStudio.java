package DP.CodeStudio;

import java.util.Arrays;

//https://www.codingninjas.com/codestudio/problems/target-sum_4127362
public class AddPlusMinusCodeStudio {
	
	public static int targetSum(int n, int target, int[] arr) {
		int sum = 0;
		for(int i=0;i<n;i++) {
			sum += arr[i];
		}
		             
		int x = (target + sum)/2;
		int[][] dp = new int[n][x+1];
		for(int[] row: dp)
			Arrays.fill(row, -1);
		
		return targetSumRecur(n-1, x, arr, dp);
    }

	private static int targetSumRecur(int index, int target, int[] arr, int[][] dp) {
		if(target == 0)
			return 1;
		if(index == 0)
			if(arr[0] == target)
				return 1;
			else 
				return 0;
		if(dp[index][target]!=-1) return dp[index][target];
		int np = targetSumRecur(index-1, target, arr, dp);
		int p = 0;
		if(arr[index]<=target)
			p = targetSumRecur(index-1, target-arr[index], arr, dp);
		
		return dp[index][target] = p + np;
		
	}

	public static void main(String[] args) {
		int[] arr = {24,36,1,3,29,0, 38, 17, 35, 31, 42, 30, 44, 35, 22};
		System.out.println(targetSum(15, 21, arr));

	}

}
