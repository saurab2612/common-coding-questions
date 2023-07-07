package BinarySearch;

public class SingleElementLEET540 {
	
	public static int singleNonDuplicate(int[] nums) {
		if(nums.length == 1)
			return nums[0];
        int start = 0;
        int end = nums.length-1;
        
        while(end>=start) {
        	int mid = start + (end-start)/2;
        	
        	
        	if(mid == 0 && (nums[mid] != nums[mid+1])) {
        		return nums[mid];
        	}else if(mid == nums.length-1 && (nums[mid] != nums[mid-1])) {
        		return nums[mid];
        	}else if(nums[mid-1] != nums[mid] && nums[mid+1] != nums[mid])
        		return nums[mid];
        	else if( mid%2 == 0 && nums[mid-1] == nums[mid])
        		end = mid -1;
        	else if(mid%2 == 0 && nums[mid-1] != nums[mid])
        		start = mid + 1;
        	else if(mid%2 != 0 && nums[mid-1] == nums[mid])
        		start = mid + 1;
        	else
        		end = mid -1;
        }
        return -1;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1,1,2};
		singleNonDuplicate(arr);
		System.out.println(singleNonDuplicate(arr));
	}

}
