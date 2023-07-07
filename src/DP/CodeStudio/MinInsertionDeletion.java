package DP.CodeStudio;

import java.util.Arrays;

//https://www.codingninjas.com/codestudio/problems/can-you-make_4244510
public class MinInsertionDeletion {
	
	public static int canYouMake(String str, String ptr) {
		int[][] dp = new int[str.length()][ptr.length()];
		for(int[] row: dp)
			Arrays.fill(row, -1);
		int lcs  = lcsRecur(str.length()-1, ptr.length()-1, str, ptr, dp);
		if(str.length() > ptr.length()) {
			int d  = str.length() - ptr.length();
			return (str.length() - d - lcs)*2 + d; 
		}else {
			int d = ptr.length() - str.length();
			return (str.length() - lcs)*2 + d;
		}
    }

	private static int lcsRecur(int i, int j, String str, String ptr, int[][] dp) {
		if(i<0 || j<0)
			return 0;
		
		if(dp[i][j]!=-1) return dp[i][j];
		if(str.charAt(i) == ptr.charAt(j))
			return dp[i][j] = 1 + lcsRecur(i-1, j-1, str, ptr, dp);
		else
			return dp[i][j] = Math.max(lcsRecur(i-1, j, str, ptr, dp), lcsRecur(i, j-1, str, ptr, dp));
	}

	public static void main(String[] args) {
		System.err.println(canYouMake("abcd", "anc"));

	}

}
