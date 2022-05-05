package com.practice.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem9 {
	
	public static ArrayList<Integer> repeatedNumber(final List<Integer> A) {
		ArrayList<Integer> list = new ArrayList<>();
		
		int n= A.size();
		int numberSum = n * (n+1)/2;
		int numberSquaresum = n * (2*n+1) *(n+1)/6;
		int actualsum =0;
		int actualsquaresum =0;
		for(int i=0;i<n;i++) {
			actualsum = actualsum + A.get(i);
			actualsquaresum = actualsquaresum + A.get(i)*A.get(i);
		}
		
		int kplusx = (numberSquaresum-actualsquaresum)/(numberSum-actualsum);
		int kminux = numberSum-actualsum;
		int repeateddigit = (kplusx+kminux)/2;
		list.add(repeateddigit);
		list.add(kplusx-repeateddigit);
		
		return list;
    }

	public static void main(String[] args) {
		Integer[] arr = {1,2,2,3,4,5};
		List<Integer> list2 = Arrays.asList(arr);
		ArrayList<Integer> list = repeatedNumber(list2);
		list.forEach(System.out::println);
	}

}
