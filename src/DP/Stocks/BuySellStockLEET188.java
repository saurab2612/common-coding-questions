package DP.Stocks;

public class BuySellStockLEET188 {
	
	public static int maxProfit(int k, int[] prices) {
        int[] prev = new int[prices.length+1];
        
        for(int buy=k*2;buy>=0;buy--) {
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
		// TODO Auto-generated method stub

	}

}
