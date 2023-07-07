package BST;

public class SearchLEET700 {
	
	public static TreeNode searchBST(TreeNode root, int val) {
        if(root == null)
        	return null;
        
        if(root.val == val)
        	return root;
        if(val > root.val)
        	return searchBST(root.right, val);
        else
        	return searchBST(root.left, val);
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
