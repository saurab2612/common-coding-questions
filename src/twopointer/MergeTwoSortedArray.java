package twopointer;

import java.util.ArrayList;

public class MergeTwoSortedArray {
	
	public static void merge(ArrayList<Integer> a, ArrayList<Integer> b) {
		int i = 0;
		int j = 0;
		
		while(i!=a.size() && j!=b.size()) {
			if(a.get(i)<=b.get(j)) {
				i++;
				continue;
			}
			else {
				a.add(i, b.get(j));
				j++;
			}
		}
		if(j<b.size()) {
			while(j!=b.size()) {
				a.add(b.get(j));
				j++;
			}
		}
	}

	public static void main(String[] args) {
		
		ArrayList<Integer> a = new ArrayList<>();
		ArrayList<Integer> b = new ArrayList<>();
		
		a.add(1);
		a.add(5);
		a.add(8);
		b.add(6);
		b.add(9);
		
		
		merge(a, b);

	}

}
