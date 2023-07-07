package Arrays;

public class RotateArraybyk {
	public void rotate(int[] nums, int k) {
		
		if(k>=nums.length)
            k=k%nums.length;
		
		if(nums.length == 1)
			return;
		
        int pivot = nums.length - 1 - k;
        
        reverse(nums,0,pivot);
        reverse(nums,pivot+1,nums.length-1);
        reverse(nums,0,nums.length-1);
        
    }

	private void reverse(int[] nums, int i, int j) {
		while(j>i) {
			swap(nums,i,j);
			i++;
			j--;
		}
		
	}

	private void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
	

}
