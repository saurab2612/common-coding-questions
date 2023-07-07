package BinarySearch;

public class RotationCount {
	
	static int findKRotation(int arr[], int n) {
		int start = 0;
		int end = arr.length-1;
		
		while(end>=start) {
			int mid = start + (end-start)/2;
			
			if(mid == arr.length-1) return 0;
			else if(arr[mid+1]<arr[mid]) return mid+1;
			else if(arr[mid]<arr[0])
				end = mid -1;
			else
				start = mid + 1;
		}
		return 0;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {66 ,67 ,7 ,10 ,14 ,19 ,27, 33 ,36 ,40 ,44, 54 ,60};
		System.out.println(findKRotation(arr, 13));

	}

}
