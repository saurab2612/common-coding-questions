package DP;

import java.util.Arrays;

//https://www.codingninjas.com/codestudio/problems/minimum-path-sum_985349
public class GridMinPathSumCodeStudio {
	
	public static int minSumPath(int[][] grid) {
		int[][] dp = new int[grid.length][grid[0].length];
		for(int[] row: dp) 
			Arrays.fill(row, -1);
     	return minSumPathRecur(0,0,grid, dp);
    }

	private static int minSumPathRecur(int row, int column, int[][] grid, int[][] dp) {
		if(row == grid.length-1 && column == grid[0].length-1)
			return grid[row][column];
		if(row == grid.length || column == grid[0].length)
			return 0;
		
		if(dp[row][column]!=-1) return dp[row][column];
		
		int right = minSumPathRecur(row, column + 1, grid, dp);
		int down = minSumPathRecur(row+1, column, grid, dp);
		
		if(right == 0 && down == 0)
			return dp[row][column]=grid[row][column];
		else if(right ==0 && down != 0)
			return dp[row][column]=grid[row][column] + down;
		else if(down == 0 && right != 0)
			return dp[row][column]=grid[row][column] + right;
		else
			return dp[row][column]=grid[row][column] + Math.min(right, down);
	}

	public static void main(String[] args) {
		int[][] grid = {{5,9,6},{11,5,2}};
		System.out.println(minSumPath(grid));
		System.out.println();
 
	}

}
