package backtracking;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class RatMaze {
	
	public static ArrayList<String> findPath(int[][] m, int n) {
        ArrayList<String> list = new ArrayList<String>();
		findPathBackTrack(m,n,0,0,"",list);
		Set<String> set = new HashSet<String>(list);
		ArrayList<String> list2 = new ArrayList<String>(set);
		Collections.sort(list2);;
		return list2;
    }

	private static void findPathBackTrack(int[][] m, int size, int row, int column, String result, ArrayList<String> list) {
		if(row == size-1 && column == size-1 && isPossible(m, row, column, size)) {
			System.out.println(result);
			list.add(result);
			return ;
		}
		
		if(isPossible(m,row,column,size)) {
			//do
			m[row][column] = 0;
			//recur
			findPathBackTrack(m, size, row, column+1, result + "R", list);
			findPathBackTrack(m, size, row, column-1, result+ "L", list);
			findPathBackTrack(m, size, row+1, column, result + "D", list);
			findPathBackTrack(m, size, row-1, column, result+ "U", list);
			//undo
			m[row][column] = 1;
		}else {
			return;
		}
		
	}

	private static boolean isPossible(int[][] m, int row, int column, int size) {
		if(row == size || row<0 || column<0 || column ==size) {
			return false;
		}else if(m[row][column] == 0) {
			return false;
		}else {
			return true;
		}
	}

	public static void main(String[] args) {
		int[][] m= {{1, 0, 0, 0},
		         {1, 1, 0, 1}, 
		         {1, 1, 0, 0},
		         {0, 1, 1, 1}};
		findPath(m, 4);

	}

}
