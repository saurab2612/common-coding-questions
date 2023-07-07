package BinaryTree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

public class LevelOrderTraversal {
	
	
	//Used a lisnkedlist as a queue and then a list of list to store each level
	
	public static List<List<Integer>> levelOrder(TreeNode root) {
        LinkedList<TreeNode> ll = new LinkedList<>();
        List<List<TreeNode>> list = new LinkedList<List<TreeNode>>();
        List<List<Integer>> ans = new LinkedList<List<Integer>>();
      //  List<Integer> ansList = new LinkedList<Integer>();
        if(root==null)
        	return ans;
        ll.add(root);
        int level = 0;
        while(!ll.isEmpty()) {
        	List<TreeNode> ls = new LinkedList<TreeNode>();
        	while(!ll.isEmpty()) {
        		ls.add(ll.removeFirst());
        	}
        	for (TreeNode treeNode : ls) {
				if(treeNode.left!=null)
					ll.addLast(treeNode.left);
				if(treeNode.right!=null)
					ll.addLast(treeNode.right);
			}
        	list.add(ls);
        }
        list.stream().forEach(n->{
        	ans.add(n.stream().map(x->x.val).collect(Collectors.toList()));
        });
        return ans;
    }

	

	public static void main(String[] args) {
		
	}

}
