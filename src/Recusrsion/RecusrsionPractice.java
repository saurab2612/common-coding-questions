package Recusrsion;

import java.util.ArrayList;
import java.util.List;

import javax.print.attribute.standard.PrinterName;

public class RecusrsionPractice {
	
	static int count =1;
	
	
	public static void printName(String s) {
		if(count ==6)
			return;
		count++;
		System.out.println(s);
		printName(s);
		
	}
	
	
	public static void printLinerarly(int n) {
		if(n==10)
			return;
		System.out.println(n);
		printLinerarly(n+1);
			
	}
	
	public static void printReverse(int n) {
		if(n==10)
			return;
		printReverse(n+1);
		System.out.println(n);
	}
	
	public static int sum(int n, int result) {
		if(n==0) {
			return result;
		}
		
		result = result + n;
		int ans = sum(n-1, result);
		return ans;
	}
	//functional way
	public static int factFunc(int n) {
		if(n==1)
			return 1;
		return n * factFunc(n-1);
	}
	
	//parameterizedway
	public static void factParam(int n, int ans) {
		if(n==1) {
			System.out.println(ans);
			return;
		}
	//	ans = ans * n;
		factParam(n-1, ans*n);
	}
	
	//parameterizedway
	public static void reverseArrayParam(int[] arr, int n, int[] ans, int size) {
		if(n==0)
			return;
		reverseArrayParam(arr, n-1, ans, size);
		ans[n-1] = arr[size-n];
	}
	
	public static void reverseArrayMethod2(int[] arr, int n) {
		if(n==(arr.length-1)/2)
			return;
		int temp = arr[n-1];
		reverseArrayMethod2(arr, n-1);
		arr[n-1] = arr[arr.length-n] ;
		arr[arr.length-n] = temp;
		
					
	}
	
	//
//	public static void reverseArraySinglePointer(int[] arr, int ) {
//		
//	}
	
	
	public static boolean checkPalindrome(int arr[], int l, int r) {
		if(l>=r) {
			return true;
		}
		if(arr[l] != arr[r])
			return false;
		return checkPalindrome(arr, l+1, r-1);
	}
	
	// void way of doing things
	public static void subsequencePrint(String str, String result, int n) {
		if(n==str.length()) { //base case if all letters covered print it and return.
			System.out.println(result);
			return;
		}
		subsequencePrint(str, result+str.charAt(n), n+1);
		subsequencePrint(str, result, n+1);
	}
	
	//naking 2 recursion calls
	public static List<String> subsequenceList(String str, String result, int n, List<String>  ls) {
		if(n==str.length()) { //base case if all letters covered add it to the list when base case is reached
			System.out.println(result);
			ls.add(result);
			return ls;
		}
		List<String> ls1 =  subsequenceList(str, result+str.charAt(n), n+1, ls);
		List<String> ls2 =  subsequenceList(str, result, n+1, ls); // although im catching two diff lists but still they will have same item co
		//z no new list is being created.
		return ls2;
	}
	
	//making just a single call in recursion while printing subsequence
	//TODO : later on if you get time, solve sum k using this also.
	public static List<String> subsequenceListM2(String str, int n, List<String>  ls) {
		if(n==0) { //base case if all letters covered add it to the list when base case is reached
			List<String> s = new ArrayList<>();
			s.add("");
			return s;
		}
		List<String> ls1 = subsequenceListM2(str, n-1, ls);
		List<String> ls2 = new ArrayList<>();
		for(String s : ls1) {
			ls2.add(s+str.charAt(n-1)); 
		}
		for(String s : ls1) {
			ls2.add(s); 
		}
		return ls2;
	}
	
	
	//printing susequences with sum k
	public static List<String> subsequenceSumK(int[] arr, int n, int sum, List<String> list, String s, int k){
		if(n==arr.length) {
			if(sum == k)
				list.add(s);
			return list;
		}
		
		subsequenceSumK(arr, n+1, sum + arr[n], list, s + arr[n], k);
		subsequenceSumK(arr, n+1, sum, list, s, k);
		
		return list;
	}
	
	
	/*
	 * print one as if rat mazr problem once you found one dont continue
	 * doing it specificaly that way to get comferatble with backtracking
	 */
	public static boolean subsequenceSumKPrintOne(int[] arr, int index, int sum, int k, String res){
		if(index == arr.length) {
			if(sum == k) {
				System.out.println(res);
				return true;
			}else {
				return false;
			}
		}
		if(subsequenceSumKPrintOne(arr, index+1, sum + arr[index], k, res + arr[index])) {
			return true;
		}
		if(subsequenceSumKPrintOne(arr, index+1, sum, k, res)) {
			return true;
		}
		
		return false;
	}
	
	//print count
	public static int subsequenceSumKCount(int[] arr, int sum, int k, int index){
		if(arr.length == index) {
			if(sum == k) {
				return 1;
			}else
				return 0;
		}
		return subsequenceSumKCount(arr, sum + arr[index], k, index+1) + subsequenceSumKCount(arr, sum, k, index+1);
	}
	
	//141 and 411 not allowed, will print all subsequence or say subset ie.. without repitition - NOT DONE YET
	public static void subsequecePrint2(String s, String res, int ind) {
		if(ind == s.length()) {
			System.out.println(res);
			return;
		}
		
		for(int i=ind;i<s.length();i++) {
			if(i>ind && s.charAt(i)==s.charAt(i-1)) {
				continue;
			}
			
			subsequecePrint2(s, res + s.charAt(i), i+1);
			//subsequecePrint2(s, res, i+1);
		}
	}

	public static void main(String[] args) {
//		printName("Saurabh");
//		printLinerarly(0);
//		printReverse(0);
		
		//System.out.println(factFunc(4));
		//factParam(4, 1);
		
//		int[] arr = {1,2,3,3,1};
////		int[] ans = new int[5];
////		reverseArrayMethod2(arr, 5);
////		System.out.println(arr);
//		//System.out.println(checkPalindrome(arr, 0, arr.length-1));
//		List<String> ls = new ArrayList<>();
//		//List<String> ls3 = subsequenceListM2("abc",3, ls);
//		
//		
//		System.out.println(subsequenceSumKCount(arr, 0, 10, 0));
//		System.out.println("_____________");
		
		
		subsequecePrint2("1223", "", 0); 

	}

}
