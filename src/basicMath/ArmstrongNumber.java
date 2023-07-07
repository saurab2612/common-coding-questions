package basicMath;

public class ArmstrongNumber {
	
	static String armstrongNumber(int n){
        int ans = 0;
        int in = n;
		while(n!=0) {
			int mul = n%10;
			ans = ans + (mul*mul*mul);
			n=n/10;
		}
		if(ans==in)
			return "Yes";
		else
			return "No";
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	//	System.out.println(armstrongNumber(12));
		System.out.println(armstrongNumber(153));

	}

}
