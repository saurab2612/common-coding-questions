package Graph;

import java.util.ArrayList;
import java.util.Stack;

public class DFSLeet {
	
	// Function to return a list containing the DFS traversal of the graph.
    public ArrayList<Integer> dfsOfGraph1(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] vis = new boolean[V];
        Stack<Integer> stack = new Stack<Integer>();
        ArrayList<Integer> ans = new ArrayList<Integer>();
        
        stack.push(0);
        vis[0]=true;
        
        while(!stack.isEmpty()) {
        	int cur = stack.pop();
        	ans.add(cur);
        	for(int i: adj.get(cur)) {
        		if(!vis[i]) {
        			vis[i]=true;
        			stack.add(i);
        		}
        	}
        }
        return ans;
    }
    
    //practice 
 // Function to return a list containing the DFS traversal of the graph.
    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> ans = new ArrayList<>();
        boolean[] vis = new boolean[V];
        for(int i=0;i<V;i++) {
        	if(!vis[i]) {
        		dfs(i, adj, vis, ans);
        	}
        }
        return ans;
    }

	private void dfs(int i, ArrayList<ArrayList<Integer>> adj, boolean[] vis, ArrayList<Integer> ans) {
		
		vis[i] = true;
		ans.add(i);
		for(int k : adj.get(i)) {
			if(!vis[k]) {
				dfs(k, adj, vis, ans);
			}
		}
		
	}

	public static void main(String[] args) {
		

	}

}
