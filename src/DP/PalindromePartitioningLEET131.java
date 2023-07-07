package DP;

import java.util.Arrays;

public class PalindromePartitioningLEET131 {
	
	public static int minCut(String s) {
		int[] dp = new int[s.length()];
		Arrays.fill(dp, -1);
		return minCutRecur(0,s, dp) -1;
    }

	private static int minCutRecur(int i, String s, int[] dp) {
		if(i==s.length()) return 0;
		
		if(dp[i]!=-1) return dp[i];
		int min = Integer.MAX_VALUE;
		for(int j=i;j<s.length();j++) {
			if(palindrome(i,j, s)) {
				int mini = 1 + minCutRecur(j+1,s,dp);
				if(mini<min)
					min = mini;
			}
		}
		return dp[i] = min;
	}

	private static boolean palindrome(int i, int j, String s) {
		while(i<j) {
			if(s.charAt(i)!=s.charAt(j))
				return false;
			i++;
			j--;
		}
		return true;
	}

	public static void main(String[] args) {
		System.out.println(minCut("aab"));
	}

}
