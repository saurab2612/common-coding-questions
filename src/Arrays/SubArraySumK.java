package Arrays;

public class SubArraySumK {
	
	public static int subarraySum(int[] nums, int k) {
        int[] count = new int[1];
        recur(nums,nums.length-1,k,0,count,"");
        return count[0];
    }

	private static void recur(int[] nums, int index, int k, int sum, int[] count,String s) {
        if(sum == k) {
			count[0]++;
			System.out.println(s);
			return;
		}
		if(sum>k)
			return;
		if(index==-1) {
            return;
		}
		
		
		recur(nums,index-1,k,sum+nums[index],count,s + nums[index]);
		recur(nums,index-1,k,0, count,"");
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub;
		int[] arr = {1,2,1,2,1};
		System.out.println(subarraySum(arr, 3));

	}

}
