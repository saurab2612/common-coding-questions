package DP;

public class PrintLongestCommonSubsequence {
	
	public static String printLongestCommonSubsequence(String text1, String text2) {
		int l1 = text1.length();
		int l2 = text2.length();
		
		int[][] dp = new int[l1+1][l2+1];
		
		for(int i=1;i<=l1;i++) {
			for(int j=1;j<=l2;j++) {
				if(text1.charAt(i-1)==text2.charAt(j-1)) {
					dp[i][j] = 1+ dp[i-1][j-1];
				}else {
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
				}
			}
		}
		int i = l1; // this is to maintain count and fetch characters from tedxt
		int j = l2;
		String ans = "";
//		while(!(i==-1 && j==-1)) {  //checking for -1 coz we have to go till zero in dp which will be like -1 for text 2 and teext 2
//			if(text1.charAt(i) == text2.charAt(j)) {
//				ans = ans  + text1.charAt(i);
//				i--;
//				j--;
//			}else if((i>0 && j>0) && dp[i][j-1] > dp[i-1][j]) { // so that it doesn't go out of bopund
//				j--;
//			}else if((i>0 && j>0) && dp[i][j-1] <= dp[i-1][j]) { // so that it doesn't go out of bound
//				i--;
//			}else if(i==-1) { //once i is zero jusst reducce j
//				j--;
//			}else
//				i--; 
//		}
		while((i>=1 && j>=1)) {  //checking for -1 coz we have to go till zero in dp which will be like -1 for text 2 and teext 2
			if(text1.charAt(i-1) == text2.charAt(j-1)) {
				ans = ans  + text1.charAt(i-1);
				i--;
				j--;
			}else if(dp[i-1][j]>dp[i][j-1]) {
				i--;
			}else
				j--;
		}
		
		return ans;
	}

	public static void main(String[] args) {
		System.out.println(printLongestCommonSubsequence("abcde", "ace"));

	}

}
