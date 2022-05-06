package com.practice.linkedlist;

import java.util.HashSet;
import java.util.Set;

class Node5
{
    int data;
    Node5 next;
    Node5(int d) {
        data = d; 
        next = null;
    }
}

public class Problem5LL {
	
	public static Node5 removeDuplicates(Node5 head) 
    {
         Set<Integer> set = new HashSet<>();
         Node5 newHead = null;
         Node5 last = null;
         while(head!=null) {
        	 if(set.contains(head.data)) {
        		 head = head.next;
        		 continue;
        	 }else {
        		 set.add(head.data);
        		 Node5 newNode5 = new Node5(head.data);
        		 if(newHead == null) {
        			 newHead = newNode5;
        			 last = newNode5;
        		 }
        		 else {
        			 last.next = newNode5;
        			 last = last.next;
        		 }
        		 
        	 }
        	 head=head.next;
         }
         
         
         return newHead;
    }
	
	public static Node5 insert(Node5 head, int data) {
		Node5 temp = head;
		Node5 newNode5 = new Node5(data);
		if(head==null) {
			return newNode5;
		}
		while(temp.next!=null) {
			temp = temp.next;
		}
		temp.next = newNode5;
		
		return head;
	}
	
	public static void print(Node5 head) {
		Node5 temp = head;
		while(temp!=null) {
			System.out.println(temp.data);
			temp = temp.next;
		}
	}
	
	
	

	public static void main(String[] args) {
		Node5 head = insert(null,1);
		head = insert(head,1);
		head = insert(head,1);
		removeDuplicates(head);
		
		print(head);
		

	}

}
