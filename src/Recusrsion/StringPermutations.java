package Recusrsion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringPermutations {
	
	public static List<String> permutation(String str, String result, List<String> ans){
		if(str.length() == 0) {
			ans.add(result);
			return ans;
		}
		for(int i=0;i<str.length();i++) {
			permutation(str.substring(0,i) + str.substring(i+1), str.charAt(i) + result, ans);
		}
		return ans;
	}
	
	public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        
        permutationRecur(nums, ans ,cur, 0);
        return ans;
     }
	

	private static void permutationRecur(int[] nums, List<List<Integer>> ans, List<Integer> cur, int index) {
		
		if(index == nums.length) {
			ans.add(new ArrayList<>(cur));
			return;
		}
		
		for(int i=0;i<nums.length;i++) {
			if(nums[i] != -11) {
				cur.add(nums[i]); 
				nums[i] = -11;
				permutationRecur(nums, ans, cur, index+1);
				nums[i] = cur.get(cur.size()-1);
				cur.remove(cur.size()-1);
			}
		}
		
		
	}
	
	
	private static List<List<Integer>> permutationSwap(int[] nums) {
		List<List<Integer>> ans = new ArrayList<>();
		permSwapRecur(nums, 0, ans);
		return ans;
	}

	private static void permSwapRecur(int[] nums, int index, List<List<Integer>> ans) {
		
		if(index == nums.length) {
			
			ans.add(Arrays.stream(nums).boxed().collect(Collectors.toList()));
			return;
		}
		
		for(int i=index;i<nums.length;i++) {
			swap(nums, index, i);
			permSwapRecur(nums, index + 1, ans);
			swap(nums, i, index);
		}
	}

	private static void swap(int[] nums, int index, int i) {
		int temp = nums[index];
		nums[index] = nums[i];
		nums[i] = temp;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> ans = new ArrayList<>();
		int nums[] = {0,1};
		List<List<Integer>> ls = permutationSwap(nums);
		
		String s = "" + "";
		System.out.println(s.length());
	//	system.arra
		
	}

}
