package DP;

public class ClimbingStairsLEET70 {
	
	public int climbStairs(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1;
        for(int i=1;i<dp.length;i++) {
        	//coz here fixed jump of 2 is given we have directly done i-1 and i-2
        	//else for variable jum for each step we would have picked the jump from 1-n
        	//so would have used a loop instead
        	
        	//
        	
        	
        	int im1=0,im2=0;
        	if(i-1>=0)
        		im1=dp[i-1];
        	if(i-2>=0)
        		im2=dp[i-2];
        	
        	
        	dp[i] = im1 + im2;
        		
        	}
        
        return dp[n];
        
        }
	
	public static int climbStairsmin(int n) {
        int[] dp = new int[n+1];
        dp[0] = 0; // for moves base case 0
        for(int i=1;i<dp.length;i++) {        	
        	int im1=Integer.MAX_VALUE,im2=Integer.MAX_VALUE;
        	if(i-1>=0)
        		im1=dp[i-1];
        	if(i-2>=0)
        		im2=dp[i-2];
        	
        	
        	dp[i] = 1 + Math.min(im1,im2);
        		
        	}
        
        return dp[n];
        
        }


	public static void main(String[] args) {
		System.out.println(climbStairsmin(7));

	}

}
