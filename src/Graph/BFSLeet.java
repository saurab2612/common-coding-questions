package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFSLeet {
	
	// Function to return Breadth First Traversal of given graph.
    public static ArrayList<Integer> bfsOfGraph1(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] vis = new boolean[V];
        Queue<Integer> q = new LinkedList<Integer>();
        ArrayList<Integer> ans = new ArrayList<Integer>();
        
        q.add(0);
        vis[0] = true;
        while(!q.isEmpty()) {
        	int cur = q.poll();
        	ans.add(cur);
        	for(int i=0;i<adj.get(cur).size();i++) {
        		if(!vis[adj.get(cur).get(i)]) {
        			vis[adj.get(cur).get(i)]=true;
        			q.add(adj.get(cur).get(i));
        		}
        	}
        	
        }
        return ans;
    }
    
    
    //PRactice 2 
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> ans = new ArrayList<>();
        boolean[] vis = new boolean[V];
        for(int i=0;i<V;i++) {
        	if(!vis[i]) {
        		BFS(i, vis, adj, ans);
        	}
        }
        return ans;
    }

	private void BFS(int i, boolean[] vis, ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> ans) {
		
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(i);
		vis[i] = true;
		while(!q.isEmpty()) {
			int k = q.poll();
			ans.add(k);
			for(int n : adj.get(k)) {
				if(!vis[n]) {
					vis[n] = true;
					q.add(n);
				}
			}
		}
		
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean[] vis = new boolean[5];
		System.out.println(vis[0]);

	}

}
