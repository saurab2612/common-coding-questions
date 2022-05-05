package com.practice.linkedlist;

class ListNode {
	int val;
	ListNode next;

	ListNode() {
	}

	ListNode(int val) {
		this.val = val;
	}

	ListNode(int val, ListNode next) {
		this.val = val;
		this.next = next;
	}
}

public class Problem1LL {
	
	
	public static ListNode reverseList(ListNode head) {
        if(head == null)
            return head;
        ListNode prev = null;
        ListNode current = head;
        ListNode next = head.next;
        while(current.next!=null) {
        	current.next = prev;
        	prev = current;
        	current = next;
        	next=current.next;
        }
        current.next = prev;
        return current;
        
    }										

	public static void main(String[] args) {
		
	}

}
