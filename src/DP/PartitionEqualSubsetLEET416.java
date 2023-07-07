package DP;

public class PartitionEqualSubsetLEET416 {
	
	public static boolean canPartition(int[] nums) {
        int sum = 0;
        for(int i=0;i<nums.length;i++) {
        	sum = sum + nums[i];
        }
        
        if(sum%2!=0)
        	return false;
        
        int row = nums.length +1;
        int column = (sum/2)+1 ;
        boolean dp[][] = new boolean[row][column];
        
        for(int i=0;i<column;i++) {
        	dp[0][i] = false;
        }
        
        dp[0][0] = true;
        
        for(int i=1;i<row;i++) {
        	for(int j=0;j<column;j++) {
        		if(nums[i-1]<=j) {
        			dp[i][j] = dp[i-1][j] || dp[i-1][j-nums[i-1]];
        		}else
        			dp[i][j] = dp[i-1][j];
        	}
        }
        
        return dp[row-1][column-1];
        			
    }

	public static void main(String[] args) {
		int nums[] = {1,2,3,5};
		System.out.println(canPartition(nums));

	}

}
