package Recusrsion;

public class Fibonacci {
	
	public static int fib(int n) {
        //base case
		if(n<=2)
			return n-1;
		
		return fib(n-1) + fib(n-2);
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(fib(5));

	}

}
