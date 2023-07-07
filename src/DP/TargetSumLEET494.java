package DP;

public class TargetSumLEET494 {
	
	public static int findTargetSumWays(int[] nums, int target) {
        
		int sum =0;
		for(int i=0;i<nums.length;i++) {
			sum = sum + nums[i];
		}
		
		int targetSum = 0;
		boolean flag = true;
		for(int i=0,j=sum; i<=(sum)/2;i++,j--) {
			if(j-i == target || i-j == target) {
				flag = false;
				targetSum = j;
			}
		}
		
		if(flag)
			return 0;
		
		int[][] dp = new int[nums.length+1][targetSum+1]; 
		for(int i=0;i<=targetSum;i++) {
			dp[0][i] = 0;
		}
//		for(int i=0;i<=nums.length;i++) {
//			dp[i][0] = 1;
//		}
		dp[0][0] = 1;
		for(int i = 1; i<= nums.length;i++) {
			for(int j=0; j<=targetSum; j++) {
				if(nums[i-1]<=j) {
					dp[i][j] = dp[i-1][j] + dp[i-1][j-nums[i-1]];
				}else
					dp[i][j] = dp[i-1][j];
			}
		}
		
		return dp[nums.length][targetSum];
		
    }

	public static void main(String[] args) {
		int[] nums = {1,2,1};
		System.out.println(findTargetSumWays(nums, 0));

	}

}
