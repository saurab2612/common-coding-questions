package BST;

public class InsertLEET701 {
	
	public static TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null)
        	return new TreeNode(val);
        
        if(val < root.val) {
        	if(root.left!=null)
        		insertIntoBST(root.left, val);
        	else
        		root.left = new TreeNode(val);
        }else {
        	if(root.right!=null)
        		insertIntoBST(root.right, val);
        	else
        		root.right = new TreeNode(val);
        }
        return root;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
