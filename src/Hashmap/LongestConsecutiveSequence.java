package Hashmap;

import java.util.HashMap;
import java.util.Map;

public class LongestConsecutiveSequence {
	
public static int longestConsecutive(int[] nums) {
        
        if(nums.length ==0)
            return 0;
        
        
		int maxs = Integer.MIN_VALUE;
        Map<Integer, Boolean> map = new HashMap<>();
        for(int i=0;i<nums.length;i++) {
        	map.put(nums[i], false);
        }
        for(int i=0;i<nums.length;i++) {
        	if(map.containsKey(nums[i]+1)) {
        		map.put(nums[i], true);
        	}
        }
        
        for(int i=0;i<nums.length;i++) {
        	int max = 1;
        	if(map.get(nums[i])) {
                int k = nums[i];
        		while(map.containsKey(k+1)) {
        			max++;
                   k++; 
        		}
        		if(max>maxs)
        			maxs = max;
        	}
        	
        }
       return maxs;  
        
    }
	

	public static void main(String[] args) {
		int[] arr = {0,0};
		System.out.println(longestConsecutive(arr));
	}

}
