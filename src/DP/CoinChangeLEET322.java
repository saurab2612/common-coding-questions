package DP;

public class CoinChangeLEET322 {
	
	public static int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        dp[0] = 0;
        for(int i=1;i<=amount;i++) {
        	boolean flag = false;
        	int min = Integer.MAX_VALUE;
        	for(int j=0;j<coins.length;j++) {
        		if(coins[j]<=i) {
        			if(dp[i-coins[j]]!=(-1)) {
        				flag = true;
        				min = Math.min(min, dp[i-coins[j]]);
        			}
        		}
        	}
        	if(flag)
        		dp[i] = 1 + min;
        	else
        		dp[i] = -1;
        	
        }
        return dp[amount];
    }

	public static void main(String[] args) {

		int[] arr = {1,2,5};
		int[] arr2 = {2};
		System.out.println(coinChange(arr, 11));
		
		
		System.out.println(coinChange(arr2, 3));
	}

}
