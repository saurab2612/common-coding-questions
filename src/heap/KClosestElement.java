package heap;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class KClosestElement {
	static int[] printKClosest(int[] arr, int n, int k, int x) {
		Map<Integer, Integer> map = new  HashMap<>();
		for(int i=0;i<n;i++) {
			int difference = x-arr[i];
			if(difference < 0)
				difference = (-1) * (x-arr[i]); 
			map.put(arr[i], difference);
		}
		
		PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->{
			if(map.get(a)==map.get(b)) {
				if(a<=b)
					return 1;
				else
					return -1;
			}else
				return map.get(b) - map.get(a);
		});
		
		for(int i=0;i<n;i++) {
			if(arr[i] == x)
				continue;
			pq.add(arr[i]);
			if(pq.size()>k)
				pq.poll();
		}
		
		int[] ans = new int[k];
		for(int i=k-1;i>=0;i--) {
			ans[i] = pq.poll();
		}
		return ans;
	}

	public static void main(String[] args) {
		int[] arr = {12, 16, 22, 30, 35, 39, 42, 
		         45, 48, 50, 53, 55, 56};
		printKClosest(arr, 13, 4, 35);
	}

}
