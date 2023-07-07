package BinaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DFS {
	
	public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        return preorderRecur(root, ans);
    }

	private static List<Integer> preorderRecur(TreeNode root, List<Integer> ans) {
		if(root == null) {
			return ans;
		}
		ans.add(root.val);
		preorderRecur(root.left, ans);
		preorderRecur(root.right, ans);
		return ans;
	}
	
	public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        return inorderRecur(root, ans);
    }

	private static List<Integer> inorderRecur(TreeNode root, List<Integer> ans) {
		if(root == null)
			return ans;
		inorderRecur(root.left, ans);
		ans.add(root.val);
		inorderRecur(root.right, ans);
		return ans;
	}
	
	
	public static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        ans = postorderRecur(root, ans);
        return ans;
    }

	private static List<Integer> postorderRecur(TreeNode root, List<Integer> ans) {
		if(root == null)
			return ans;
		postorderRecur(root.left, ans);
		postorderRecur(root.right, ans);
		ans.add(root.val);
		return ans;
	}
	
	
	static List<Integer> preorderIterative(TreeNode root){
		List<Integer> ans = new ArrayList<>();
		Stack<TreeNode> s = new Stack<>();
		if(root == null)
			return ans;
		s.push(root);
		while(!s.isEmpty()) {
			TreeNode node = s.pop();
			if(node.right!=null)
				s.push(node.right);
			if(node.left!=null)
				s.push(node.left);
			ans.add(node.val);
		}
		return ans;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(7);
		preorderIterative(root);
	}

}
