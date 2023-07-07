package Graph;

public class NosIslandLEET200 {
	
	public static int numIslands(char[][] grid) {
		int count = 0;
        for(int i=0;i<grid.length;i++) {
        	for(int j=0;j<grid[0].length;j++) {
        		if(grid[i][j] == '1') {
        			count++;
        			dfs(i,j,grid);
        		}
        	}
        }
        return count;
    }

	private static void dfs(int i, int j, char[][] grid) {
		
		if(grid[i][j] == '0')
			return;
		if(i<0 || j<0 || i==grid.length || j==grid[0].length)
			return;
		
		grid[i][j] = '0';
		dfs(i, j+1, grid);
		dfs(i,j-1, grid);
		dfs(i+1,j,grid);
		dfs(i-1,j,grid);
		
	}

	public static void main(String[] args) {

	}

}
