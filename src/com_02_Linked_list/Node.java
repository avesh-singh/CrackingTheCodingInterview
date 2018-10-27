package com_02_Linked_list;

public class Node {

	Node next = null;
	int d=0;
	
	Node(int data){
		d = data;
	}
	
	public void appendToTail(int data){
		Node end = new Node(data);
		Node head = this;
		while(head.next!=null){
			head = head.next;
		}
		head.next = end;
	}
	public Node kthLast(int k){
		Node fast = this;
		Node slow = this;
		for(int i=0;i<k;i++){
			if(fast.next!=null){
				fast=fast.next;
			}else{
				return null;
			}
		}
		while(fast!=null){
			fast = fast.next;
			slow=slow.next;
		}
		return slow;
	}
	
	public void partition(int val){
		Node head = this;
		Node temp = new Node(-1);
		temp.next=head;
		Node i = temp;
		Node j = head;
		while(j!=null){
			if(j.d<val){
				i = i.next;
				int t = i.d;
				i.d = j.d;
				j.d = t;
			}
			j = j.next;
		}
 	}
}
