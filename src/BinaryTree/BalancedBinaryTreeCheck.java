package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class BalancedBinaryTreeCheck {
	
	public static boolean isBalanced(TreeNode root) {
        
		Queue<TreeNode> q = new LinkedList<>();
		if(root == null)
			return true;
		
		q.add(root);
		while(!q.isEmpty()) {
			TreeNode t = q.poll();
			if(Math.abs(height(t.left) - height(t.right)) > 1)
				return false;
			if(t.left!=null)
				q.add(t.left);
			if(t.right!=null)
				q.add(t.right);
		}
		return true;
		
    }

	private static int height(TreeNode root) {
		if(root == null)
			return 0;
		return 1 + Math.max(height(root.left), height(root.right));
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(2);
		root.left.left = new TreeNode(3);
		root.right.right = new TreeNode(3);
		root.left.left.left = new TreeNode(4);
		root.right.right.right = new TreeNode(4);
		
		
		isBalanced(root);
	}

}
