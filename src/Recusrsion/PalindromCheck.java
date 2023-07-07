package Recusrsion;

public class PalindromCheck {
	
	public static boolean isPalindrome(String s) {
        return palindromeRecur(0,s.length()-1,s);
    }

	private static boolean palindromeRecur(int i, int j, String s) {
		if(i>=j)
			return true;
		
		if((isCharNum(s,i) && isCharNum(s,j))) {
			if(s.substring(i, i+1).equalsIgnoreCase(s.substring(j, j+1)))
				return palindromeRecur(i+1, j-1, s);
			else
				return false;
		}else if(!(isCharNum(s,i) || isCharNum(s,j))) {
			return palindromeRecur(i+1, j-1, s);
		}else if(!isCharNum(s, i)) {
			return palindromeRecur(i+1, j, s);
		} else if (!isCharNum(s, j)) {
			return palindromeRecur(i, j-1, s);
		}
		return false;
	}

	private static boolean isCharNum(String s, int i) {
		int x = (int)s.charAt(i);
		if((x>=97 && x<=122) || (x>=65 && x<=90) || (x>=48 && x<=57))
			return true;
		else
			return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	//	System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
		
		System.out.println(isPalindrome(".,"));
		
		System.out.println(isPalindrome("  "));

	}

}
