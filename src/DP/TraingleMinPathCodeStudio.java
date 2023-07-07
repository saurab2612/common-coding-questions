package DP;

import java.util.Arrays;

//https://www.codingninjas.com/codestudio/problems/triangle_1229398
public class TraingleMinPathCodeStudio {
	
	public static int minimumPathSum(int[][] triangle, int n) {
		int[][] dp = new int[n][n];
		for(int[] row:dp)
			Arrays.fill(row, -1);
        return minPathRecur(0,0,n,triangle,dp);
        
    }

	private static int minPathRecur(int row, int column, int n, int[][] triangle, int[][] dp) {
		if(row == n-1)
			return triangle[row][column];
		
		if(dp[row][column]!=-1) return dp[row][column];
		
		int ai = triangle[row][column] + minPathRecur(row+1, column, n, triangle,dp);
		int aiPlus1 = triangle[row][column] + minPathRecur(row+1, column+1, n, triangle,dp);
		return dp[row][column] = Math.min(ai, aiPlus1);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
