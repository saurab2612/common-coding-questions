package BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class WidthLEET662 {
	
	public static int widthOfBinaryTree(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        if(root == null)
        	return 0;
        if(root.left == null && root.right == null)
        	return 1;
        root.val = 1;
        q.add(root);
        int max=0;
        while(!q.isEmpty()) {
        	List<Integer> cur = new ArrayList<>();
        	int size = q.size();
        	for(int i=0;i<size;i++) {
        		TreeNode t = q.poll();
        		if(t.left!=null) {
        			t.left.val = (t.val-1)*2 + 1; // -1 done to avoid overflow 
        			q.add(t.left);
        			cur.add(t.val*2);
        		}
        		if(t.right!=null) {
        			t.right.val = (t.val-1)*2 + 2;
        			q.add(t.right);
        			cur.add(t.val*2 + 1);
        		}
        	}
        	if(!cur.isEmpty()) {
        		int width = cur.get(cur.size()-1) - cur.get(0) + 1;
            	if(width>max)
            		max = width;
        	}
        } 
        return max;
    }
	
//original	
//	public static int widthOfBinaryTree(TreeNode root) {
//        Queue<TreeNode> q = new LinkedList<>();
//        if(root == null)
//        	return 0;
//        if(root.left == null && root.right == null)
//        	return 1;
//        root.val = 1;
//        q.add(root);
//        int max=0;
//        while(!q.isEmpty()) {
//        	List<Integer> cur = new ArrayList<>();
//        	int size = q.size();
//        	for(int i=0;i<size;i++) {
//        		TreeNode t = q.poll();
//        		if(t.left!=null) {
//        			t.left.val = t.val*2;
//        			q.add(t.left);
//        			cur.add(t.val*2);
//        		}
//        		if(t.right!=null) {
//        			t.right.val = t.val*2 + 1;
//        			q.add(t.right);
//        			cur.add(t.val*2 + 1);
//        		}
//        	}
//        	if(!cur.isEmpty()) {
//        		int width = cur.get(cur.size()-1) - cur.get(0) + 1;
//            	if(width>max)
//            		max = width;
//        	}
//        } 
//        return max;
//    }

	

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(1);
		root.right = new TreeNode(1);
		root.left.right = new TreeNode(1);
		root.left.right.left = new TreeNode(2);
		root.left.right.right = new TreeNode(2);
		root.left.right.left.left = new TreeNode(2);
		root.left.right.right.right = new TreeNode(2);
		
		
		widthOfBinaryTree(root);
		

	}

}
