package DP.CodeStudio;

import java.util.Arrays;

//https://www.codingninjas.com/codestudio/problems/problem-name-boolean-evaluation_1214650
public class BooleanEvaluation {
	
	public static int evaluateExp(String exp) {
		int[][][] dp = new int[exp.length()][exp.length()][2];
		for(int[][] row2 : dp)
			for(int[] row1: row2)
				Arrays.fill(row1, -1);
        return evaluateRecur(0, exp.length()-1, 1, exp, dp)%1000000007;
    }

	private static int evaluateRecur(int i, int j, int isTrue, String exp, int[][][] dp) {
		if(i>j) return 0;
		if(i==j)
			if(isTrue == 1) return exp.charAt(i) == 'T'?1:0;
			else return exp.charAt(i) == 'F'?1:0;
		
		
		if(dp[i][j][isTrue] != -1) return dp[i][j][isTrue]%1000000007;
		int count =0;
		for(int k = i+1;k<j;k=k+2) {
			int lt = evaluateRecur(i, k-1, 1, exp, dp)%1000000007;
			int lf = evaluateRecur(i, k-1, 0, exp, dp)%1000000007;
			int rt = evaluateRecur(k+1, j, 1, exp, dp)%1000000007;
			int rf = evaluateRecur(k+1, j, 0, exp, dp)%1000000007;
			
			if(exp.charAt(k) == '|') {
				if(isTrue == 1) {
					count += (lt*rt + lf*rt + lt*rf)%1000000007;
				}else {
					count += (lf*rf)%1000000007;
				}
			}else if(exp.charAt(k) == '&') {
				if(isTrue == 1) {
					count += (lt*rt)%1000000007;
				}else {
					count+= (lf*rt + lt*rf + lf * rf)%1000000007;
				}
			}else if(exp.charAt(k) == '^')
				if(isTrue == 1) {
					count += (lt*rf + lf*rt)%1000000007;
				}else {
					count += (lt*rt + lf*rf)%1000000007;
				}
		}
		
		return dp[i][j][isTrue] = count%1000000007;		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(evaluateExp("T^T^T^F|F&F^F|T^F^T"));

	}

}
