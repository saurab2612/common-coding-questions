package DP;


// NEW CONCEPT
/*
 * step 1 is to assign dpn
 * step 2 get first two string andrecur
 * step 3 if first char is 0 then dp[i] =0
 * 			else
 * 		  check if s2 < 26
 * 			if yes then consider if you are in 2nd last position
 * 		  else
 * 			in this case onlt dp[i+1] value is required.ß	
 *         
 */
public class DecodeWaysLEET91 {
	
	
	public static int numDecodings(String s) {
		
		if(s.length()==1 && s.charAt(0)=='0')
			return 0;
		
		if(s.length()==0 || s.length() == 1)
			return s.length();
		
        int[] dp = new int[s.length()];
        if(s.charAt(s.length()-1)=='0')
        	dp[s.length()-1] = 0;
        else
        	dp[s.length()-1] = 1;
        
        for(int i=s.length()-2;i>=0;i--) {
        	String s2 = s.substring(i,i+2);
        	//int i=0,j=0;
        	if(s2.charAt(0)=='0') {
        		dp[i]=0;
        	}else{
        		if(Integer.valueOf(s2)<=26) {
        			if(i+2 <= dp.length-1) {
        				dp[i] = dp[i+1] + dp[i+2];
        			}else {
        				dp[i] = dp[i+1] + 1;
        			}
        		}else {
        			dp[i] = dp[i+1];
        		}
        	}
        	
        }
        return dp[0];       	  
        
    }	
	

	public static void main(String[] args) {

		String s = "12";
		System.out.println(numDecodings(s));
	}

}
