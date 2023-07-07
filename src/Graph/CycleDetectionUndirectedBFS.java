package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class CycleDetectionUndirectedBFS {
	
	static class Pair{
		int first;
		int second;
		Pair(int a, int b){
			first = a;
			second = b;
		}
	}
	
	public static boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        Queue<Pair> q = new LinkedList<>();
        boolean[] vis = new boolean[V];
        
        for(int i=0;i<V;i++) {
        	if(!vis[i]) {
        		if(isCycleBFS(adj, vis, i, q)) {
        			return true;
        		}
        	}
        }
        return false;
        
    }

	private static boolean isCycleBFS(ArrayList<ArrayList<Integer>> adj, boolean[] vis, int i, Queue<Pair> q) {
		
		q.add(new Pair(i, -1));
		vis[i] = true;
		while(!q.isEmpty()) {
			Pair p = q.poll();
			for(int k : adj.get(p.first)) {
				if(!vis[k])
					q.add(new Pair(k, p.first));
				else if(vis[k] && k == p.second){
					return true;
				}
			}
		}
		return false;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
