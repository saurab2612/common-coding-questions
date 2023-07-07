package twopointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class TwoSumUsingHashMap {
	
	public static int[] twoSum(int[] nums, int target) {
        int[] ans = new int[2];
        List<List<Integer>> l = new ArrayList<>();
        HashMap<Integer,Integer> set = new HashMap<>();
        
        for(int i=0;i<nums.length;i++){
            if(set.containsKey(target-nums[i])){
            	List<Integer> ll = new ArrayList<>();
                ll.add(i);
                ll.add(set.get(target-nums[i]));
                l.add(ll);
            }else{
                set.put(nums[i],i);
            }
        }
        
        return ans;
    }
	
	
	
	public static List<List<Integer>> threeSum(int[] nums) {
		Arrays.sort(nums);
		List<List<Integer>> l = new ArrayList<>();
        for(int j=0;j<nums.length-2;j++) {
        	int k = Integer.MIN_VALUE;
        	if((j>0 && nums[j-1] == nums[j]))
        		continue;
        	HashMap<Integer,Integer> set = new HashMap<>();
        	for(int i=j+1;i<nums.length;i++){
        		if((i>j+1 && nums[i] == k))
        			continue;
                if(set.containsKey(0-nums[j]-nums[i])){
                	k = nums[i];
                	List<Integer> ll = new ArrayList<>();
                    ll.add(nums[j]);
                    ll.add(nums[i]);
                    ll.add(0-nums[j]-nums[i]);
                    l.add(ll);
                }else{
                    set.put(nums[i],i);
                }
            }
        	
        }
        return l;
    }

	public static void main(String[] args) {
		int[] arr = {0,0,0};
		threeSum(arr);

	}

}
