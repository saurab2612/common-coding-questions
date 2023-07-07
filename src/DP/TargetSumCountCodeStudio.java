package DP;

import java.util.Arrays;

//https://www.codingninjas.com/codestudio/problems/number-of-subsets_3952532?source=youtube&campaign=striver_dp_videos&utm_source=youtube&utm_medium=affiliate&utm_campaign=striver_dp_videos
public class TargetSumCountCodeStudio {
	
	public static int findWays(int num[], int tar) {
        int[][] dp = new int[num.length][tar+1];
        for(int[] row: dp)
        	Arrays.fill(row, -1);
		return findWaysRecur(num.length-1, num, tar, dp);
    }

	private static int findWaysRecur(int index, int[] num, int target, int[][] dp) {
		if(target == 0)
			return 1;
		if(index == 0)
			if(num[0] == target)
				return 1;
			else
				return 0;
		if(dp[index][target]!= -1) return dp[index][target]; 
		int np = findWaysRecur(index-1, num, target, dp);
		int p = 0;
		if(target >= num[index])
			p = findWaysRecur(index-1, num, target - num[index], dp);
		
		return dp[index][target] = p + np;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
