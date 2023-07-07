package Recusrsion;

public class SudokuSolverLEET37 {
	
	public static void solveSudoku(char[][] board) {
		char[][] copyBoard = new char[board.length][board[0].length];
        for(int i =0;i<9;i++) {
        	for(int j=0;j<9;j++) {
        		copyBoard[i][j] = board[i][j];
        	}
        }
        
        
        solveSudokuRecur(board, copyBoard, 0, 0);
        
    }

	private static void solveSudokuRecur(char[][] board, char[][] copyBoard, int row, int column) {
		
		if(column == 9) {
			System.out.println("column processed " + row);
			row = row +1;
			column = 0;
		}
		
		
		if(row == 9) {
			copyAns(board, copyBoard);
			return;
		}
		
		if(copyBoard[row][column] == '.') {
			for(int i=1;i<=9;i++) {
				if(safeToPut(copyBoard, row, column, i)) {
					copyBoard[row][column] = Character.forDigit(i, 10);
					solveSudokuRecur(board, copyBoard, row, column+1);
					copyBoard[row][column] = '.';
				}
			}
			
		}else {
			solveSudokuRecur(board, copyBoard, row, column+1);
		}
		
		
	}

	private static boolean safeToPut(char[][] copyBoard, int row, int column, int i) {
		for(int j=0;j<9;j++) {
			if(copyBoard[row][j] == Character.forDigit(i, 10)) {
				return false;
			}
		}
		
		for(int j=0;j<9;j++) {
			if(copyBoard[j][column] == Character.forDigit(i, 10)) {
				return false;
			}
		}
		
		if(row <=2 && column <=2) {
			for(int j=0;j<=2;j++) {
				for(int k=0;k<=2;k++) {
					if(copyBoard[j][k] == Character.forDigit(i, 10))
						return false;
				}
			}
			
		}else if(row <=2 && column <=5) {
			for(int j=0;j<=2;j++) {
				for(int k=3;k<=5;k++) {
					if(copyBoard[j][k] == Character.forDigit(i, 10))
						return false;
				}
			}
			
		}else if(row <=2 && column <=8) {
			for(int j=0;j<=2;j++) {
				for(int k=6;k<=8;k++) {
					if(copyBoard[j][k] == Character.forDigit(i, 10))
						return false;
				}
			}
		}else if(row <=5 && column <=2) {
			for(int j=3;j<=5;j++) {
				for(int k=0;k<=2;k++) {
					if(copyBoard[j][k] ==Character.forDigit(i, 10))
						return false;
				}
			}
		}else if(row <=5 && column <=5) {
			for(int j=3;j<=5;j++) {
				for(int k=3;k<=5;k++) {
					if(copyBoard[j][k] == Character.forDigit(i, 10))
						return false;
				}
			}
		}else if(row <=5 && column <=8) {
			for(int j=3;j<=5;j++) {
				for(int k=6;k<=8;k++) {
					if(copyBoard[j][k] == Character.forDigit(i, 10))
						return false;
				}
			}
		}else if(row <=8 && column <=2) {
			for(int j=6;j<=8;j++) {
				for(int k=0;k<=2;k++) {
					if(copyBoard[j][k] == Character.forDigit(i, 10))
						return false;
				}
			}
		}else if(row <=8 && column <=5) {
			for(int j=6;j<=8;j++) {
				for(int k=3;k<=5;k++) {
					if(copyBoard[j][k] == Character.forDigit(i, 10))
						return false;
				}
			}
		}else if(row <=8 && column <=8) {
			for(int j=6;j<=8;j++) {
				for(int k=6;k<=8;k++) {
					if(copyBoard[j][k] == Character.forDigit(i, 10))
						return false;
				}
			}
		}
		
		return true;
	}

	private static void copyAns(char[][] board, char[][] copyBoard) {
		for(int i =0;i<9;i++) {
        	for(int j=0;j<9;j++) {
        		board[i][j] = copyBoard[i][j];
        	}
        }
		
	}

	public static void main(String[] args) {
		char[][] board = {{'5','3','.','.','7','.','.','.','.'},
						{'6','.','.','1','9','5','.','.','.'},
						{'.','9','8','.','.','.','.','6','.'},
						{'8','.','.','.','6','.','.','.','3'},
						{'4','.','.','8','.','3','.','.','1'},
						{'7','.','.','.','2','.','.','.','6'},
						{'.','6','.','.','.','.','2','8','.'},
						{'.','.','.','4','1','9','.','.','5'},
						{'.','.','.','.','8','.','.','7','9'}};
		solveSudoku(board);
		System.out.println("solved");

	}

}
