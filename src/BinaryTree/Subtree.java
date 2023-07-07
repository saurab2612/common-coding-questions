package BinaryTree;

import java.util.ArrayList;
import java.util.List;

public class Subtree {
	
	public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        
		List<TreeNode> refs = new ArrayList<TreeNode>();
		refs = searchRefs(refs, root, subRoot.val);
		
		for (TreeNode treeNode : refs) {
			if(checkSubtree(treeNode , subRoot)) {
				return true;
			}
		}
		
		
		return false;
    }

	private boolean checkSubtree(TreeNode treeNode, TreeNode subRoot) {
		if(treeNode==null && subRoot==null)
			return true;
		if(treeNode == null && subRoot!=null)
			return false;
		if(treeNode != null && subRoot==null)
			return false;
		if(treeNode.val != subRoot.val)
			return false;
		return checkSubtree(treeNode.left, subRoot.left) && checkSubtree(treeNode.right, subRoot.right);
		
	}

	private List<TreeNode> searchRefs(List<TreeNode> refs, TreeNode root, int val) {
		if(root == null) {
			return refs;
		}
		
		if(root.val == val) {
			refs.add(root);
		}
		
		refs = searchRefs(refs, root.left, val);
		refs = searchRefs(refs, root.right, val);
		
		return refs;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
