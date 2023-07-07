package BinaryTree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BoundaryTraversal {
	
	static ArrayList<Integer> boundary(Node node)
	{
		ArrayList<Integer> ans = new ArrayList<>();
		if(node==null)
			return ans;
		if(node.left == null && node.right == null) {
			ans.add(node.data);
			return ans;
		}
			
	    //left part
		ans.add(node.data);
		Node temp = node;
		temp=temp.left;
		while(temp!=null) {
			ans.add(temp.data);
			if(temp.left!=null)
				temp=temp.left;
			else if(temp.right!=null)
				temp=temp.right;
			else
				break;
		}
		temp = node;
		List<Integer> l = new ArrayList<>();
		getLeaf(temp , l);
		if(node.left!=null)
			l.remove(0);
		ans.addAll(l);
		
		if(node.right!=null) {
			ans.remove(ans.size()-1);
			ArrayList<Integer> cur = new ArrayList<>();
			while(true) {
				if(temp!=null) {
					cur.add(temp.data);
					if(temp.right!=null)
						temp=temp.right;
					else if(temp.left!=null)
						temp=temp.left;
					else
						break;
				}
			}
			Collections.reverse(cur);
			cur.remove(cur.size()-1);
			ans.addAll(cur);
		}
		return ans;
	}

	private static void getLeaf(Node temp, List<Integer> l) {
		if(temp == null)
			return;
		if(temp.left == null && temp.right==null) {
			l.add(temp.data);
		}
		getLeaf(temp.left, l);
		getLeaf(temp.right, l);
	}

	public static void main(String[] args) {
		
		Node root= new Node(1);
	//	root.left = new Node(2);
		root.right = new Node(3);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
//		root.left.left = new Node(4);
//		root.left.right = new Node(5);
//		root.left.right.left = new Node(8);
//		root.left.right.right = new Node(9);
//		root.left.left.left = new Node(5);
//		root.left.left.right = new Node(5);
//		root.left.right.right = new Node(3);
//		root.left.right.right.right= new Node(8);
//		root.left.right.right.left= new Node(7);
		
		
		List<Integer> ls = boundary(root);
		System.out.println();

	}

}
