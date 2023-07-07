package BinaryTree;

import java.util.ArrayList;
import java.util.List;

public class RootToNodePath {
	
	public static List<Integer> rootToNodePath(TreeNode root, int k){
		
		List<Integer> ans = new ArrayList<>();
		Boolean bool = preOrder(root,k,ans);
		return ans;
	}

	private static Boolean preOrder(TreeNode root, int k, List<Integer> ans) {
		if(root == null)
			return false;
		if(root.val == k) {
			ans.add(root.val);
			return true;
		}
		
		ans.add(root.val);
		if(preOrder(root.left, k, ans))
			return true;
		if(preOrder(root.right, k, ans))
			return true;
		ans.remove(ans.size()-1);
		
		return false;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(7);
		rootToNodePath(root, 7);

	}

}
