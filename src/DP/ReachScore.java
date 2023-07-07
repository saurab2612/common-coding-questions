package DP;

import java.util.Arrays;

public class ReachScore {
	
	public static long count(int n) {
        int[] score = {3,5,10};
        int[][] t = new int[4][n+1];
        
        for(int i=0;i<4;i++) {
        	for(int j=0;j<n+1;j++) {
        		
        		if(i==0 && j!=0) {
        			t[i][j] = 0;
        			continue;
        		}
        		if(j==0 && i!=0) {
        			t[i][j] = 1;
        			continue;
        		}
        		if(i==0 && j==0) {
        			t[i][j]=0;
        			continue;
        		}
        		
        		if(score[i-1] <= j) {
        			t[i][j] = t[i][j-score[i-1]] + t[i-1][j];
        		}else {
        			t[i][j] = t[i-1][j];
        		}
        	}
        }
        
        return t[3][n];
        
    }

	public static void main(String[] args) {
		
			System.out.println(count(20));
	}

}
