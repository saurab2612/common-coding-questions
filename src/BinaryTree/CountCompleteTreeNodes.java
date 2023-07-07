package BinaryTree;

public class CountCompleteTreeNodes {
	
	 public static int countNodes(TreeNode root) {
	        if(root == null)return 0;
	        
	        int lh = leftheight(root.left);
	        int rh = rightHeight(root.right);
	        
	        if(lh == rh) return  (int) (Math.pow(2, lh) -1);
	        
	       return 1 + countNodes(root.left) + countNodes(root.right);  
	        
	 }

	private static int rightHeight(TreeNode root) {
		if(root == null)
			return 0;
		
		return 1+ rightHeight(root.right);
			
	}

	private static int leftheight(TreeNode root) {
		if(root == null)
			return 0;
		
		return 1+ rightHeight(root.left);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
