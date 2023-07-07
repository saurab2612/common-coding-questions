package basicMath;

public class ReverseANumber {
	
	public static int reverse2(int x) {
        int flag = x<0?-1:1;
        
        String input = flag==1?Integer.toString(x):Integer.toString(x).substring(1);
        
        int mid = input.length()/2 - 1;
        
        if(input.length()==1)
        	return x;
        
        int len = input.length();
        
        StringBuilder os = new StringBuilder(input);
        for(int i=0;i<=mid;i++) {
        	char tmp = input.charAt(i);
        	os.setCharAt(i, input.charAt(len-i-1));
        	os.setCharAt(len-i-1, tmp);
        }
        
         try{return flag * Integer.valueOf(os.toString());}catch (Exception e) {return 0;}
    }
	
	
	public static int reverse(int x) {
		int n = x;
		int reverse = 0;
		while(n!=0) {
			int i = n%10;
			int newreverse = reverse*10 + i;
			if((newreverse-i)/10!=reverse)
				return 0;
			else reverse = newreverse;
			n=n/10;
		}
		return reverse;
	}

	public static void main(String[] args) {
		System.out.println(reverse(1994236499));
	}

}
