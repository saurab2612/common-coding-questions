package Graph;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class FloodFill {
	
	public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
		int size = image.length * image[0].length;
		LinkedList<Integer>[] adj = new LinkedList[size];
		for(int i=0;i<size;i++) {
			adj[i] = new LinkedList<>();
		}
		ArrayList<Integer> ans = new ArrayList<>();
		int[][] ansArr = image;
        for(int i=0;i<image.length;i++) {
        	for(int j=0;j<image[0].length;j++) {
        		addToGraph(image,i,j,adj);
        	}
        }
        
        int source = (image[0].length)*sr + sc;
        ans = bfs(adj,source,ans,size);
        
        for(int i=0;i<size;i++) {
        	int x = i/(image[0].length); // check again
        	int y = i%(image[0].length);
        	if(ans.contains(i)) {
        		ansArr[x][y] = newColor;
        	}
        }
        
        return ansArr;
        
    }

	private static ArrayList<Integer> bfs(LinkedList<Integer>[] adj, int source, ArrayList<Integer> ans, int size) {
		boolean[] vis = new boolean[size];
		Queue<Integer> q = new LinkedList<>();
		
		q.add(source);
		vis[source] = true;
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			ans.add(cur);
			for(int i: adj[cur]) {
				if(!vis[i]){
					vis[i] = true;
					q.add(i);
				}
			}
		}
		return ans;
	}

	private static void addToGraph(int[][] image, int i, int j, LinkedList<Integer>[] adj) {
		int node = image[0].length*i + j;
		if(isValid(i+1,j, image)) {
			if(image[i][j] == image[i+1][j])
				adj[node].add(image[0].length*(i+1) + j);
		}
		if(isValid(i-1,j, image)) {
			if(image[i][j] == image[i-1][j])
				adj[node].add(image[0].length*(i-1) + j);
		}
		if(isValid(i,j+1, image)) {
			if(image[i][j] == image[i][j+1])
				adj[node].add(image[0].length*i + (j+1));
		}
		if(isValid(i,j-1, image)) {
			if(image[i][j] == image[i][j-1])
				adj[node].add(image[0].length*i + (j-1));
		}
	}

	private static boolean isValid(int i, int j, int[][] image) {
		if(i<0 || j<0 || i>image.length-1 || j>image[0].length-1)
			return false;
		return true;
	}
	
	
	
	
	
	
//	public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
//        solve(image, sr, sc, newColor, image[sr][sc]);
//        return image;
//    }
//    
//    public void solve(int[][] grid, int i, int j, int newColor, int oldColor){
//        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] != oldColor){
//            return;
//        }
//        
//        if(grid[i][j] == newColor) return;
//        
//        grid[i][j] = newColor;
//        solve(grid, i-1, j, newColor, oldColor); 
//        solve(grid, i, j-1, newColor, oldColor); 
//        solve(grid, i, j+1, newColor, oldColor); 
//        solve(grid, i+1, j, newColor, oldColor); 
//    }
	
	public static int[][] floodFill1(int[][] image, int sr, int sc, int color) {
		int k = image[sr][sc];
		dfs(image,sr,sc,color,k);
        return image;
    }

	private static void dfs(int[][] image, int sr, int sc, int color, int k) {
		if(sr<0 || sc<0 || sr>=image.length || sc>=image[0].length)
			return;
		if(image[sr][sc]!=k || image[sr][sc] == color)
			return;
		image[sr][sc] = color;
		dfs(image,sr+1,sc,color,k);
		dfs(image,sr-1,sc,color,k);
		dfs(image,sr,sc+1,color,k);
		dfs(image,sr,sc-1,color,k);
	}

	public static void main(String[] args) {
		//int[][] arr = {{1,1,1},{1,1,0},{1,0,1}};
		int[][] arr = {{0,0,0},{0,0,0}};
		floodFill1(arr, 0,0, 2);
		
		System.out.println(arr);

	}

}
