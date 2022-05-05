package com.practice.linkedlist;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

public class Problem3LL {
	
	public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
		ListNode head = null;
		ListNode last = null;
        while(list1!=null && list2!=null) {
        	if(list1.val <= list2.val) {
        		ListNode temp = new ListNode(list1.val);
        		if(head==null) {
        			head = temp;
        			last = temp;
        		}else {
        			last.next = temp;
        			last = temp;
        		}
        				
        		list1 = list1.next;
        	}else {
        		ListNode temp = new ListNode(list2.val);
        		if(head==null) {
        			head = temp;
        			last = temp;
        		}else {
        			last.next = temp;
        			last = temp;
        		}
        				
        		list2 = list2.next;
        	}
        }
        
        if(list1!=null) {
        	while(list1!=null) {
        		ListNode temp = new ListNode(list1.val);
        		if(head==null) {
        			head = temp;
        			last = temp;
        		}else {
        			last.next = temp;
        			last = temp;
        		}
        				
        		list1 = list1.next;
        	}
        	
        }
        if(list2!=null) {
        	while(list2!=null) {
        		ListNode temp = new ListNode(list2.val);
        		if(head==null) {
        			head = temp;
        			last = temp;
        		}else {
        			last.next = temp;
        			last = temp;
        		}
        				
        		list2 = list2.next;
        	}
        	
        }
        
        return head;
    }

	public static void main(String[] args) {
		
	}

}
