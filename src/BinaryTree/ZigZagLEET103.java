package BinaryTree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ZigZagLEET103 {
	
	public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null)
        	return ans;
        q.add(root);
        Boolean bool = true;
        while(!q.isEmpty()) {
        	int size = q.size();
        	List<Integer> cur = new ArrayList<>();
        	for(int i=0;i<size;i++) {
        		TreeNode n = q.poll();
        		cur.add(n.val);
        		if(n.left!=null)
        			q.add(n.left);
        		if(n.right!=null)
        			q.add(n.right);
        	}
        	if(bool) {
        		ans.add(cur);
        		bool = false;
        	}
        	else {
        		Collections.reverse(cur);
        		ans.add(cur);
        		bool = true;
        	}
        }
        return ans;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
