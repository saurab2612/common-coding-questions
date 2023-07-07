package DP.CodeStudio;

import java.util.Arrays;

public class LISLEET300 {
	
	public static int lengthOfLIS1(int[] nums) {
		int[][] dp = new int[nums.length][nums.length+1];
		for(int[] row: dp)
			Arrays.fill(row, -1);
        lisUtil(0,-1, nums, dp);
        return dp[0][0];
    }

	private static int lisUtil(int index, int last, int[] nums, int[][] dp) {
		if(index == nums.length)
			return 0;
		
		if(dp[index][last+1] != -1) return dp[index][last+1];
		int np = lisUtil(index+1, last, nums, dp);
		int p = 0;
		if(last == -1 || nums[index] > nums[last])
			p = 1 + lisUtil(index+1, index+1, nums, dp);
		
		return dp[index][last+1] = Math.max(np, p);
	}
	
	public static int lengthOfLIS2(int[] nums) {
		int[][] dp = new int[nums.length+1][nums.length+1];
		for(int index=nums.length-1;index>=0;index--) {
			for(int last=nums.length;last>=0;last--) {
				int np = dp[index+1][last];
				int p = 0;
				if(nums[index] > (last==0?Integer.MIN_VALUE:nums[last-1]))
					p = 1 + dp[index+1][index+1];
				
				dp[index][last] = Math.max(np, p);
			}
		}
		return dp[0][0];
        
    }
	
	public static int lengthOfLIS(int[] nums) {
		int[] prev = new int[nums.length+1];
		for(int index=nums.length-1;index>=0;index--) {
			int[] cur = new int[nums.length+1];
			for(int last=nums.length;last>=0;last--) {
				int np = prev[last];
				int p = 0;
				if(nums[index] > (last==0?Integer.MIN_VALUE:nums[last-1]))
					p = 1 + prev[index+1]; 
				
				cur[last] = Math.max(np, p);
			}
			prev = cur;
		}
		return prev[0];
        
    }

	public static void main(String[] args) {
		int arr[] = {0,1,0,3,2,3};
 		System.out.println(lengthOfLIS2(arr));
	}

}
