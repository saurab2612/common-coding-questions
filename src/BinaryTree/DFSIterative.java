package BinaryTree;

import java.util.ArrayList;
import java.util.Stack;

public class DFSIterative {
	
	static ArrayList<Integer> preorder(Node root)
    {   
		ArrayList<Integer> ans = new ArrayList<>();
		if(root == null)
			return ans;
        Stack<Node> s = new Stack<>();
        s.add(root);
        while(!s.isEmpty()) {
        	Node n = s.pop();
        	ans.add(n.data);
        	if(n.right!=null)
        		s.add(n.right);
        	if(n.left!=null)
        		s.add(n.left);
        }
        
        return ans;
        
    }

	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(4);
		root.left.left = new Node(4);
		root.left.right = new Node(2);
		preorder(root);
	}

}
