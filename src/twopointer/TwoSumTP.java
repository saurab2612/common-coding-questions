package twopointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TwoSumTP {
	//single ans
	public static int[] twoSumSingleAns(int[] nums, int target) {
		int ans[] = new int[2];
		Arrays.sort(nums);
		int lo = 0;
		int hi = nums.length-1;
		while(hi!=lo) {
			if(nums[hi] + nums[lo] > target)
				hi--;
			else if(nums[hi] + nums[lo] < target)
				lo++;
			else {
				ans[0] = hi;
				ans[1] = lo;
				break;
			}
		}
		return ans;
	}
	
	//multiple ans
	public static List<List<Integer>> twoSum(int[] nums, int target) {
		List<List<Integer>> ans = new ArrayList<>();
		Arrays.sort(nums);
		int lo = 0;
		int hi = nums.length-1;
		while(hi>=lo) {
			if(nums[hi] + nums[lo] > target)
				hi--;
			else if(nums[hi] + nums[lo] < target)
				lo++;
			else {
				List<Integer> l = new ArrayList<>();
				l.add(hi);
				l.add(lo);
				ans.add(l);
				hi--;
				lo++;
			}
		}
		return ans;
	}
	
	
	public static List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> ans = new ArrayList<>();
		Arrays.sort(nums);
		for(int i=0;i<nums.length;i++) {
			if(i>0 && nums[i-1] == nums[i])
				continue;
			int hi = nums.length-1;
			int lo = i+1;
			while(hi>lo) {
				if(nums[hi] + nums[lo] > (-1) * nums[i])
					hi--;
				else if(nums[hi] + nums[lo] < (-1) * nums[i]) 
					lo++;
				else {
					List<Integer> l = new ArrayList<>();
					l.add(nums[i]);
					l.add(nums[hi]);
					l.add(nums[lo]);
					ans.add(l);
					hi--;
					lo++;
					while(hi > 0 && nums[hi]==nums[hi+1])
						hi--;
					while(lo<nums.length-1 && nums[lo]==nums[lo-1])
						lo++;
				}
			}
		}
		return ans;
    }

	public static void main(String[] args) {
		int[] arr = {-4,-1,-1,0,1,2};
		//twoSum(arr, 9);
		threeSum(arr);

	}

}
