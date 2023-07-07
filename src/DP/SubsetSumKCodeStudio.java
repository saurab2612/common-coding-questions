package DP;

//https://www.codingninjas.com/codestudio/problems/subset-sum-equal-to-k_1550954?leftPanelTab=0
public class SubsetSumKCodeStudio {
	
	public static boolean subsetSumToK(int n, int k, int arr[]){
		Boolean[][] dp = new Boolean[n+1][k+1];
		return subsetSumRecur(n-1,k,arr, dp);
    }

	private static boolean subsetSumRecur(int index, int k, int[] arr, Boolean[][] dp) {
		if(k==0)
			return true;
		if(k<0 || index < 0)
			return false;
		if(dp[index][k]!=null) return dp[index][k];
		boolean p = subsetSumRecur(index-1, k-arr[index], arr, dp);
		boolean nP = subsetSumRecur(index-1, k, arr,dp);
		return dp[index][k] = p || nP;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
