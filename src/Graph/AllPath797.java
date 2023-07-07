package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class AllPath797 {
	
	public static List<List<Integer>> allPathsSourceTarget(int[][] graph) {
		int vertices = graph.length;
		boolean[] visited = new boolean[vertices];
		List<List<Integer>> ans = new LinkedList<List<Integer>>();
		List<Integer> list = new LinkedList<>();
		printAllPath(graph, 0, vertices-1, visited, ans ,list);
		return ans;
        
    }

	private static void printAllPath(int[][] graph, int source, int destination, boolean[] visited, List<List<Integer>> ans, List<Integer> list) {
		if(source == destination) {
			list.add(source);
			
			ans.add(new ArrayList<>(list));
			list.remove(list.size()-1);
			return;
		}
		visited[source] = true;
		list.add(source);
		for(int i :graph[source]) {
			if(!visited[i])
				printAllPath(graph, i, destination, visited, ans, list);
		}
		visited[source] = false;
		list.remove(list.size()-1);
	}

	public static void main(String[] args) {
		int[][] arr = {{1,2},{3},{3},{}};
		for (List<Integer> is : allPathsSourceTarget(arr)) {
			for (int is2 : is) {
				System.out.println(is2);
			}
			System.out.println();
		}

	}

}
