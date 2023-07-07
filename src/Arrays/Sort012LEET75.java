package Arrays;

public class Sort012LEET75 {
	
	public static void sortColors(int[] nums) {
        int ones =0;
        int twos = 0;
        int zeros = 0;
        for(int i=0;i<nums.length;i++) {
        	if(nums[i] == 0)
        		zeros++;
        	if(nums[i] == 1)
        		ones++;
        	if(nums[i] == 2)
        		twos++;		
        }
        
        for(int i=0;i<nums.length;i++) {
        	if(zeros!=0) {
        		nums[i] = 0;
        		zeros--;
        	} else if(ones!=0) {
        		nums[i] = 1;
        		ones--;
        	} else if(twos!=0) {
        		nums[i] = 2;
        		twos--;
        	}
        }
        
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
