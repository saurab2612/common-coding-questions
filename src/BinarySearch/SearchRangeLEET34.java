package BinarySearch;

public class SearchRangeLEET34 {
	
	public static int[] searchRange(int[] nums, int target) {
        int[] ans = new int[2];
        ans[0] =-1;
        ans[1] = -1;
        int start = 0;
        int end = nums.length-1;
        searchRangeRecur(start,end,ans,nums,target);
        return ans;
    }

	private static int[] searchRangeRecur(int start, int end, int[] ans, int[] nums, int target) {
		
		if(end<start)
			return ans;
		
		int mid = start + (end-start)/2;
		if(nums[mid] == target) {
			if(mid == nums.length-1 || nums[mid+1]!=target)
				ans[1] =mid;
			else
				searchRangeRecur(mid+1, end, ans, nums, target);
			if(mid == 0 || nums[mid-1]!=target)
				ans[0] = mid;
			else
				searchRangeRecur(start, mid-1, ans, nums, target);
		} else if(nums[mid]<target) {
			searchRangeRecur(mid+1, end, ans, nums, target);
		} else {
			searchRangeRecur(start, mid-1, ans, nums, target);
		}
		return ans;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {5,7,7,8,8,10};
		searchRange(arr, 6);

	}

}
