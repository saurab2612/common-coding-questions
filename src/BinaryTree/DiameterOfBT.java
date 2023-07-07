package BinaryTree;

public class DiameterOfBT {
	
	class NodeStat{
		int diameter;
		int height;
		NodeStat(int diameter, int height) {
			this.diameter = diameter;
			this.height = height;
		}
	}
	
	public int diameterOfBinaryTree(TreeNode root) {
        
		NodeStat n = height(root);
		return n.diameter;
    }

	private NodeStat height(TreeNode root) {
		if(root == null) {
			return new NodeStat(0, 0);
		}
		
		NodeStat left = height(root.left);
		NodeStat right = height(root.right);
		
		int height = 1 + Math.max(left.height, right.height);
		int maxDiameter = Math.max(left.diameter, right.diameter);
		
		int diameter = Math.max(left.height + right.height, maxDiameter);
		return new NodeStat(diameter, height);
	}			

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
