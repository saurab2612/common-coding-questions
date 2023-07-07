package DP.Stocks;

import java.util.Arrays;

public class BuySellStockCoolDown {
	
	public static int stockProfit(int[] prices) {
        int[][] dp = new int[2][prices.length+1];
        for(int[] row:dp)
        	Arrays.fill(row, -1);
		return maxProfitUtil(0,1,prices, dp);
    }

	private static int maxProfitUtil(int index, int buy, int[] prices, int[][] dp) {
		if(index >= prices.length)
			return 0;
		
		if(dp[buy][index]!=-1) return dp[buy][index];
		if(buy == 1) {
			return dp[buy][index] = Math.max(prices[index] * (-1) + maxProfitUtil(index+1, 0, prices, dp), maxProfitUtil(index+1, 1, prices,dp));
		}else {
			//added index +2 for cooldown period
			return dp[buy][index] = Math.max(prices[index]  + maxProfitUtil(index+2, 1, prices, dp), maxProfitUtil(index+1, 0, prices, dp));
		}
	}

	public static void main(String[] args) {
		

	}

}
