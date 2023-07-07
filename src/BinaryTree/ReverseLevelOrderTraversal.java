package BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;



class Node
{
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
}


public class ReverseLevelOrderTraversal {
	
	public static ArrayList<Integer> reverseLevelOrder(Node node)  {
        LinkedList<Node> ll = new LinkedList<>();
        List<List<Node>> list = new LinkedList<List<Node>>();
      //  List<List<Integer>> ans = new LinkedList<List<Integer>>();
        ArrayList<Integer> ansList = new ArrayList<Integer>();
        if(node==null)
        	return ansList;
        ll.add(node);
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
        for(int i=list.size()-1;i>=0;i--) {
        	for (Node n : list.get(i)) {
				ansList.add(n.data);
			}
        }
        
        return ansList;
        
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
