package DP;

public class CoinChangeCombination {
	
	public static int coinChangeComb(int[] coins, int k) {
		int[] dp = new int[k+1];
		dp[0]=1;
		for(int i=0;i<coins.length;i++) { // running for each coin entire loop producing combination
			for(int j=1;j<=k;j++) {
				if(coins[i]<=j) {
					dp[j] = dp[j]+dp[j-coins[i]];
				}else
					dp[j] = dp[j];
			}
		}
		return dp[k];
	}
	
	
	public static int coinChangePerm(int[] coins, int k) {
		int[] dp = new int[k+1];
		dp[0] =1;
		for(int i=1;i<=k;i++) { //for  each index we will run multiple times all the coins
			int sum = 0;
			for(int j=0;j<coins.length;j++) {
				if(coins[j]<=i) {
					sum = sum + dp[i-coins[j]];
				}
			}
			dp[i] = sum;
		}
		
		return dp[k];
		
	}

	public static void main(String[] args) {
		int[] arr = {2,3,5};
		System.out.println(coinChangeComb(arr, 7));
		System.out.println(coinChangePerm(arr, 7));

	}

}
