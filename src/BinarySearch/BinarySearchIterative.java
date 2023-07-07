package BinarySearch;

public class BinarySearchIterative {
	
	public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length-1;
        
        while(end>=start) {
        	int mid = start + (end-start)/2;
        	if(nums[mid] == target)
        		return mid;
        	else if(nums[mid]<target)
        		start = mid+1;
        	else
        		end = mid-1;
        }
        return -1;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
