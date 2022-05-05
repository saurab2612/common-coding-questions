package com.practice.linkedlist;

class Node
{
	int data ;
	Node next;
	Node(int d)
	{
		data = d;
		next = null;
	}
}

public class Problem4LL {
	
	void deleteNode(Node del)
    {
		Node temp = del.next;
		del.data = temp.data;
		del.next = temp.next;
		temp.next = null;
		
    }
	
	
	public static void main(String[] args) {
		
	}

}
