package backtracking;

public class LEET1219GoldMine {
	
	public static int getMaximumGold(int[][] grid) {
		
		if(grid.length==0 && grid[0].length==0)
			return 0;
		
		
		int maxGoldGlobal = Integer.MIN_VALUE;
		
        for(int i=0;i<grid.length;i++) {
        	for(int j=0;j<grid[0].length;j++) {
        		if(grid[i][j]!=0) {
        			maxGoldGlobal = Math.max(maxGold(grid,i,j,0), maxGoldGlobal);
        		}
        	}
        }
        
        return maxGoldGlobal;
    }

	private static int maxGold(int[][] grid, int row, int column, int gsf) {
		
		if(row<0 || column <0 || row==grid.length || column == grid[0].length) {
			return gsf;
		}
		if(grid[row][column] == 0)
			return gsf;
		
		int currentMax = Integer.MIN_VALUE; //storing current value in variable
		int currentGold = grid[row][column];
		grid[row][column] = 0; // nmarking the grid as zero so that can be visited again for the current iteration
		int m1 = maxGold(grid, row+1, column, gsf+currentGold);
		currentMax = Math.max(currentMax, m1);
		int m2 = maxGold(grid, row-1, column, gsf+currentGold);
		currentMax = Math.max(currentMax, m2);
		int m3 = maxGold(grid, row, column+1, gsf+currentGold);
		currentMax = Math.max(currentMax, m3);
		int m4 = maxGold(grid, row, column-1, gsf+currentGold);
		currentMax = Math.max(currentMax, m4);
		//System.out.println(string);
		grid[row][column] = currentGold;
		return currentMax;
		
		
		
	}

	public static void main(String[] args) {
		int[][] arr= {{1,1,1,1,1},{1,1,1,1,1},{1,1,1,1,1},{1,1,1,1,1},{1,1,1,1,1}};
		System.out.println(getMaximumGold(arr));

	}

}
