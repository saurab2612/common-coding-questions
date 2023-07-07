package Recusrsion;

public class PrintStairPath {
	
	public static void printStairPath(int level, String ans) {
		
		if(level == 0) {
			System.out.println(ans);return;
		}
		if(level<0) {
			return;
		}
		
		printStairPath(level-1, 1 + ans);
		printStairPath(level-2, 2+ ans);
		printStairPath(level-3, 3+ ans);
	}

	public static void main(String[] args) {
		printStairPath(3, "");
	}

}
