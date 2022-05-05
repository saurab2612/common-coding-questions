package com.practice.string;

public class Problem4String {
	
	public static String removeConsecutiveCharacter(String S){
		StringBuilder sb = new StringBuilder();
        for(int i=0;i<S.length();i++) {
        	if(i==0)
        		sb = sb.append(S.charAt(i));
        	else if(S.charAt(i) == sb.charAt(sb.length()-1))
        		continue;
        	else
        		sb.append(S.charAt(i));
        }
        return sb.toString();
    }

	public static void main(String[] args) {
		System.out.println(removeConsecutiveCharacter("aaabbcbcccddbaaaa"));
	}

}
