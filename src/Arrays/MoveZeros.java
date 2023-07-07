package Arrays;



//find the first zero if exists
//then keep swapping with the next non zero element. this will push all the zeros at the end.
public class MoveZeros {
	
 static public void moveZeroes(int[] nums) {
        int i=0;
        while(nums[i]!=0)
        	i++;
        int j = i+1;
        while(j!=nums.length-1) {
        	if(nums[j]!=0) {
        		swap(nums,i,j);
        		i++;j++;
        	}else
        		j++;
        }
    }

	private static void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
