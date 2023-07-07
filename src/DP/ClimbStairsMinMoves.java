package DP;

public class ClimbStairsMinMoves {
	
	public static int minMove(int n, int[] var) {
		int[] dp = new int[n+1];
		dp[n] = 0;
		//int result = 0;
		for(int i=n-1;i>=0;i--) {
			int result = 0;
			for(int j=1;j<=var[i];j++) {
				if(j==1)
					result=dp[i+j];
				if(i+j<=n)
				result = 1 + Math.min(result, dp[i+j]);
			}
			dp[i] = result ;
		}
		
		return dp[0];
	}

	public static void main(String[] args) {
		int n=6;
		int[] var = {4,2,0,2,2,3};
		System.out.println(minMove(n, var));
	}

}
