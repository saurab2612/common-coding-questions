package Graph;

import java.util.LinkedList;
import java.util.Queue;

public class Graph {
	
	private LinkedList<Integer>[] adj;
	public Graph(int V) {
		adj = new LinkedList[5];
		for(int i=0;i<V;i++) {
			adj[i] = new LinkedList<>();
		}
	}
	public void addEdge(int source,int destination) {
		adj[source].add(destination);
		adj[destination].add(source);
	}
	
	public int bfs(int source, int destination) {
		boolean[] vis = new boolean[adj.length];
		int[] parent = new int[adj.length];
		Queue<Integer> queue = new LinkedList<>();
		
		queue.add(source);
		parent[source] = -1;
		vis[source] = true;
		
		while(!queue.isEmpty()) {
			int cur = queue.poll();
			if(cur == destination) break;
			
			for(int neighbour: adj[cur]) {
				 if(!vis[neighbour]) {
					 vis[neighbour] = true;
					 queue.add(neighbour);
					 parent[neighbour]= cur;
				 }
			}
		}
		
		int cur = destination;
		int distance =0;
		while(parent[cur]!=-1) {
			System.out.println("Cur -> " + cur);
			cur = parent[cur];
			distance ++;
		}
		
		return distance;
		 
	}
	
	public boolean dfs(int source, int destination , boolean[] vis) {
		if(source == destination) return true;
		for(int neighbour : adj[source]) {
			if(!vis[neighbour]) {
				vis[neighbour] = true;
				 boolean isConnected = dfs(neighbour,destination,vis);
				 if(isConnected) return true;
			}
		}
		return false;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
