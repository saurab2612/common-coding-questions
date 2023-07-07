package BinaryTree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.stream.Collectors;

public class AllNodesDistanceKLEET863 {
	
	public static List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> ans = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        if(root == null)
        	return ans;
        Map<TreeNode, TreeNode> map = new HashMap<>();
        q.add(root);
        while(!q.isEmpty()) {
        	TreeNode n = q.poll();
        	if(n.left!=null) {
        		map.put(n.left, n);
        		q.add(n.left);
        	}
        	if(n.right!=null) {
        		map.put(n.right, n);
        		q.add(n.right);
        	}
        }
        
        Set<TreeNode> visited = new HashSet<TreeNode>();
        q.add(target);
        int distance = 0;
        while(!q.isEmpty() && k >0) {
        	distance = distance + 1;
        	int size = q.size();
        	for(int i=0;i<size;i++) {
        		TreeNode n = q.poll();
        		visited.add(n);
        		if(n.left!=null && !visited.contains(n.left))
        			q.add(n.left);
        		if(n.right!=null && !visited.contains(n.right))
        			q.add(n.right);
        		if(map.containsKey(n) && !visited.contains(map.get(n)))
        			q.add(map.get(n));
        	}
        	
        	if(distance==k) {
        		break;
        	}
        	
        }
        
       return q.stream().map(i->i.val).collect(Collectors.toList());
    }
	
	public static void main(String[] args) {
//		TreeNode root = new TreeNode(3);
//		root.left = new TreeNode(5);
//		root.right = new TreeNode(1);
//		root.left.left = new TreeNode(6);
//		root.left.right = new TreeNode(2);
//		root.left.right.left = new TreeNode(7);
//		root.left.right.right = new TreeNode(4);
//		root.right.left = new TreeNode(0);
//		root.right.right = new TreeNode(8);
		
		TreeNode root = new TreeNode(0);
		root.left = new TreeNode(1);
		root.left.right = new TreeNode(2);
		root.left.right.right = new TreeNode(3);
		root.left.right.right.right = new TreeNode(4);
		
		
		
		
		List<Integer> l = distanceK(root, root.left.right.right, 0);
		System.out.println(l);
	}
}
