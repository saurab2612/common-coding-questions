package BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class RightView {
	
	//Function to return list containing elements of right view of binary tree.
	static ArrayList<Integer> rightView(Node root){
        LinkedList<Node> ll = new LinkedList<>();
        List<List<Node>> list = new LinkedList<List<Node>>();
        ArrayList<Integer> ans = new ArrayList<>();
      //  List<Integer> ansList = new LinkedList<Integer>();
        if(root==null)
        	return ans;
        ll.add(root);
        int level = 0;
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
        list.stream().forEach(x->{
        	ans.add(x.get(x.size()-1).data);
        });
        return ans;
    }

	public static void main(String[] args) {
		
	}

}
