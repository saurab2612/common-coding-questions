package Recusrsion;

public class FindKLastOcuurence {
	
	public static int find(int[] arr, int i) {
		
		if(i==arr.length)
			return -1;
		
		int k = find(arr, i+1);
		if(k==-1) {
			if(arr[i]==8)
				return i;
			else
				return -1;
		}else
			return k;
	}

	public static void main(String[] args) {
		int[] arr = {2,3,8,6,8,2};
		System.out.println(find(arr, 0));

	}

}
