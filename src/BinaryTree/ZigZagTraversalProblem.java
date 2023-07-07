package BinaryTree;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ZigZagTraversalProblem {
	
	//Function to return list containing elements of right view of binary tree.
		static ArrayList<Integer> zigZagTraversal(Node root){
	        LinkedList<Node> ll = new LinkedList<>();
	        List<List<Node>> list = new LinkedList<List<Node>>();
	        ArrayList<Integer> ans = new ArrayList<>();
	      //  List<Integer> ansList = new LinkedList<Integer>();
	        if(root==null)
	        	return ans;
	        ll.add(root);
	        while(!ll.isEmpty()) {
	        	List<Node> ls = new LinkedList<Node>();
	        	while(!ll.isEmpty()) {
	        		ls.add(ll.removeFirst());
	        	}
	        	for (Node treeNode : ls) {
					if(treeNode.left!=null)
						ll.addLast(treeNode.left);
					if(treeNode.right!=null)
						ll.addLast(treeNode.right);
				}
	        	list.add(ls);
	        }
	        int flag = 0;
	        for (List<Node> l : list) {
				if(flag ==0) {
					for(int i=0;i<l.size();i++) {
						ans.add(l.get(i).data);
					}
				}
				if(flag ==1) {
					for(int i=l.size()-1;i>=0;i--) {
						ans.add(l.get(i).data);
					}
				}
				if(flag==0)
					flag=1;
				else
					flag=0;
			}
	        
	        
	        return ans;
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
