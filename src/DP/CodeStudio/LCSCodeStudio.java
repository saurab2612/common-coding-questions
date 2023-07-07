package DP.CodeStudio;

import java.util.Arrays;

//https://www.codingninjas.com/codestudio/problems/longest-common-subsequence_624879
public class LCSCodeStudio {
	
	public static int lcs1(String s, String t) {
		int[][] dp = new int[s.length()][t.length()];
		for(int[] row: dp)
			Arrays.fill(row, -1);
		return lcsRecur(s.length()-1,t.length()-1,s,t, dp);
    }

	private static int lcsRecur(int i1, int i2, String s, String t, int[][] dp) {
		if(i1 < 0 || i2 < 0)
			return 0;
		
		if(dp[i1][i2]!=-1) return dp[i1][i2];
		if(s.charAt(i1) == t.charAt(i2))
			return dp[i1][i2] = 1 + lcsRecur(i1-1, i2-1, s, t, dp);
		else
			return dp[i1][i2] = Math.max(lcsRecur(i1-1, i2, s, t, dp), lcsRecur(i1, i2-1, s, t, dp));
	}
	
	
	//tabulation
	public static int lcs(String s, String t) {
		int[][] dp = new int[s.length()][t.length()];
		for(int[] row: dp)
			Arrays.fill(row, -1);
		
		for(int i = 0;i<s.length();i++) {
			for(int j=0;j<t.length();j++) {
				if(i==0 || j ==0)
					if(s.charAt(i) == t.charAt(j)) {
						dp[i][j] = 1;
						continue;
					}
					else {
						dp[i][j]= 0;
						continue;
					}
				
				if(s.charAt(i) == t.charAt(j))
					dp[i][j] = 1 + dp[i-1][j-1];
				else
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
				
			}
		}
		
		return dp[s.length()-1][t.length()-1];
    }
	
	
	//print lcs
	public static void printLcs(String s, String t) {
		int[][] dp = new int[s.length()][t.length()];
		for(int[] row: dp)
			Arrays.fill(row, -1);
		
		for(int i = 0;i<s.length();i++) {
			for(int j=0;j<t.length();j++) {
				if(i==0 || j ==0)
					if(s.charAt(i) == t.charAt(j)) {
						dp[i][j] = 1;
						continue;
					}
					else {
						dp[i][j]= 0;
						continue;
					}
				
				if(s.charAt(i) == t.charAt(j))
					dp[i][j] = 1 + dp[i-1][j-1];
				else
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
				
			}
		}
		
		//return dp[s.length()-1][t.length()-1];
		int i = s.length()-1;
		int j = t.length() -1;
		String str = "";
		while(i!=-1 && j!=-1) {
			if(s.charAt(i) == t.charAt(j)) {
				str += s.charAt(i);
				i--;
				j--;
			}else if(dp[i-1][j] > dp[i][j-1]) {
				i--;
			}else
				j--;
				
		}
		
		StringBuffer sbr = new StringBuffer(str);
        // To reverse the string
        sbr.reverse();
        System.out.println(sbr);
    }
	
	

	public static void main(String[] args) {
		System.out.println(lcs("bbbab", "babbb"));
		printLcs("bbbab", "babbb");

	}

}
