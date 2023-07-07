package BST;

public class Ceil {
	
	private static class TreeNode<T>
    {
        T data;
        TreeNode<T> left;
        TreeNode<T> right;

        TreeNode(T data)
        {
            this.data = data;
            left = null;
            right = null;
        }
    }
	
	public  static int findCeil(TreeNode<Integer> node, int x) {
		
		int[] ceil = new int[1];
		ceil[0] = Integer.MAX_VALUE;
		findCeilRecur(node, x, ceil);
        return ceil[0]==Integer.MAX_VALUE?-1:ceil[0];

    }
    
    

	private static void findCeilRecur(TreeNode<Integer> node, int x, int[] ceil) {
		if(node == null)
			return;
		if(node.data >= x && node.data< ceil[0])
			ceil[0] = node.data;
		if(x<node.data)
			findCeilRecur(node.left, x, ceil);
		else
			findCeilRecur(node.right, x, ceil);
	}
	
	public static int floorInBST(TreeNode<Integer> root, int X) {
        int[] floor = new int[1];
        floor[0] = Integer.MIN_VALUE;
        floorInBSTRecur(root, X, floor);
        return floor[0]==Integer.MIN_VALUE?-1:floor[0];
    }



	private static void floorInBSTRecur(TreeNode<Integer> root, int x, int[] floor) {
		if(root == null)
			return;
		if(root.data<=x && root.data>floor[0])
			floor[0] = root.data;
		if(x < root.data)
			floorInBSTRecur(root.left, x, floor);
		else
			floorInBSTRecur(root.right, x, floor);
		
	}



	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
