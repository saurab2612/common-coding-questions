package com.practice.string;

public class Problem1String {
	
	public static boolean isPalindrome(String s) {
        String str = s.toLowerCase();
        String str1 = "";
        
        for(int i=0;i<str.length();i++) {
        	if(Character.isLetter(str.charAt(i)) || Character.isDigit(str.charAt(i))) {
        		str1 = str1 + str.charAt(i);
        	}
        }
        
        
        
        for(int i=0,j=str1.length()-1;i<=str1.length()/2-1;i++,j--) {
        	if(str1.charAt(i)!=str1.charAt(j))
        		return false;
        }
        return true;
    }
	
	//raceacar
	
	public static void main(String[] args) {
		System.out.println(isPalindrome("0P"));
	}

}
