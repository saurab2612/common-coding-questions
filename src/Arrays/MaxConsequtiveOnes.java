package Arrays;

public class MaxConsequtiveOnes {
	
	public int findMaxConsecutiveOnes(int[] nums) {
        int maxHi = 0, curHi = 0;
        for(int i=0;i<nums.length;i++) {
        	if(nums[i] == 1)
        		curHi += 1;
        	else {
        		if(curHi>maxHi)
        			maxHi = curHi;
        	}
        }
        return maxHi;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

} 
