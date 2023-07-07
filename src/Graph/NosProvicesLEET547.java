package Graph;

public class NosProvicesLEET547 {
	
	public static int findCircleNum(int[][] isConnected) {
        int count = 0;
		for(int i=0;i<isConnected.length;i++) {
			for(int j=0;j<isConnected[0].length;j++) {
				if(isConnected[i][j] == 1) {
					count++;
					dfs(isConnected, i, j);
				}
			}
		}
		return count;
    }

	private static void dfs(int[][] isConnected, int i, int j) {
		
		if(i<0 || j<0 || i==isConnected.length || j==isConnected[0].length)
			return;
		if(isConnected[i][j]==0)
			return;
		
		isConnected[i][j] = 0;
		dfs(isConnected, i+1, j);
		dfs(isConnected, i-1, j);
		dfs(isConnected, i, j+1);
		dfs(isConnected, i, j-1);
	}

	public static void main(String[] args) {
		
	}

}
