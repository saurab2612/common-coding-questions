package DP;

public class MinPathSumLEET64 {
	
	public static int minPathSum(int[][] grid) {
		int row = grid.length;
		int column = grid[0].length;
		
		if(row==0 && column==0)
			return 0;
		
        int[][] dp = new int[row][column];
        dp[row-1][column-1] = grid[row-1][column-1];
        
        for(int i = column-2;i>=0;i--) {
        	dp[row-1][i] = dp[row-1][i+1] + grid[row-1][i];
        }
        
        for(int i=row-2;i>=0;i--) {
        	dp[i][column-1] = dp[i+1][column-1] + grid[i][column-1];
        }
        
        for(int i=column-2;i>=0;i--) {
        	for(int j=row-2;j>=0;j--) {
        		dp[j][i] = grid[j][i] + Math.min(dp[j+1][i], dp[j][i+1]);
        	}
        }
        
        
        return dp[0][0];
    }

	public static void main(String[] args) {
		int[][] arr = {{1,2,3},{4,5,6}};
		System.out.println(minPathSum(arr));
 
	}

}
