package DP;

import java.util.Arrays;

//https://leetcode.com/problems/wildcard-matching/
public class PatternMatchingLEET44 {
	
	public static boolean isMatch(String s, String p) {
		Boolean[][] dp = new Boolean[p.length()+1][s.length()+1]; 
        return isMatchRecur(p.length(),s.length(),p,s, dp);
    }

	private static boolean isMatchRecur(int i, int j, String p, String s, Boolean[][] dp) {
		if(i==0 && j==0)
			return true;
		if(i==0)
			return false;
		if(j==0)
			if(p.charAt(i-1)=='*')
				return isMatchRecur(i-1, j, p, s, dp);
			else
				return false;
		
		if(dp[i][j]!=null) return dp[i][j];
		if(p.charAt(i-1)=='?' || (p.charAt(i-1) == s.charAt(j-1)))
			return dp[i][j] = isMatchRecur(i-1, j-1, p, s, dp);
		else if(p.charAt(i-1) == '*')
			return dp[i][j] = isMatchRecur(i-1, j-1, p, s, dp) || isMatchRecur(i, j-1, p, s, dp) || isMatchRecur(i-1, j, p, s, dp);
		else
			return dp[i][j]= false;
		
	}

	public static void main(String[] args) {
		
		System.out.println(isMatch("abcabczzzde", "*abc???de*"));

	}

}
