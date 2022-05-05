package com.practice.string;

public class longestSubstringwithNoRepetion {
	
	public static void main(String[] args) {
		
		String s = "aaabcdceefgggg";
		String maxlength="";
		String currentMax = "";
		
		
		for(char c: s.toCharArray()) {
			String str = String.valueOf(c);
			if(!currentMax.contains(str)) {
				currentMax = currentMax + c;
			}else {
				//start = currentMax.indexOf(c)+1;
				currentMax = currentMax.substring(currentMax.indexOf(c)+1)+str;
				
				
			}
			if(currentMax.length()>maxlength.length()) {
				maxlength = currentMax;
			}
		}
		
		System.out.println(maxlength);
	}

}
