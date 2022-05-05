package com.practice.array;

public class Problem8 {
	
	public static int maxProfit(int[] prices) {
        int max = 0;
            int min = Integer.MAX_VALUE;
        for(int i=0;i<prices.length;i++){
            if(prices[i]<min)
                min =prices[i];
            if(prices[i]-min > max)
                max =prices[i]-min;
        }
        return max;
    }

	public static void main(String[] args) {
		int[] arr = {7,6,4,3,1};
		System.out.println(maxProfit(arr));
	}

}
