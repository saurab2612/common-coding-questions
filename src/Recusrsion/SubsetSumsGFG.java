package Recusrsion;

import java.util.ArrayList;
import java.util.Collections;
//solved assuming that there cant be two sumsets containing same items
public class SubsetSumsGFG {
//solved assuming that there cant be two sumsets containing same items	
//	static ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int N){
//        ArrayList<Integer> ans = new ArrayList<>();
//        ans.add(0);
//        Collections.sort(arr);
//		subsetSumsRecur(arr, 0, 0, ans);
//		Collections.sort(ans);
//		return ans;
//    }
//
//	private static void subsetSumsRecur(ArrayList<Integer> arr, int sum, int index, ArrayList<Integer> ans) {
//		if(index == arr.size()) {
//			return; // coz no usecase is possible sum is already stpred that's why simply returning
//		}
//		
//		for(int i = index; i<arr.size();i++) {
//			if(i>index && arr.get(i) == arr.get(i-1)) continue;
//			
//			sum = sum + arr.get(i);
//			ans.add(sum);
//			subsetSumsRecur(arr, sum, i+1, ans);
//			sum = sum - arr.get(i);
//		}
//		
//	}
	
	
	static ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int N){
        ArrayList<Integer> ans = new ArrayList<>();
        subsetSumsRecur(arr, 0, ans, 0);
		Collections.sort(ans);
		return ans;
    }

	static private void subsetSumsRecur(ArrayList<Integer> arr, int index, ArrayList<Integer> ans, int sum) {
	
		if(index == arr.size()) {
			ans.add(sum);
			return;
		}
		
		sum = sum + arr.get(index);
		subsetSumsRecur(arr, index + 1, ans, sum);
		sum = sum - arr.get(index);
		subsetSumsRecur(arr, index + 1, ans, sum);
}

	public static void main(String[] args) {
		ArrayList<Integer> arr = new ArrayList<>();
		arr.add(5);
		arr.add(2);
		arr.add(1);
		subsetSums(arr, 3);
		

	}

}
