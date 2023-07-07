package DP;

import java.util.ArrayList;
import java.util.Arrays;

//https://www.codingninjas.com/codestudio/problems/maximum-sum-of-non-adjacent-elements_843261
public class MaxNonAdjacentSum {
	// - this was is using boolean 
//	public static int maximumNonAdjacentSum(ArrayList<Integer> nums) {
//		
//		int[] ans = new int[1];
//		MaxNonAdjSumRecur(false, 0, nums, ans, 0);
//		return ans[0];
//	}
//
//	private static void MaxNonAdjSumRecur(boolean b, int i, ArrayList<Integer> nums, int[] ans, int sum) {
//		if(i == nums.size()) {
//			if(sum>ans[0])
//				ans[0] = sum;
//			return;
//		}
//		
//		if(b)
//			MaxNonAdjSumRecur(false, i + 1, nums, ans, sum);
//		else {
//			MaxNonAdjSumRecur(false, i + 1, nums, ans, sum);
//			MaxNonAdjSumRecur(true, i + 1, nums, ans, sum + nums.get(i));
//		}
//	}
	
	
	
	//without using boolean prev
	public static int maximumNonAdjacentSum(ArrayList<Integer> nums) {
		int[] dp = new int[nums.size()];
		Arrays.fill(dp, -1);
		maxNonAdjRecur(nums.size()-1, nums, dp);
		return dp[nums.size()-1];
	}

	private static int maxNonAdjRecur(int index, ArrayList<Integer> nums, int[] dp ) {
		if(index == 0) {
			if(dp[index] == -1)
				dp[index] = nums.get(index);
			return dp[index];
		}
		if(index < 0)
			return 0;
		if(dp[index]!=-1) return dp[index];
		else {
			int pick = nums.get(index) + maxNonAdjRecur(index -2, nums, dp);
			int notPick = maxNonAdjRecur(index-1, nums, dp);
			dp[index] = Math.max(pick, notPick);
		}
		return dp[index];
		
	}

	public static void main(String[] args) {
		ArrayList<Integer> nums = new ArrayList<>();
		nums.add(2);
		nums.add(1);
		nums.add(4);
		nums.add(9);
		System.out.println(maximumNonAdjacentSum(nums));

	}

}
