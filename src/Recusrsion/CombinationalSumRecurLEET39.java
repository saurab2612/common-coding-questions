package Recusrsion;

import java.util.ArrayList;
import java.util.List;

public class CombinationalSumRecurLEET39 {
	
	public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        
       // combinationSumRecur(candidates, target, 0, 0 ,cur, ans);
        combinationSumRecur2(candidates, target, 0, cur, ans);
        return ans;
    }

	private static void combinationSumRecur(int[] candidates, int target, int sum, int index, List<Integer> cur,
			List<List<Integer>> ans) {
		if(sum>target) {
			return;
		}
		
		if(index==candidates.length) {
			if(sum == target) {
				ans.add(new ArrayList<>(cur));
			}
			return;
		}
		
		cur.add(candidates[index]);
		combinationSumRecur(candidates, target, sum + candidates[index], index, cur, ans);
		cur.remove(cur.size()-1);
		combinationSumRecur(candidates, target, sum, index+1, cur, ans);
		
	}
	//instead of maintaining two different pointers for target andcurrent sum
	private static void combinationSumRecur2(int[] candidates, int target, int index, List<Integer> cur,
			List<List<Integer>> ans) {
		if(target<0) {
			return;
		}
		
		if(index==candidates.length) {
			if(target == 0) {
				ans.add(new ArrayList<>(cur));
			}
			return;
		}
		
		cur.add(candidates[index]);
		combinationSumRecur2(candidates, target - candidates[index], index, cur, ans);
		cur.remove(cur.size()-1);
		combinationSumRecur2(candidates, target, index+1, cur, ans);
		
	}

	public static void main(String[] args) {
		int[] arr = {2,3,6,7};
		combinationSum(arr, 7);
	}

}
