package DP.Stocks;


//https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
public class BuySellStockLEET121 {
	
	public static int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int profit = 0;
        for(int i=0;i<prices.length;i++) {
        	if(prices[i]<min)
        		min = prices[i];
        	if(prices[i] - min > profit)
        		profit = prices[i] - min;
        }
        return profit;
    }

	public static void main(String[] args) {
		

	}

}
