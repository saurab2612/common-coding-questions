package DP.Stocks;

import java.util.Arrays;

//https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
public class BuySellStock2LEET122 {
	
	public static int maxProfit(int[] prices) {
        int[][] dp = new int[2][prices.length+1];
        for(int[] row:dp)
        	Arrays.fill(row, -1);
		return maxProfitUtil(0,1,prices, dp);
    }

	private static int maxProfitUtil(int index, int buy, int[] prices, int[][] dp) {
		if(index == prices.length)
			return 0;
		
		if(dp[buy][index]!=-1) return dp[buy][index];
		if(buy == 1) {
			return dp[buy][index] = Math.max(prices[index] * (-1) + maxProfitUtil(index+1, 0, prices, dp), maxProfitUtil(index+1, 1, prices,dp));
		}else {
			return dp[buy][index] = Math.max(prices[index]  + maxProfitUtil(index+1, 1, prices, dp), maxProfitUtil(index+1, 0, prices, dp));
		}
	}

	public static void main(String[] args) {
		int arr[] = {7,1,5,3,6,4};
		System.out.println(maxProfit(arr));

	}

}
