package BinaryTree;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class BurningTree {
	
	public static int minTime(Node root, int target) 
    {
        Queue<Node> q = new LinkedList<>();
        if(root == null)
        	return 0;
        Map<Node, Node> map = new HashMap<>();
        q.add(root);
        while(!q.isEmpty()) {
        	Node n = q.poll();
        	if(n.left!=null) {
        		map.put(n.left, n);
        		q.add(n.left);
        	}
        	if(n.right!=null) {
        		map.put(n.right, n);
        		q.add(n.right);
        	}
        }
        
        Node k = find(root, target);
        
        
        Set<Node> visited = new HashSet<Node>();
        q.add(k);
        int count =0;
        while(!q.isEmpty()) {
        	count = count +1;
        	int size = q.size();
        	for(int i =0;i<size;i++) {
        		Node n = q.poll();
        		visited.add(n);
        		if(n.left!=null && !visited.contains(n.left)) {
        			q.add(n.left);
        		}
        		if(n.right!=null && !visited.contains(n.right)) {
        			q.add(n.right);
        		}
        		if(map.containsKey(n) && !visited.contains(map.get(n))) {
        			q.add(map.get(n));
        		}
        	}
        }
        
        return count-1;
    }

	private static Node find(Node root, int target) {
		if(root == null) {
			return null;
		}
		
		if(root.data == target)
			return root;
		Node k = find(root.left, target);
		if(k!=null)
			return k;
		return find(root.right, target);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node root = new Node(3);
		root.left = new Node(5);
		root.right = new Node(1);
		root.left.left = new Node(6);
		root.left.right = new Node(2);
		root.left.right.left = new Node(7);
		root.left.right.right = new Node(4);
		root.right.left = new Node(0);
		root.right.right = new Node(8);
		System.out.println(minTime(root, 5));
	}

}
