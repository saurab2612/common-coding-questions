package DP;


//https://www.codingninjas.com/codestudio/problems/partition-a-set-into-two-subsets-such-that-the-difference-of-subset-sums-is-minimum_842494?source=youtube&campaign=striver_dp_videos&utm_source=youtube&utm_medium=affiliate&utm_campaign=striver_dp_videos
public class MinDiffPartition {
	
	public static int minSubsetSumDifference(int[] arr, int n) {
		int sum = 0;
		for(int i=0;i<n;i++) {
			sum += arr[i];
		}
		int i=0;
		for(i=sum/2;i>=0;i--) {
			Boolean[][] dp = new Boolean[n][i+1];
			if(subsetSumK(n-1,arr,i, dp))
				break;
				
		}
		
		return sum - 2 * i;
	}

	private static boolean subsetSumK(int index, int[] arr, int target, Boolean[][] dp) {
		if(target == 0)
			return true;
		if(index == 0)
			return arr[0] == target;
		if(dp[index][target] != null) return dp[index][target];
		boolean np = subsetSumK(index-1, arr, target, dp);
		boolean p = false;
		if(target>=arr[index])
			p = subsetSumK(index-1, arr, target-arr[index], dp);
		return dp[index][target] =  p || np;
	}

	public static void main(String[] args) {
		int[] arr = {3,8,8,14};
		System.out.println(minSubsetSumDifference(arr, 4));

	}

}
