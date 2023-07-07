package Recusrsion;

import java.util.Arrays;

public class UndertandRecursion {
	
	//print string n times
	static void printNTimes(String s, int i) {
		printRecur(i,s);
	}

	private static void printRecur(int i, String s) {
		
		//adding base condition
		if(i==0)
			return;
		
		//doing in prefix order
		System.out.println(s);
		
		//recalling the recursive method
		printRecur(i-1, s);
	}
	
	
	//Print 1-n
	//in here I will be doing the work or printing part in postfix way
	static void print1toN(int N) {
		
		//base condition
		if(N==0)
			return;
		
		//calling in recursive way
		print1toN(N-1);
		//printing in postfix order
		System.out.println(N);
	}
	
	//Print n-1
		//in here I will be doing the work or printing part in prefix way
		static void printNto1(int N) {
			
			//base condition
			if(N==0)
				return;
			
			//printing in prefix order
			System.out.println(N);
			
			//calling in recursive way
			printNto1(N-1);
			
		}
		
		//1-n sum
		static int sum1ton(int n){
			
			if(n==0)
				return 0;
			
			//calculating in postfix way ie-- calling first and then doing work
			int sum = sum1ton(n-1);
			return n + sum;
		}
		
		//factorial
		static int fact(int n) {
			
			if(n==0)
				return 1;
			
			//doing work before iee prefix recur
			return n * fact(n-1);
		}
		
		//reverse an array
		static void reverseArray(int[] arr, int index) {
			
			if(index==arr.length)
				return;
			
			int temp = arr[arr.length-index-1];
			reverseArray(arr, index+1);
			arr[index] = temp;
			
		}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//printNTimes("Saurabh", 5);
		//printNto1(10);
		//System.out.println(sum1ton(5));
		//System.out.println(fact(5));
		
		int[] arr = {5,4,3,2,1};
		reverseArray(arr, 0);
		System.out.println();
	}
	
	

}
