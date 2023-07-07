package BinaryTree;

public class MaxDepth {
	
	public static int maxDepth(TreeNode root) {
        if(root == null)
        	return 0;
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
	
	public static int minDepth(TreeNode root) {
        if(root == null)
        	return 0;
        int l = minDepth(root.left);
        int r = minDepth(root.right);
        if(l==0) {
        	return 1 +  r;
        }
        if(r==0) {
        	return 1 + l;
        }
        
        return 1 + Math.min(l,r);
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
