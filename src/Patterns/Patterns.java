package Patterns;

public class Patterns {
	
//	*****
//	*****
//	*****
//	*****
//	*****
	static void pattern1(int n) {
		for(int i = 1;i<=n;i++) {
			for(int j=1;j<=n;j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
//	*
//	**
//	***
	static void pattern2(int n) {
		for(int i = 1;i<=n;i++) {
			for(int j=1;j<=i;j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
//	1
//	12
//	123
	static void pattern3(int n) {
		for(int i = 1;i<=n;i++) {
			for(int j=1;j<=i;j++) {
				System.out.print(j);
			}
			System.out.println();
		}
	}
	
//	1
//	22
//	333
	static void pattern4(int n) {
		for(int i = 1;i<=n;i++) {
			for(int j=1;j<=i;j++) {
				System.out.print(i);
			}
			System.out.println();
		}
	}
	
//	***
//	**
//	*
	static void pattern5(int n) {
		for(int i = 5;i>=1;i--) {
			for(int j=1;j<=i;j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
//	123
//	12
//	1
	static void pattern6(int n) {
		for(int i = 5;i>=1;i--) {
			for(int j=1;j<=i;j++) {
				System.out.print(j);
			}
			System.out.println();
		}
	}
//	  *
//   ***
//  *****
	static void pattern7(int n) {
		int count = 0;
		for(int i = 5;i>=1;i--) {
			for(int j=1;j<=i;j++) {
				System.out.print(" ");
			}
			for(int k=1;k<=(1+(count)*2);k++) {
				System.out.print("*");
			}
			count++;
			System.out.println();
		}
	}
//	*****
//	 ***
//	  *
	
	static void pattern8(int n) {
		int count = n-1;
		for(int i = 1;i<=n;i++) {
			for(int j=1;j<=i;j++) {
				System.out.print(" ");
			}
			for(int k=(1 + count*(2));k>=1;k--) {
				System.out.print("*");
			}
			count--;
			System.out.println();
		}
	}
	
//	1
//	01
//	101
	static void pattern9(int n) {
		for(int i = 1;i<=n;i++) {
			for(int j=1;j<=i;j++) {
				if(i==1)
					System.out.print(j);
				else {
					if(i%2!=0)
						System.out.print(j%2);
					else
						System.out.print((j+1)%2);
				}
			}
			System.out.println();
		}
	}
//	1      1
//	12    21
//	123  321
//	12344321
	
	static void pattern10(int n) {
		for(int i = 1;i<=n;i++) {
			for(int j=1;j<=i;j++) {
				System.out.print(j);
			}
			for(int k=1;k<=(n-i)*2;k++) {
				System.out.print(" ");
			}
			for(int l=i;l>=1;l--) {
				System.out.print(l);
			}
			System.out.println();
		}
	}
	
//	1
//	23
//	456
//	78910
	static void pattern11(int n) {
		int count = 1;
		for(int i = 1;i<=n;i++) {
			for(int j=1;j<=i;j++) {
				System.out.print(count++ + " ");
			}
			System.out.println();
		}
	}
//	A
//	AB
//	ABC
	static void pattern12(int n) {
		for(int i = 1;i<=n;i++) {
			for(int j=1;j<=i;j++) {
				System.out.print(Character.toChars(64 + j));
			}
			System.out.println();
		}
	}
	
//	  1
//	 121
//	12321
	static void pattern13(int n) {
		for(int i = 1;i<=n;i++) {
			for(int j=n;j>=i;j--) {
				System.out.print(" ");
			}
			for(int k=1;k<=i;k++) {
				System.out.print(Character.toChars(64 + k));
			}
			for(int l=i-1;l>=1;l--) {
				System.out.print(Character.toChars(64 + l));
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		
		//pattern1(5);
		
		//pattern2(5);
		
		//pattern3(5);
		
		//pattern4(5);
		
		//pattern5(5);
//		pattern7(5);
//		pattern8(5);
		
		
		//pattern2(4);
		//pattern13(10);
		//System.out.println(Character.toChars(65));
		
		StringBuilder s = new StringBuilder("abc");
		s.setCharAt(1, 'k');
		System.out.println(s);
		

	}

}
