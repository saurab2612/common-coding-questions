package DP.CodeStudio;

import java.util.Arrays;

public class CutAStickLEET1547 {
	
	public static int minCost1(int n, int[] cuts) {
		int[][] dp = new int[cuts.length+1][cuts.length+1];
		for(int[] row:dp)
			Arrays.fill(row, -1);
		
		
		int[] cutsNew = new int[cuts.length+2];
		cutsNew[0] = 0;
		cutsNew[cutsNew.length-1] = n; 
		for(int i=1;i<=cuts.length;i++)
			cutsNew[i] = cuts[i-1];
		
		Arrays.sort(cutsNew);
        minCostRecur(1,cuts.length, cutsNew, dp);
        return dp[1][cuts.length];
    }

	private static int minCostRecur(int i, int j, int[] cutsNew, int[][] dp) {
		if(i>j)
			return 0;
		
		if(dp[i][j] != -1) return dp[i][j];
		int min = 1000000000;
		for(int k=i;k<=j;k++) {
			int cost = cutsNew[j+1] - cutsNew[i-1] + minCostRecur(i, k-1, cutsNew, dp) + minCostRecur(k+1, j, cutsNew, dp);
			if(cost<min)
				min = cost;
		}
		return dp[i][j] = min;
	}
	
	public static int minCost(int n, int[] cuts) {
		int[][] dp = new int[cuts.length+2][cuts.length+2];
		
		
		int[] cutsNew = new int[cuts.length+2];
		cutsNew[0] = 0;
		cutsNew[cutsNew.length-1] = n; 
		for(int i=1;i<=cuts.length;i++)
			cutsNew[i] = cuts[i-1];
		
		Arrays.sort(cutsNew);
        
		for(int i = cuts.length;i>=1;i--) {
			for(int j = 1;j<=cuts.length;j++) {
				int min = 1000000000;
				for(int k=i;k<=j;k++) {
					if(i>j)continue;
					int cost = cutsNew[j+1] - cutsNew[i-1] + dp[i][k-1] + dp[k+1][j];
					if(cost<min)
						min = cost;
				}
				dp[i][j] = min;
			}
		}
		
		return dp[1][cuts.length];
    }

	public static void main(String[] args) {
		int[] arr = {1,3,4,5};
		System.out.println(minCost(7, arr));

	}

}
