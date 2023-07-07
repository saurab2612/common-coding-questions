package BST;

public class DeleteANodeLEET450 {
	
	//find the node
	//if leaf node then do nothing
	//else if root.right == null get largest from root.left
	
	public static TreeNode deleteNode(TreeNode root, int key) {
		//first covering root =null or single node in tree cases
		if(root == null)
			return null;
		if(root.val == key && root.left==null && root.right==null)
			return null;
		if(root.val != key && root.left==null && root.right==null)
			return root;
		
		//two cases one in which root = key to be deleted or else
		if(root.val ==key) {
			if(root.left == null) // if left subtree is null return right subtree
				return root.right;
			if(root.right == null) // if right subtree is null return left subtree
				return root.left;
			TreeNode temp = root.right;
			if(root.left.right == null) { // if both not null then take right subtree and shove it under the left subtree
				root.left.right = temp;
				return root.left;
			}
			else {
				TreeNode tempLeft = root.left;
				while(tempLeft.right!=null) {
					tempLeft = tempLeft.right;
				}
				tempLeft.right = temp;
				return root.left;
			}
		}else { //if root is not to be deleted 
			TreeNode parent = null;
			TreeNode temp = root;
			while(temp!=null) { // figuring iout the parent by figuring out if the next node is key yo be deleted
				if((temp.left !=null &&temp.left.val ==key )|| (temp.right!=null && temp.right.val ==key)) {parent = temp; break;} 
				if(key<temp.val)
					temp = temp.left;
				else
					temp = temp.right;
			}
			if(parent!=null) { // if key to be deleted is present 
				if(parent.left!=null && parent.left.val == key) { //to check if key is their in left chile
					if(parent.left.left!=null) { //if left of key is not null
						TreeNode keyRightChild = parent.left.right; // right of key - could be null
						TreeNode keyLeftChild = parent.left.left;
						parent.left = keyLeftChild;
						
						while(keyLeftChild.right!=null) { //take right of key and first put left of key under parent and then put right of key under the first null in the series of leftofkey.right
							keyLeftChild=keyLeftChild.right;
						}
						keyLeftChild.right = keyRightChild;
					}else { //if left of ket is null then just take the right of key and shove under parent in place of key
						TreeNode tempLeft =parent.left.right;
						parent.left = parent.left.right;
					}
				}else {
					if(parent.right.right!=null) {
						TreeNode tempLeft = parent.right.left;
						TreeNode tempRight = parent.right.right; // could benull
						parent.right = tempRight;
						
						while(tempRight.left!=null) {
							tempRight=tempRight.left;
						}
						tempRight.left = tempLeft;
					}else { // if right of key if null then just take left of key and shove it under the parent
						//next.right = next.right.left;
						TreeNode tempRight =parent.right.left; 
						parent.right = tempRight;
					}
				}
			}
			
			
		}
		
		return root;
		
		
		
    }

	

	public static void main(String[] args) {
//		TreeNode root = new TreeNode(5);
//		root.left = new TreeNode(3);
//		root.right = new TreeNode(6);
//		root.left.left = new TreeNode(2);
//		root.left.right = new TreeNode(4);
//		root.right.right = new TreeNode(7);
		
		TreeNode root = new TreeNode(2);
		root.left = new TreeNode(1);
		root.right = new TreeNode(3);
		
		TreeNode ans = deleteNode(root, 2);
		System.out.println();
 
	}

}
