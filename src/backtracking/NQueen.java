package backtracking;

import java.util.ArrayList;

public class NQueen {
	
	static ArrayList<ArrayList<Integer>> nQueen(int n) {
		
		boolean[][] mat = new boolean[n][n];
		ArrayList<ArrayList<Integer>> list = new ArrayList<>();
		String result = "";
		list = nQueenBackTracking(mat,0,0,n,0,list, result);
		
        return list;
    }

	private static ArrayList<ArrayList<Integer>> nQueenBackTracking(boolean[][] board, int row, int column, int tq, int tqp,
			ArrayList<ArrayList<Integer>> list, String result) {
		
		if(tq == tqp) {
			list.add(null);
			System.out.println(result);
			return null;
		}
		
		if(column == board[0].length) {
			column = 0;
			row = row+1;
		}
		
		if(row == board.length) {
			return null;
		}
			
		
		
		if(isItSafeToPlace(board,row,column)) {
			//do
			board[row][column] = true;
			//recur
			nQueenBackTracking(board, row, column+1, tq, tqp+1, list, result + "[(" +row+","+column+")]");
			
			//undo
			board[row][column] = false;
		}
		
		nQueenBackTracking(board, row, column+1, tq, tqp, list, result);
		
		return null;
	}

	private static boolean isItSafeToPlace(boolean[][] board, int row, int column) {
		//check vertically
		int i;
		int j;
		i = row-1;
		j = column;
		while(i>=0) {
			if(board[i][j] == true)
				return false;
			i--;
		}
		//check horizontally
		i=row;
		j=column-1;
		while(j>=0) {
			if(board[i][j] == true)
				return false;
			j--;
		}
		
		//check right verticaly
		i=row-1;
		j=column+1;
		while(i>=0 && j<board[0].length) {
			if(board[i][j] == true)
				return false;
			j++;
			i--;
			
		}
		
		//check left vertically
		i=row-1;
		j=column-1;
		while(i>=0 && j>=0) {
			if(board[i][j] == true)
				return false;
			j--;
			i--;
		}
		return true;
	}

	public static void main(String[] args) {
		nQueen(3);
	}

}
