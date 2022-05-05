package com.practice.array;

import java.util.HashSet;
import java.util.Set;

public class Problem4 {
	public static boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        Boolean flag = false;
        for(int i=0;i<nums.length;i++){
            if(set.contains(nums[i])){
                flag=true;
                break;
            }else
                set.add(nums[i]);
        }
        return flag;
    }
	
	
	public static void main(String[] args) {
		int[] arr = {3,2,4,5,5};
		System.out.println(containsDuplicate(arr));
	}
}
