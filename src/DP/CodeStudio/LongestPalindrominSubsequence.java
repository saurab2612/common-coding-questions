package DP.CodeStudio;

import java.util.Arrays;

//https://www.codingninjas.com/codestudio/problems/longest-palindromic-subsequence_842787
public class LongestPalindrominSubsequence {
	
	public static int longestPalindromeSubsequence(String s) {
		StringBuffer sbr = new StringBuffer(s);
		sbr.reverse();
		String s2 = sbr.toString();
		
		int[][] dp = new int[s.length()][s.length()];
		for(int[] row: dp)
			Arrays.fill(row, -1);
		lcsRecur(s.length()-1, s.length()-1, s, s2, dp);
		return dp[s.length()-1][s.length()-1];
	}

	private static int lcsRecur(int i, int j, String s, String s2, int[][] dp) {
		if(i < 0 || j < 0)
			return 0;
		
		if(dp[i][j]!=-1) return dp[i][j];
		if(s.charAt(i) == s2.charAt(j))
			return dp[i][j] = 1 + lcsRecur(i-1, j-1, s, s2, dp);
		else
			return dp[i][j] = Math.max(lcsRecur(i, j-1, s, s2, dp), lcsRecur(i-1, j, s, s2, dp));
	}

	public static void main(String[] args) {
		System.out.println(longestPalindromeSubsequence("bbbab"));

	}

}
