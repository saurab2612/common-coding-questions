package DP;

import java.util.Arrays;

//https://www.codingninjas.com/codestudio/problems/maximum-path-sum-in-the-matrix_797998?source=youtube&campaign=striver_dp_videos&utm_source=youtube&utm_medium=affiliate&utm_campaign=striver_dp_videos
public class MaxPathSumMatrixCodeStudio {
	
	public static int getMaxPathSum(int[][] matrix) {
		int max = Integer.MIN_VALUE;
		int[][] dp = new int[matrix.length][matrix[0].length];
			for(int[] row: dp)
				Arrays.fill(row, -1);
		for(int i=0;i<matrix[0].length;i++) {
			max = Math.max(max, getMaxRecur(0, i, matrix, dp));
		}
		return max;
	}

	private static int getMaxRecur(int row, int column, int[][] matrix, int[][] dp) {
		if(column<0)
			return Integer.MIN_VALUE;
		if(column == matrix[0].length)
			return Integer.MIN_VALUE;
		if(row == matrix.length -1)
			return matrix[row][column];
		
		if(dp[row][column] != -1) return dp[row][column];
		int d = getMaxRecur(row +1, column, matrix, dp);
		int dgL = getMaxRecur(row +1, column -1, matrix, dp);
		int dgR = getMaxRecur(row +1, column +1, matrix, dp);
		
		return dp[row][column] = matrix[row][column] + Math.max(dgL, Math.max(d, dgR));
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
