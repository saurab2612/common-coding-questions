package BST;



  //Definition for a binary tree node.
  class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
 

public class LowestCommonAncestor {
	
	
	
	
	public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if(root == null)
			return null;
		 
        if(p.val == root.val || q.val == root.val || (p.val > root.val && q.val < root.val) || (p.val < root.val && q.val > root.val)) {
        	return root;
        }
        
        if(p.val>root.val && q.val>root.val)
        	return lowestCommonAncestor(root.right, p, q);
        else
        	return lowestCommonAncestor(root.left, p, q);  
    }
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
