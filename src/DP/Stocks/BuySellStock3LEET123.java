package DP.Stocks;

import java.util.Arrays;

public class BuySellStock3LEET123 {
	
	public static int maxProfit1(int[] prices) {
        int[][] dp = new int[5][prices.length+1];
        for(int[] row:dp)
        	Arrays.fill(row, -1);
		return maxProfitUtil(0,0,prices, dp);
    }

	private static int maxProfitUtil(int index, int buy, int[] prices, int[][] dp) {
		if(index == prices.length || buy == 4)
			return 0;
		
		if(dp[buy][index]!=-1) return dp[buy][index];
		if(buy%2 == 0) {
			return dp[buy][index] = Math.max(prices[index] * (-1) + maxProfitUtil(index+1, buy+1, prices, dp), maxProfitUtil(index+1, buy, prices,dp));
		}else {
			return dp[buy][index] = Math.max(prices[index]  + maxProfitUtil(index+1, buy+1, prices, dp), maxProfitUtil(index+1, buy, prices, dp));
		}
	}
	
	public static int maxProfit(int[] prices) {
        int[] prev = new int[prices.length+1];
        for(int i=0;i<=4;i++) {
        	prev[prices.length] = 0;
        }
        
        for(int buy=3;buy>=0;buy--) {
        	int[] cur = new int[prices.length+1];
        	for(int index= prices.length-1;index>=0;index--) {
        		if(buy%2 == 0) {
        			cur[index] = Math.max(prices[index] * (-1) + prev[index+1], cur[index+1]);
        		}else {
        			cur[index] = Math.max(prices[index]  + prev[index+1], cur[index+1]);
        		}
        	}
        	prev = cur;
        }
        
        return prev[0];
    }

	public static void main(String[] args) {
	 int arr[] = {2,1,4,5,2,9,7};
	 System.out.println(maxProfit(arr));

	}

}
