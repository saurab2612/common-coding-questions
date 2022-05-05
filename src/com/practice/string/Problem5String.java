package com.practice.string;

public class Problem5String {
	
	public String longestCommonSuffix(String[] strs) {
        while(true) {
        	int index=1;
        	int flag =0;
        	char k='a';
        	String result= "";
        	for(int i=0;i<strs.length;i++) {
        		if(index>=strs[i].length())
        			return result;
        		if(i==0)
        			k=strs[i].charAt(strs[i].length()-index);
        		else if(strs[i].charAt(strs[i].length()-index)!=k)
        			return result;
        		else
        			continue;
        			
        	}
        	result+=k;
        	index++;
        	
        }
    }
	
	public static String longestCommonPreffix(String[] strs) {
		if(strs.length == 0)
			return "";
		else if(strs.length == 1)
			return strs[0];
		int index=0;
    	char k='a';
    	String result= "";
        while(true) {
        	for(int i=0;i<strs.length;i++) {
        		if(index == strs[i].length()) {
        			return result;
        		}
        		if(strs[i].equals(""))
        			return "";
        		if(i==0)
        			k=strs[i].charAt(index);
        		else if(strs[i].charAt(index)!=k)
        			return result;
        		else
        			continue;
        			
        	}
        	result+=k;
        	index++;
        	
        }
    }								

	public static void main(String[] args) {
		String[] strs = {"flower","flow","flight"};
		String[] strs2 = {"ab","a"};
		System.out.println(longestCommonPreffix(strs2));
	}

}
