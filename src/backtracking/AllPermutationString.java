package backtracking;

import java.util.ArrayList;
import java.util.List;

public class AllPermutationString {
	
	public static List<String> find_permutation(String S) {
        List<String> list = new ArrayList<String>();
        int size = S.length();
        permutation(list,S,0,size-1);
        return list;
    }
	
	private static void permutation(List<String> list, String s, int left, int right) {
		if(left == right) {
			list.add(s);
			System.out.println(s);
		}
		for(int i=left;i<=right;i++) {
			s = swap(s,left,i);
			permutation(list, s, left+1, right);
			s = swap(s,i,left);
		}
		
	}

	private static String swap(String s, int i, int left) {
		char[] arr = s.toCharArray();
		char temp = arr[i];
		arr[i] = arr[left];
		arr[left] = temp;
		return String.valueOf(arr); 
	}

	public static void main(String[] args) {
		String s = "abc";
		find_permutation(s);
		
	}

}
