package DP;

import java.util.Arrays;

public class FrogJumpCondingNinja {
	
	public static int frogJumpMemoization(int n, int heights[]) {

        int dp[] = new int[n+1];
        for(int i=0;i<dp.length;i++) {
        	dp[i] = -1;
        }
        return frogJumpRecur(n,heights,dp);
     
    }

	private static int frogJumpRecur(int n, int[] heights, int[] dp) {
		if(n<=1)
			return 0;
		
		if(dp[n]==-1) {
			if(n == 2)
				return Math.abs(heights[n-1] - heights[n-2]);
			else {
				return Math.min(Math.abs(heights[n-1] - heights[n-2]) + frogJumpRecur(n-1, heights, dp)
				, Math.abs(heights[n-1] - heights[n-3]) + frogJumpRecur(n-2, heights, dp));
			}
		}else
			return dp[n];
		
	}
	
	//tabulation
	public static int frogJump(int n, int heights[]) {

        int dp[] = new int[n+1];
        for(int i=0;i<dp.length;i++) {
        	dp[i] = -1;
        }
        
        dp[0] = 0;
        dp[1] = 0;
        dp[2] = Math.abs(heights[1] - heights[0]);
        for(int i = 3;i<=n;i++) {
        	dp[i] = Math.min(Math.abs(heights[i-1] - heights[i-2]) + dp[i-1]
			, Math.abs(heights[i-1] - heights[i-3]) + dp[i-2]);
        }
        return dp[n];
    }

	public static void main(String[] args) {
		int arr[] = {10,20,30,10};
		System.out.println(frogJump(4, arr)); ;
		
	}

}
