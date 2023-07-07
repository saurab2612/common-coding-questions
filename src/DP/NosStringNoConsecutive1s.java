package DP;



// New way of solving problem kinda like fibonacci
public class NosStringNoConsecutive1s {
	
	static long countStrings(int n) {
        long dp1[] = new long[n+1];
        long dp0[] = new long[n+1];
        
        dp1[0] = dp0[0] = 0l;
        dp1[1] = dp0[1] = 1l;
        
        if(n<=1)
        	return dp1[n] + dp0[n];
        
        for(int i=2;i<=n;i++) {
        	dp1[i] = dp0[i-1];
        	dp0[i] = (dp0[i-1] + dp1[i-1])%1000000007;
        }
        
        return (dp1[n]+dp0[n])%1000000007;
        
        
    }

	public static void main(String[] args) {
		System.out.println(countStrings(43));

	}

}
