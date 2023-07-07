package BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFS {
	
	public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        if(root == null)
        	return ans;
        q.add(root);
        while(!q.isEmpty()) {
        	List<Integer> cur = new ArrayList<>();
        	int size = q.size();
        	for(int i=0;i<size;i++) {
        		TreeNode p = q.poll();
        		if(p.left!=null) 
        			q.add(p.left);
        		if(p.right!=null)
        			q.add(p.right);
        		cur.add(p.val);	
        	}
        	ans.add(cur);
        }
        return ans;
        
    }

	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(7);
		levelOrder(root);

	}

}
