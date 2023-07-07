package Graph;

import java.util.ArrayList;
import java.util.List;

public class ConnectedComponents {
	
	static ArrayList<Integer>[] adj = new ArrayList[10];
	
	
	static List<List<Integer>> getConnectedComponent() {
		
		List<List<Integer>> ans = new ArrayList<>();
		boolean visited[] = new boolean[10];
		for(int i=0;i<10;i++) {
			if(!visited[i])
				ans.add(dfs(i, visited, new ArrayList<Integer>()));
		}
		return ans;
	}
	
	
	
	private static List<Integer> dfs(int i , boolean[] visited, ArrayList<Integer> list) {
		
		visited[i] = true;
		list.add(i);
		for(int j: adj[i]) {
			if(!visited[j])
				return dfs(j, visited, list);
		}
		return list;
	}



	static void addEdge(int source, int destination) {
		adj[source].add(destination);
		adj[destination].add(source);
	}
	

	public static void main(String[] args) {
		
		for(int i=0;i<10;i++) {
			adj[i] = new ArrayList<>();
		}
		
		addEdge(0, 1);
		addEdge(0, 2);
		addEdge(1, 2);
		addEdge(3, 4);
		addEdge(4, 5);
		addEdge(6, 7);
		addEdge(6, 8);
		addEdge(8, 9);
		addEdge(7, 9);
		
		getConnectedComponent();

	}

}
