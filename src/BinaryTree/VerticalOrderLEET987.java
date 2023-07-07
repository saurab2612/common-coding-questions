package BinaryTree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.TreeMap;

public class VerticalOrderLEET987 {
	
	static class NPair implements Comparable<NPair>{
		int first;
		int second;
		public NPair(int first, int second) {
			super();
			this.first = first;
			this.second = second;
		}
		@Override
		public int hashCode() {
			return Objects.hash(first, second);
		}
		@Override
		public boolean equals(Object obj) {
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			NPair other = (NPair) obj;
			return first == other.first && second == other.second;
		}
		@Override
		public int compareTo(NPair o) {
			if(o.second != this.second) {
				if(o.second - this.second > 0)
					return -1;
				else
					return 1;
			}else {
				if(o.first - this.first > 0)
					return -1;
				if(o.first - this.first < 0)
					return 1;
				else
					return 0;
			}
		}
		
		
	}
	
	
	
	public static List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<NPair, List<Integer>> map = new TreeMap<>();
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        verticalTraversalRecur(root, 0, 0, map);
        int nValue = map.firstEntry().getKey().second;
        for(NPair n :map.keySet()) {
        	if(n.second==nValue) {
        		List<Integer> l = map.get(n);
            	Collections.sort(l);
            	cur.addAll(l);
        	}else {
        		ans.add(new ArrayList<>(cur));
        		cur = new ArrayList<>();
        		List<Integer> l = map.get(n);
            	Collections.sort(l);
            	cur.addAll(l);
            	nValue=n.second;
        	}
        }
        ans.add(new ArrayList<>(cur));
        return ans;
    }

	private static void verticalTraversalRecur(TreeNode root, int row, int column, TreeMap<NPair, List<Integer>> map) {
		if(root == null)
			return;
		NPair key = new NPair(row, column);
		if(map.containsKey(key)) {
			map.get(key).add(root.val);
		}else {
			map.put(key, new ArrayList<>());
			map.get(key).add(root.val);
		}
		
		verticalTraversalRecur(root.left, row+1, column-1, map);
		verticalTraversalRecur(root.right, row+1, column+1, map);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(7);
		verticalTraversal(root);
	}

}
