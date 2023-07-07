package Recusrsion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Subsets2LEET90 {
	
	static public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
		ans.add(Collections.EMPTY_LIST);
        Arrays.sort(nums);
        subsetsRecur(nums, 0, ans, cur);
        return ans;
    }

	private static void subsetsRecur(int[] nums, int index, List<List<Integer>> ans, List<Integer> cur) {
		if(index == nums.length) {
			return;
		}
		
		for(int i=index;i<nums.length;i++) {
			if(i>index && nums[i] == nums[i-1]) continue;
			
			cur.add(nums[i]);
			ans.add(new ArrayList<>(cur));
			subsetsRecur(nums, i+1, ans, cur);
			cur.remove(cur.size()-1);
			
		}
		
	}

	public static void main(String[] args) {
		int[] nums = {1,2,2};
		subsetsWithDup(nums);

	}

}
