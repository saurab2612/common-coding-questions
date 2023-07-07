package basicMath;

public class PalindromeCheck {
	//method1
	public static boolean isPalindrome1(int x) {
        String in = Integer.toString(x);
        int i = 0;
        int j = in.length()-1;
        while(j>i) {
        	if(in.charAt(i++)!=in.charAt(j--))
        		return false;
        }
        return true;
    }
	//method2
	public static boolean isPalindrome(int x) {
        if(x<0) return false;
        
        int rev = 0;
        while(rev<x) {
        	rev = rev * 10 + x%10;
        	x=x/10;
        	
        }
        if(x==rev) return true;
        if(rev > x && rev/10 == x) return true;
        return false;
    }

	public static void main(String[] args) {
		System.out.println(isPalindrome(1));
		System.out.println(isPalindrome(-121));
		System.out.println(isPalindrome(0));
		System.out.println(isPalindrome(123));

	}

}
