package Greedy;

import java.util.Arrays;
import java.util.HashMap;


class Pair implements Comparable<Pair>{
	int begin;
	int end;
	Pair(int begin,int end){
		this.begin = begin;
		this.end = end;
	}
	@Override
	public int compareTo(Pair o) {
		if(this.end>o.end)
			return 1;
		else if(this.end == o.end)
			return 0;
		else if(this.end < o.end)
			return -1;
		
		return 0;
	}
	
}

public class ActivitySelection {
	
	//Function to find the maximum number of activities that can
    //be performed by a single person.
//    public static int activitySelection(int start[], int end[], int n)
//    {
//    	if(n==0)
//    		return 0;
//    	int activityCount = 0;
//    	HashMap<Integer, Integer> map = new HashMap<>();
//        for(int i=0;i<n;i++) {
//        	map.put(end[i], start[i]);
//        }
//        Arrays.sort(end);
//        activityCount++;
//        int last=0;
//        for(int i=1;i<n;i++) {
//        	if(map.get(end[i])>end[last]) {
//        		activityCount++;
//        		last=i;
//        	}
//        }
//        return activityCount;
//        
//    }
	
	
	
	
	public static int activitySelelction(int start[], int end[], int n) {
		if(n==0)
			return 0;
		int activityCount = 0;
		Pair[] arr = new Pair[n];
		for(int i=0;i<n;i++) {
			arr[i] = new Pair(start[i], end[i]);
		}
		Arrays.sort(arr);
		
		activityCount++;
		int last=0;
	      for(int i=1;i<n;i++) {
	      	if(arr[i].begin>arr[last].end) {
	      		activityCount++;
	      		last=i;
	      	}
	      }
	      return activityCount;
	}

	public static void main(String[] args) {
		int N = 4;
		int start[] = {7,2,2,3};
		int end[] = {8,4,7,10};
		
		System.out.println(activitySelelction(start, end, N));
	}

}
