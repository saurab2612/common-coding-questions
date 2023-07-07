package Hashmap;

import java.util.HashMap;

public class CommonElements {
	
	public static void commonElementsPrint(int arr1[], int arr2[]) {
		HashMap<Integer, Integer> map = new HashMap<>();
		for(int i=0;i<arr1.length;i++) {
			map.put(arr1[i], map.getOrDefault(arr1[i], 0)+1);
		}
		for(int i = 0; i<arr2.length;i++) {
			if(map.containsKey(arr2[i])) {
				System.out.println(arr2[i]);
				map.put(arr2[i], map.get(arr2[i])-1);
				if(map.get(arr2[1]) == 0) {
					map.remove(arr2[i]);
				}
			}else
				continue;
				
		}
		
	}

	public static void main(String[] args) {
		int[] arr1 = {1,1,1,2,2,2,4,4,4,5,5,6};
		int[] arr2 = {2,2,1,1,3,3,5,5,6,7};
		
		commonElementsPrint(arr1, arr2);

	}

}
