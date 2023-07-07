package Recusrsion;

import java.util.ArrayList;
import java.util.List;



//TODO: try returning array once

public class FindAllK {
	
	public static ArrayList<Integer> findAll(int[] arr, int i, ArrayList<Integer> list){
		if(i==arr.length)
			return list;
		
		list = findAll(arr, i+1, list);
		if(arr[i]==8)
			list.add(i);
		return list;
	}

	public static void main(String[] args) {
		ArrayList<Integer> l = new ArrayList<>();
		int[] arr = {2,3,8,6,8,2};
		System.out.println(findAll(arr, 0, l));

	}

}
