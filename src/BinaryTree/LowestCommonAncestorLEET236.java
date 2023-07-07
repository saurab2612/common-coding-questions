package BinaryTree;

public class LowestCommonAncestorLEET236 {
	
	public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int[] ans = new int[1];
		Boolean bool = postOrder(root,p,q, ans);
		return new TreeNode(ans[0]);
    }

	private static Boolean postOrder(TreeNode root, TreeNode p, TreeNode q, int[] ans) {
		if(root == null)
			return false;
		
		Boolean l = postOrder(root.left, p, q, ans);
		Boolean r = postOrder(root.right, p, q, ans);
		
		if(l==false && r == false) {
			if(root.val == p.val || root.val == q.val)return true; 
		}else if((r==false&&l==true)||(r==true&&l==false)) {
			if(root.val == p.val || root.val == q.val) {
				ans[0] = root.val;
				return true;
			}else
				return true;
		}else if(r==true && l == true) {
			ans[0] = root.val;
			return true;
		}
		
		return false;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(5);
		root.right = new TreeNode(1);
		root.left.left = new TreeNode(6);
		root.left.right = new TreeNode(2);
		root.left.right.left = new TreeNode(7);
		root.left.right .right= new TreeNode(4);
		root.right.left = new TreeNode(0);
		root.right.right = new TreeNode(8);
		
		
		lowestCommonAncestor(root, new TreeNode(5), new TreeNode(4));

	}

}
