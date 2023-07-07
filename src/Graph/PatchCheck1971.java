package Graph;

import java.util.ArrayList;

public class PatchCheck1971 {
	
	public static boolean validPath(int n, int[][] edges, int source, int destination) {
		ArrayList<Integer>[] adj = new ArrayList[n];
		for(int i=0;i<n;i++) {
			adj[i] = new ArrayList<>();
		}
		
		for(int i =0;i<edges.length;i++) {
			int one = edges[i][0];
			int two = edges[i][1];
			
			adj[one].add(two);
			adj[two].add(one);
		}
		
		boolean[] visited = new boolean[n];
		return dfs(adj,source,destination,visited);
	}

	private static boolean dfs(ArrayList<Integer>[] adj, int source, int destination, boolean[] visited) {
		if(source == destination)
			return true;
		visited[source] = true;
		for(int i : adj[source]) {
			if(!visited[i]) {
				if(dfs(adj, i, destination, visited))
					return true;
			}
		}
		return false;
		
	}

	public static void main(String[] args) {
		
		
	int[][]	arr = {{4,3},{1,4},{4,8},{1,7},{6,4},{4,2},{7,4},{4,0},{0,9},{5,4}};
		
		
		
		System.out.println(validPath(10, arr, 5, 9));

	}

}
