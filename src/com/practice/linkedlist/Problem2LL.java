package com.practice.linkedlist;

import java.util.HashSet;
import java.util.Set;

public class Problem2LL {
	
	public static boolean hasCycle(ListNode head) {
         Set<ListNode> set = new HashSet<>();
         while(head!=null) {
        	 if(set.contains(head))
        		 return true;
        	 else
        		 set.add(head);
        	 head = head.next;
         }
         return true;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
