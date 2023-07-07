package heap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Stack;

public class NextGreaterElement {
	
	//Function to find the next greater element for each element of the array.
    public static long[] nextLargerElement(long[] arr, int n)
    { 
    	Stack<Long> s = new Stack<>();
    	ArrayList<Long> a = new ArrayList<>();
    	
    	for(int i=arr.length-1;i>=0;i--) {
    		if(s.isEmpty()) {
    			a.add(-1l);
    		}else if(!s.isEmpty() && s.peek() > arr[i]) {
    			a.add(s.peek());
    		}else if(!s.isEmpty() && arr[i]>=s.peek()) {
    			while(!s.isEmpty() && s.peek()<arr[i]) {
    				s.pop();
    			}
    			if(s.isEmpty())
    				a.add(-1l);
    			else
    				a.add(s.peek());
    		}
    		s.add(arr[i]);
    	}
    	Collections.reverse(a);
    	return a.stream().mapToLong(i->i).toArray();
    } 

	public static void main(String[] args) {
		long[] arr = {1,3,2,4};
		nextLargerElement(arr,0);

	}

}
