package Graph;

import java.util.ArrayList;
import java.util.List;

public class KeysAndRoomsLEET841 {
	
	public static boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean visited[] = new boolean[rooms.size()];
        
        dfs(0,visited, rooms);
        for(int i=0;i<rooms.size();i++) {
        	if(!visited[i])
        		return false;
        }
        
        return true;
    }

	private static void dfs(int i, boolean[] visited, List<List<Integer>> rooms) {
		
		visited[i] = true;
		for(int j : rooms.get(i)) {
			if(!visited[j])
				dfs(j, visited, rooms);
		}
		
	}

	public static void main(String[] args) {
		List<List<Integer>> ls = new ArrayList<>();
		

	}

}
