package Arrays;

public class MissingNumber {
	
    public int missingNumber(int[] nums) {
        
     int len = nums.length;
     int orgSum = 0, newSum = 0;
     for(int i = 0;i<=len;i++) {
    	 orgSum += i;
     }
     for(int i = 0;i<len;i++) {
    	 newSum += nums[i];
     }
     return orgSum - newSum;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
