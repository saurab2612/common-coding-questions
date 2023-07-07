package heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class KlargestElements {
	
	int[] kLargest(int[] arr, int n, int k) {
        PriorityQueue<Integer> mh = new PriorityQueue<>();
        for(int i =0;i<n;i++) {
        	mh.add(arr[i]);
        	if(mh.size()>n)
        		mh.poll();
        }
        return mh.stream().mapToInt(i->i).toArray();
    }

	public static void main(String[] args) {
		
	}

}
