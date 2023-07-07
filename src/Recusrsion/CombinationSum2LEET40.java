package Recusrsion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class CombinationSum2LEET40 {
	
//	public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
//        Set<List<Integer>> ans = new HashSet<>();
//        List<Integer> cur = new ArrayList<>();
//        
//        Arrays.sort(candidates); // if we are using set then better sort it out to avoid cases like 1,4,1 and 1,1,4 
//        
//        combinationSumRecur(candidates, target, ans, cur, 0);
//        return new ArrayList<>(ans);
//    }
//
//	private static void combinationSumRecur(int[] candidates, int target, Set<List<Integer>> ans, List<Integer> cur, int index) {
//		if(target < 0) {
//			return;
//		}
//		
//		if(index == candidates.length) {
//			if(target == 0) {
//				ans.add(new ArrayList<>(cur));
//			}
//			
//			return;
//		}
//		
//		cur.add(candidates[index]);
//		combinationSumRecur(candidates, target - candidates[index], ans, cur, index+1);
//		cur.remove(cur.size()-1);
//		combinationSumRecur(candidates, target, ans, cur, index+1);
//		return;
//	}
	
	
	public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        Arrays.sort(candidates);
        combinationSumRecur(candidates, 0, target, cur, ans);
         return ans;
    }
	
	
	

	private static void combinationSumRecur(int[] candidates, int index, int target, List<Integer> cur,
		List<List<Integer>> ans) {
		
		if(target==0) {
			ans.add(new ArrayList<>(cur));
			return;
		}
		
		for(int i=index;i<candidates.length;i++) {
			if(i>index && candidates[i] == candidates[i-1]) continue;
			if(target<candidates[i])return;
			
			cur.add(candidates[i]);
			combinationSumRecur(candidates, i+1, target-candidates[i], cur, ans);
			cur.remove(cur.size()-1);
		}
}




	public static void main(String[] args) {
		//[4,1,1,4,4,4,4,2,3,5]
		//10
		//
		
		
		
		
		int[] arr = {4,1,1,4,4,4,4,2,3,5};
		combinationSum2(arr, 10);

	}

}
