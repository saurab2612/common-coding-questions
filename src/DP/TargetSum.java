package DP;

public class TargetSum {
	
	public static boolean ifTargetSum(int[] arr, int k) {
		
		boolean[][] dp = new boolean[arr.length+1][k+1];
		for(int i=0;i<=k;i++) {
			dp[0][i] = false;
		}
		for(int i=0;i<=arr.length;i++) {
			dp[i][0] = true;
		}
		
		for(int i=1;i<=arr.length;i++) {
			for(int j=1;j<=k;j++) {
				if(arr[i-1]<= j) {
					dp[i][j]  = dp[i-1][j] || dp[i-1][j-arr[i-1]];
				}else {
					dp[i][j] = dp[i-1][j];
				}
			}
		}
		
		return dp[arr.length][k];
	}
	
	

	public static void main(String[] args) {
		
		int[] arr = {4,2,7,1,3};
		System.out.println(ifTargetSum(arr, 10));

	}

}
