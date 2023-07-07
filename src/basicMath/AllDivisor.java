package basicMath;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AllDivisor {
	
	static List<Integer> divisor(int n){
		Set<Integer> set = new HashSet<>();
		int root = (int) Math.pow(n, 0.5);
		set.add(1);
		set.add(n);
		for(int i=2;i<=root;i++) {
			if(n%i==0) {
				set.add(i);
				set.add(n/i);
			}
		}
		
		return new ArrayList<>(set);
	}

	public static void main(String[] args) {
			System.out.println(divisor(42));

	}

}
