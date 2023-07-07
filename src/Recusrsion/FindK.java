package Recusrsion;

public class FindK {
	
	public static int find(int[] arr, int i) {
		
		if(i == arr.length) {
			if(arr[i]==8)
				return i;
			else 
				return -1;
		}
		
		if(arr[i] == 8){
			return i;
		}else
			return find(arr, i+1);
	}

	public static void main(String[] args) {
		int[] arr = {2,3,8,6,8,2};
		System.out.println(find(arr, 0));

	}

}
