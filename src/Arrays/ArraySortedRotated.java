package Arrays;

public class ArraySortedRotated {
	
	static public boolean check(int[] nums) {
        int count = 0;
        int pivot = Integer.MAX_VALUE;
	 for(int i=0;i<nums.length-1;i++) {
		 if(nums[i]<=nums[i+1] && nums[i]<=pivot)
			 continue;
		 else {i++;
			 if(nums[i]<=nums[0]){
				 count++;
                 pivot = nums[0];
             }else
				 return false;
			 if(count>1)
				 return false;
		 }
	 }
	 return true;
	 
    }

}
