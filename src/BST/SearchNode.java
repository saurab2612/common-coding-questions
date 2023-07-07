package BST;

class Node{
	int data;
	Node left,right;
	Node(int d){
		data = d;
		left = right = null;
	}
}


public class SearchNode {
	
	// Function to search a node in BST.
    boolean search(Node root, int x) {
        if(root == null)
        	return false;
        if(root.data == x)
        	return true;
        if(root.data>x) {
        	return search(root.left, x);
        }else {
        	return search(root.right, x);
        }
    }
    
    
    Node insert(Node root, int x) {
    	Node newNode = new Node(x);
    	if(root == null) {
    		root = newNode;
    	}
    	if(x>root.data)
    		insert(root.right, x);
    	else
    		insert(root.left, x);
    	
    	return root;
    }
    
    
    
    

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
