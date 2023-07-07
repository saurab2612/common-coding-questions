package basicMath;

public class LCMndHCF {
	
	static Long[] lcmAndGcd(Long A , Long B) {
        Long[] ans = new Long[2];
        //hcf
        ans[1] = gcd(A,B);
        //lcm
        ans[0] = A*B/(ans[1]);
        return ans;
    }

	private static Long gcd(Long a, Long b) {
		if(a==0)
			return b;
		if(b==0)
			return a;
		
		if(a>b)
			return gcd(a%b,b);
		else
			return gcd(a,b%a);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
