package heap;

import java.util.PriorityQueue;

public class KthLargest {
	
	public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(int i=0;i<nums.length;i++) {
        	minHeap.add(nums[i]);
        	if(minHeap.size()>k)
        		minHeap.poll();
        }
        return minHeap.poll();
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
