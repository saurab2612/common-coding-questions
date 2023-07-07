package twopointer;

public class RemoveDuplicates {
	
	public static int removeDuplicates(int[] nums) {
        int i=1,j=1;
        while(j<nums.length) {
        	if(nums[j]==nums[i-1])
        		j++;
        	else {
        		nums[i] = nums[j];
        		i++;
        	}
        }
        return i;
    }

	public static void main(String[] args) {
		int[] arr = {0,0,1,1,1,2,2,3,3,4};
		removeDuplicates(arr);

	}

}
