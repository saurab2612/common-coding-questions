package DP.CodeStudio;

import java.util.Arrays;

//https://www.codingninjas.com/codestudio/problems/longest-common-substring_1235207
public class LongestCommonSubstring {
	
	public static int lcs(String str1, String str2) {
		int[][] dp = new int[str1.length()][str2.length()];
		for(int[] row : dp)
			Arrays.fill(row, -1);
		int[] max = new int[1];
		max[0] = 0;
		lcsRecur(str1.length()-1, str2.length()-1, str1, str2, max, dp);
		return max[0];
	}

	private static int lcsRecur(int i, int j, String str1, String str2, int[] max, int[][] dp) {
		if(i <0 || j < 0)
			return 0;
			
		if(dp[i][j]!=-1) return dp[i][j];
		if(str1.charAt(i) == str2.charAt(j)) {
			int k = 1 + lcsRecur(i-1, j-1, str1, str2, max, dp);
			int left =lcsRecur(i-1, j, str1, str2, max, dp);  // this will also be added unlike substring.
			int right = lcsRecur(i, j-1, str1, str2, max, dp);
			int maxi = Math.max(left, Math.max(k, right));
			if(maxi>max[0])
				max[0] = maxi;
			return dp[i][j] = k;
		}else {
			int left =lcsRecur(i-1, j, str1, str2, max, dp);
			int right = lcsRecur(i, j-1, str1, str2, max, dp);
			return dp[i][j] = 0;
		}
		
	}

	public static void main(String[] args) {
		System.out.println(lcs("bc", "cbccabcc"));

	}

}
