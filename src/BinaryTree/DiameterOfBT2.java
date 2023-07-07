package BinaryTree;

public class DiameterOfBT2 {
	
	public int diameterOfBinaryTree(TreeNode root) {
		 int[] max = new int[1];
		int h = height(root, max);
		return max[0];
	}

	private int height(TreeNode root, int[] max) {
		if(root == null)
			return 0;
		
		int lh = height(root.left, max);
		int rh = height(root.right, max);
		max[0] = Math.max(max[0], rh + lh);
		return 1 + Math.max(lh,rh);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
