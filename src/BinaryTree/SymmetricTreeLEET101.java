package BinaryTree;

public class SymmetricTreeLEET101 {
	
	public static boolean isSymmetric(TreeNode root) {
        
		return isSymmetricRecur(root.left,root.right);
    }

	private static boolean isSymmetricRecur(TreeNode root1, TreeNode root2) {
		if(root1 == null && root2!=null)
			return false;
		if(root1!=null&&root2==null)
			return false;
		if(root1 == null && root2 == null)
			return true;
		
		if(root1.val != root2.val)
			return false;
		
		if(!(isSymmetricRecur(root1.left, root2.right)))
				return false;
		if(!(isSymmetricRecur(root1.right, root2.left)))
				return false;
		
		return true;		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
