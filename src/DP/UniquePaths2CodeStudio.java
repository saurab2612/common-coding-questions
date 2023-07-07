package DP;

import java.util.ArrayList;
import java.util.Arrays;

//https://www.codingninjas.com/codestudio/problems/maze-obstacles_977241
public class UniquePaths2CodeStudio {
	
	static int mazeObstacles(int n, int m, ArrayList<ArrayList<Integer>> mat) {
		int[][] dp = new int[n][m];
		for (int[] row: dp)
            Arrays.fill(row, -1);
        mazeObstaclesRecur(0,0,mat,n,m, dp);
        return dp[0][0];
    }

	private static int mazeObstaclesRecur(int row, int column, ArrayList<ArrayList<Integer>> mat, int n, int m, int[][] dp) {
		if(row == n-1 && column == m-1)
			return 1;
		if(row == n)
			return 0;
		if(column == m)
			return 0;
		
		if(dp[row][column] != -1) 
			return dp[row][column];
		
		if(mat.get(row).get(column) != -1) {
			int right = mazeObstaclesRecur(row, column +1, mat, n, m, dp);
			int down = mazeObstaclesRecur(row+1, column, mat, n, m, dp);
			return dp[row][column]=(right+down)%(1000000007);
		}else {
			return dp[row][column]=0;
		}
	}

	public static void main(String[] args) {
		ArrayList<ArrayList<Integer>> mat = new ArrayList<ArrayList<Integer>>();
		// TODO Auto-generated method stub
		ArrayList<Integer> num1 = new ArrayList<>();
		num1.add(0);
		num1.add(0);
		num1.add(0);
		mat.add(num1);
		ArrayList<Integer> num2 = new ArrayList<>();
		num2.add(0);
		num2.add(-1);
		num2.add(0);
		mat.add(num2);
		ArrayList<Integer> num3 = new ArrayList<>();
		num3.add(0);
		num3.add(0);
		num3.add(0);
		mat.add(num3);
		mazeObstacles(3, 3, mat);

	}

}
