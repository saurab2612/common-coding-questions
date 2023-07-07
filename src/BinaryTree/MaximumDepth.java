package BinaryTree;

//Definition for a binary tree node.
class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode() {
	}

	TreeNode(int val) {
		this.val = val;
	}

	TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
}

public class MaximumDepth {

	public static int maxDepth(TreeNode root) {
		
		if(root == null)
			return 0;
		
		return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));

	}

	public static void main(String[] args) {

	}

}
