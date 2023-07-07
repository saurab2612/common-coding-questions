package DP.CodeStudio;

import java.util.Arrays;

//https://www.codingninjas.com/codestudio/problems/subsequence-counting_3755256?
public class SubsequencesCounting {
	
	public static int subsequenceCounting(String t, String s, int lt, int ls) {
		int[][] dp = new int[lt +1][ls+1];
		for(int[] row : dp)
			Arrays.fill(row, -1);
		return countRecur(lt, ls, t,s, dp);
    }

	private static int countRecur(int i, int j, String t, String s, int[][] dp) {
		if(j==0)
			return 1;
		if(i==0)
			return 0;
		
		if(dp[i][j]!=-1) return dp[i][j];
		if(t.charAt(i-1) == s.charAt(j-1))
			return dp[i][j] = countRecur(i-1, j-1, t, s, dp) + countRecur(i-1, j, t, s, dp);
		else
			return dp[i][j] = countRecur(i-1, j, t, s, dp);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
