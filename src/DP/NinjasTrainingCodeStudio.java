package DP;

import java.util.Arrays;

//https://www.codingninjas.com/codestudio/problems/ninja-s-training_3621003
public class NinjasTrainingCodeStudio {
	
	public static int ninjaTraining(int n, int points[][]) {
		int[][] dp = new int[points.length][4];
		for (int[] row: dp)
            Arrays.fill(row, -1);
		return ninjaTrainingRecur(points.length-1, 3, points, dp);
    }

	private static int ninjaTrainingRecur(int index, int last, int[][] points, int[][] dp) {
		if(index == 0) {
			int max = 0;
			for(int i=0;i<=2;i++) {
				if(i!=last)
					max = Math.max(max, points[0][i]);
			}
			return max;
		}
		if(dp[index][last] == -1) {
			int max = 0;
			for(int i=0;i<=2;i++) {
				if(i!=last) {
					int score = points[index][i] + ninjaTrainingRecur(index-1, i, points, dp);
					max = Math.max(max, score);
				}
			}
			return dp[index][last] = max;
		}else
			return dp[index][last];
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
