package Arrays;

import java.util.ArrayList;

public class TwoSortedArrayUnion {
	
	public static ArrayList<Integer> findUnion(int arr1[], int arr2[], int n, int m)
    {
		ArrayList<Integer> ans = new ArrayList<>();
		int i=0,j=0;
		
		while(i<arr1.length && j<arr2.length) {
			if(arr1[i] == arr2[j]) {
				ans.add(arr1[i]);
				i++;
				j++;
			}else if(arr1[i]>arr2[j])
				j++;
			else
				i++;
		}
		return ans;
    }

	public static void main(String[] args) {
		
	}

}
