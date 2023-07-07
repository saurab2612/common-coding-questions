package Arrays;

public class WaveArray {
	
	public static void convertToWave(int n, int[] a) {
        for(int i=0;i<n-1;i=i+2) {
        	int temp = a[i];
        	a[i] = a[i+1];
        	a[i+1] = temp;
        }
        System.out.println(a);
    }

	public static void main(String[] args) {
		// 
		int[] arr = {1,2,3,4,5};
		convertToWave(5, arr);
	}

}
