package BinaryTree;

public class ChildrenSumParentGFG {
	
	public static int isSumProperty(Node root)
	
    {
		if(root == null) {
			return 1;
		}
		
		if(root.left == null && root.right==null) {
			return 1;
		}
		
		if(isSumProperty(root.left) == 0)
			return 0;
		if(isSumProperty(root.right) == 0)
			return 0;
		
		
		int l = root.left==null?0:root.left.data;
		int r = root.right==null?0:root.right.data;
		
		if(root.data == l+r)
			return 1;
		else 
			return 0;
    }

	public static void main(String[] args) {
		Node root = new Node(10);
		root.left = new Node(10);
		System.out.println(isSumProperty(root));
	}

}
