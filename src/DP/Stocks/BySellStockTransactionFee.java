package DP.Stocks;

import java.util.Arrays;

public class BySellStockTransactionFee {
	
	public static int maximumProfit(int n, int fee, int[] prices) {
        int[][] dp = new int[2][prices.length+1];
        for(int[] row:dp)
        	Arrays.fill(row, -1);
		return maxProfitUtil(0,1,prices, dp, fee);
    }

	private static int maxProfitUtil(int index, int buy, int[] prices, int[][] dp, int fee) {
		if(index == prices.length)
			return 0;
		
		if(dp[buy][index]!=-1) return dp[buy][index];
		if(buy == 1) {
			return dp[buy][index] = Math.max(prices[index] * (-1) + maxProfitUtil(index+1, 0, prices, dp, fee), maxProfitUtil(index+1, 1, prices,dp, fee));
		}else {
			return dp[buy][index] = Math.max(prices[index]  + maxProfitUtil(index+1, 1, prices, dp, fee) - fee, maxProfitUtil(index+1, 0, prices, dp, fee));
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
