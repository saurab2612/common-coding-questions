package DP;

import java.util.Arrays;

//https://www.codingninjas.com/codestudio/problems/minimum-elements_3843091?leftPanelTab=0
public class MinElementsCodeStudio {
	
	public static int minimumElements1(int num[], int x) {
		int[][] dp = new int[num.length][x+1];
		for(int[] row: dp)
			Arrays.fill(row, -1);
		x = minElementsRecur(num.length-1, x, num, dp);
		return x == 1000000000? -1 : x;
    }

	private static int minElementsRecur(int index, int target, int[] num, int[][] dp) {
		if(target == 0)
			return 0;
		if(index == -1)
			return 1000000000;
		
		if(dp[index][target] != -1) return dp[index][target];
		int np = minElementsRecur(index-1, target, num, dp);
		int p = 1000000000;
		if(num[index] <= target)
			p = 1 + minElementsRecur(index, target - num[index], num, dp);
		
		return dp[index][target] = Math.min(np, p);
						
	}
	//tabulation
	public static int minimumElements(int num[], int x) {
		int[][] dp = new int[num.length+1][x+1];
		for(int[] row: dp)
			Arrays.fill(row, -1);
		int n = num.length;
		for(int i=0; i<=n;i++) {
			dp[i][0] = 0;
		}
		for(int i =0; i<=x;i++) {
			dp[0][i] = 1000000000;
		}
		
		for(int index = 1;index<=n;index++) {
			for(int target = 1;target<=x;target++) {
				int np = dp[index-1][target];
				int p = 1000000000;
				if(num[index-1] <= target)
					p = 1 + dp[index][target - num[index-1]];
				dp[index][target] = Math.min(np, p);
			}
		}
		
		return dp[num.length][x]== 1000000000? -1 : dp[num.length][x];
    }
	
	
	

	public static void main(String[] args) {
		int[] arr = {1,2,3};
		System.out.println(minimumElements(arr, 7));

	}

}
