package DP.CodeStudio;

import java.util.Arrays;

//https://www.codingninjas.com/codestudio/problems/matrix-chain-multiplication_975344
public class MCM {
	
	public static int matrixMultiplication(int[] arr , int N) {
		int[][] dp = new int[N][N];
		for(int[] row:dp)
			Arrays.fill(row, -1);
		return mcmUtil(1,N-1, arr, dp);
	}

	private static int mcmUtil(int i, int j, int[] arr, int[][] dp) {
		 if(i == j) return 0;
		 
		 
		 if(dp[i][j]!=-1) return dp[i][j];
		 int min = 1000000000;
		 for(int k = i;k<=j-1;k++) {
			 int steps = arr[i-1] * arr[k] * arr[j] + mcmUtil(i, k, arr, dp) + mcmUtil(k+1, j, arr, dp);
			 min = Math.min(min, steps);
		 }
		 return dp[i][j] = min;
	}

	public static void main(String[] args) {
		int arr[] = {4,5,3,2};
		System.out.println(matrixMultiplication(arr, 4));

	}

}
