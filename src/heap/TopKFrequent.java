package heap;

import java.util.HashMap;
import java.util.PriorityQueue;

public class TopKFrequent {
	
	public static int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> m = new HashMap<>();
        for(int i=0;i<nums.length;i++) {
        	m.put(nums[i], m.getOrDefault(nums[i], 0)+1);
        }
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->m.get(a)-m.get(b));
        
        for(int i:m.keySet()) {
        	pq.add(i);
        	if(pq.size()>k)
        		pq.poll();
        }
        return pq.stream().mapToInt(i->i).toArray();
    }

	public static void main(String[] args) {
		int nums[] = {1,1,1,2,2,3};
		topKFrequent(nums, 2);
	}

}
