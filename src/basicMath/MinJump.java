package basicMath;

public class MinJump {
	
	static int minJumps(int[] arr){
        int index = 0;
        int jump = 0;
		while(arr[index]!=0) {
			index = index + arr[index];
			jump++;
			if(index>=arr.length)
				return jump;
		}
		
		return -1;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
