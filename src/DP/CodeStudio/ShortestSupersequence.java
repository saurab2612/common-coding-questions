package DP.CodeStudio;

import java.util.Arrays;

//https://www.codingninjas.com/codestudio/problems/shortest-supersequence_4244493
public class ShortestSupersequence {
	
	public static int shortestSupersequence(String a, String b) {
        int[][] dp = new int[a.length()][b.length()];
        for(int[] row : dp)
        	Arrays.fill(row, -1);
 		int k = shortSuperRecur(a.length()-1, b.length()-1, a, b, dp);
 		return k;
    }

	private static int shortSuperRecur(int i, int j, String a, String b, int[][] dp) {
		if(i<0)
			return j + 1;
		if(j<0)
			return i+1;
		
		if(dp[i][j]!=-1) return dp[i][j];
		if(a.charAt(i) == b.charAt(j))
			return dp[i][j] = 1 + shortSuperRecur(i-1, j-1, a, b, dp);
		else
			return dp[i][j] = 1 + Math.min(shortSuperRecur(i-1, j, a, b, dp), shortSuperRecur(i, j-1, a, b, dp));
	}

	public static void main(String[] args) {
		System.out.println(shortestSupersequence("brute", "groot"));

	}

}
