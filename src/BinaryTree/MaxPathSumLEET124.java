package BinaryTree;

public class MaxPathSumLEET124 {
	public static int maxPathSum(TreeNode root) {
        int[] max = new int[1];
        max[0] = Integer.MIN_VALUE;
        int h = maxSum(root, max);
        return max[0];
    }

	private static int maxSum(TreeNode root, int[] max) {
		if(root == null)
			return 0;
		
		int ls = maxSum(root.left,max);
		int rs = maxSum(root.right,max);
		
		max[0] = Math.max(max[0], root.val + rs + ls);
		
		return root.val + Math.max(ls, rs) < 0 ? 0 : root.val + Math.max(ls, rs);
	}

	public static void main(String[] args) {
		//

	}

}
