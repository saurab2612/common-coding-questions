package com.practice.linkedlist;

import java.util.HashSet;
import java.util.Set;

class Node6
{
    int data;
    Node6 next;
    Node6(int d) {
        data = d; 
        next = null;
    }
}

public class Problem6LL {
	
	//Function to sort a linked list of 0s, 1s and 2s.
    static Node6 segregate(Node6 head)
    {
    	if(head == null || head.next == null)
    		return head;
        Node6 temp = head;
        int count0 =0;
        int count1 =0;
        int count2 = 0;
        while(temp!=null) {
        	if(temp.data==0) {
        		count0++;
        	}
        		
        	if(temp.data==1) {
        		count1++;
        	}
        	
        	if(temp.data ==2)
        		count2++;
        		
        	temp=temp.next;
        }
        Node6 newHead = null;
        if(count0!=0) {
        	while(count0>0) {
        		newHead = insertatBegin(newHead, 0);
        		count0--;
        	}
        }
        if(count1!=0) {
        	while(count1>0) {
        		newHead=insertatEnd(newHead, 1);
        		count1--;
        	}
        }
        if(count2!=0) {
        	while(count2>0) {
        		newHead=insertatEnd(newHead, 2);
        		count2--;
        	}
        }
        return newHead;
    }
    
    static Node6 insertatBegin(Node6 head,int data){
    	Node6 newNode6 = new Node6(data);
    	if(head == null)
    		return newNode6;
    	newNode6.next = head;
    	head= newNode6;
    	return head;
    }
	
	public static Node6 insertatEnd(Node6 head, int data) {
		Node6 temp = head;
		Node6 newNode6 = new Node6(data);
		if(head==null) {
			return newNode6;
		}
		while(temp.next!=null) {
			temp = temp.next;
		}
		temp.next = newNode6;
		
		return head;
	}
	
	public static void print(Node6 head) {
		Node6 temp = head;
		while(temp!=null) {
			System.out.println(temp.data);
			temp = temp.next;
		}
	}
	
	
	

	public static void main(String[] args) {
		Node6 head = insertatEnd(null,1);
		head = insertatEnd(head,1);
		head = insertatEnd(head,0);	
		head = insertatEnd(head,1);	
		head = insertatEnd(head,2);
		head = insertatEnd(head,1);	
		//removeDuplicates(head);
		Node6 newhead = segregate(head);
		
		print(newhead);
		

	}

}
