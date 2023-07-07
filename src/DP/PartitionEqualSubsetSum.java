package DP;

//https://www.codingninjas.com/codestudio/problems/partition-equal-subset-sum_892980?source=youtube&campaign=striver_dp_videos&utm_source=youtube&utm_medium=affiliate&utm_campaign=striver_dp_videos
public class PartitionEqualSubsetSum {
	
	public static boolean canPartition(int[] arr, int n) {
		int sum =0;
		for(int i=0;i<arr.length;i++) {
			sum += arr[i];
		}
		
		if(sum%2 != 0) return false;
		int target = sum/2;
		Boolean[][] dp = new Boolean[n+1][target+1];
		return canPartitionRecur(n-1, arr, target, dp);
//		for(int i=0;i<n;i++) {
//			dp[i][0] = true;
//		}
//		dp[0][arr[0]] = true;
//		for(int i=1;i<n;i++) {
//			for(int j=;j<=target;j++) {
//				boolean np = dp[i-1][j];
//				boolean p = false;
//				if(j>=arr[i])
//					p = dp[i-1][j-arr[i]];
//				dp[i][j] = p || np;
//			}
//		}
//		return dp[n-1][target];
	}

	private static boolean canPartitionRecur(int index, int[] arr, int target, Boolean[][] dp) {
		if(target == 0)
			return true;
		if(index == 0)
			return arr[0] == target;
		if(dp[index][target]!=null) return dp[index][target];
		boolean np = canPartitionRecur(index-1, arr, target, dp);
		boolean p = false;
		if(target>=arr[index])
			p = canPartitionRecur(index-1, arr, target-arr[index], dp);
		
		return dp[index][target] = p || np;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
