package Recusrsion;

import java.util.ArrayList;
import java.util.List;

public class NQueenPractice {
	
	static List<List<String>> solveNQueens(int n) {
		
		List<List<String>> ans = new ArrayList<>();
		List<String> cur = new ArrayList<>();
		boolean[][] placed = new boolean[n][n];
		
		NQueenRecur(n, n,0, 0, cur, ans, placed);
		return ans;
	}

	private static void NQueenRecur(int n, int qr, int row, int column, List<String> cur, List<List<String>> ans, boolean[][] placed) {
		
		if(qr == 0) {
			ans.add(new ArrayList<>(cur));
			return;
		}
		
		if(column == n) {
			row = row + 1;
			column = 0;
		}
		
		if(row == n) {
			return;
		}
		if(safe(row,column, placed)) {
			cur.add(placeString(row,column,placed));
			placed[row][column] = true;
			NQueenRecur(n, qr-1, row, column+1, cur, ans, placed);
			placed[row][column] = false;
			cur.remove(cur.size()-1);
		}
		NQueenRecur(n, qr, row, column+1, cur, ans, placed);
		
	}

	private static String placeString(int row, int column, boolean[][] placed) {
		String s = "";
		for(int i=0;i<placed[0].length;i++) {
			if(placed[row][i] == true || i == column)
				s = s + 'Q';
			else
				s = s + '.';
		}
		
		return s;
	}

	private static boolean safe(int row, int column, boolean[][] placed) {
		int i = row;
		int j = column-1;
		while(j>=0) {
			if(placed[i][j] == true)
				return false;
			j--;
		}
		
		i = row-1;
		j = column;
		while(i>=0) {
			if(placed[i][j] == true)
				return false;
			i--;
		}
		
		i = row-1;
		j = column-1;
		while(i>=0 && j>=0) {
			if(placed[i][j] == true)
				return false;
			i--;
			j--;
		}
		
		i = row-1;
		j = column+1;
		while(i>=0 && j<placed[0].length) {
			if(placed[i][j] == true)
				return false;
			i--;
			j++;
		}
		
		return true;
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		solveNQueens(4);

	}

}
