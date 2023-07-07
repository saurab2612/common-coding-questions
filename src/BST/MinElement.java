package BST;

public class MinElement {
	
	// Function to find the minimum element in the given BST.
    int minValue(Node node) {
    	if(node == null)
    		return -1;
    	if(node.left == null)
    		return node.data;
    	else {
    		while(node.left!=null) {
    			node=node.left;
    		}
    		return node.data;
    	}
    	
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
