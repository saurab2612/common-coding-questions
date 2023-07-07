package Graph;

import java.util.ArrayList;
//Smallest path, largest path, ceil, floor, kthlargest
public class DFSVariations {
	
	static ArrayList<Integer>[] adj = new ArrayList[7];
	static Integer pL=0;
	static Integer sL=Integer.MAX_VALUE;
	static Integer mL=Integer.MIN_VALUE;
	
	public static void printGraphVariation(ArrayList<Integer>[] adj, int source, int destination) {
		
		
		boolean[] visited = new boolean[adj.length];
		dfs(source,destination,visited,pL);
		System.out.println("Smallest Path Length: " + sL) ;
		System.out.println("Largest Path length: " + mL) ;
		
	}

	private static void dfs(int source, int destination, boolean[] visited, int pL) {
		if(source == destination) {
			if(pL<sL)
				sL=pL;
			if(pL>mL)
				mL=pL;
			return;
		}
		visited[source] = true;
		//pL++;
		for(int i : adj[source]) {
			if(!visited[i]) {
				dfs(i, destination, visited, pL+1);
			}
		}
		visited[source] = false;
		//pL--;
		
	}

	public static void main(String[] args) {
		for(int i=0;i<adj.length;i++) {
			adj[i] = new ArrayList<>();
		}
		
		addEdge(0, 1);
		addEdge(0, 3);
		addEdge(1, 2);
		addEdge(2, 3);
		addEdge(3, 4);
		addEdge(4, 5);
		addEdge(4, 6);
		addEdge(5, 6);
		
		printGraphVariation(adj, 0, 6);

	}
	
	static void addEdge(int source, int destination) {
		adj[source].add(destination);
		adj[destination].add(source);
	}
	
	
	
	

}
