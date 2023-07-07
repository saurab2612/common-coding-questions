package DP;

import java.util.Arrays;

//https://leetcode.com/problems/edit-distance/
public class EditDistanceLEET72 {
	
	public static int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length()][word2.length()];
        for(int[] row: dp)
        	Arrays.fill(row, -1);
		return minDisRecur(word1.length()-1, word2.length()-1, word1, word2, dp);
    }

	private static int minDisRecur(int i, int j, String word1, String word2, int[][] dp) {
		if(i<0)
			return j+1;
		if(j<0)
			return i+1;
		
		
		if(dp[i][j]!=-1) return dp[i][j];
		if(word1.charAt(i) == word2.charAt(j))
			return dp[i][j] = minDisRecur(i-1,  j-1, word1, word2, dp);
		else
			return dp[i][j] = 1 + Math.min(minDisRecur(i-1, j, word1, word2, dp), Math.min(minDisRecur(i-1, j-1, word1, word2, dp), minDisRecur(i, j-1, word1, word2, dp)));
		
		
	}

	public static void main(String[] args) {
		System.out.println(minDistance("plasma", "altruism"));

	}

}
