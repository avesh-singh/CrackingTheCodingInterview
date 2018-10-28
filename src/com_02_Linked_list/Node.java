package com_02_Linked_list;

import java.util.ArrayList;

import com_03_Stack.Stack;


public class Node {

	Node next = null;
	int d=0;
	
	Node(int data){
		d = data;
	}
	
	public boolean equals(Node b){
		return this.d==b.d && this.next==b.next;
	}
	
	public void appendToTail(int data){
		Node end = new Node(data);
		Node head = this;
		while(head.next!=null){
			head = head.next;
		}
		head.next = end;
	}
	
//	finding k-th to last element in a linked list
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
//	partition the linked list around val
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
	public static void display(Node temp,String delimiter){
		while(temp!=null){
			System.out.print(temp.d+delimiter);
			temp=temp.next;
		}
		System.out.println();
	}
	public boolean palindrome(){
		Node head = this;
		if(head.next==null){
			return true;
		}
		Node s = head;
		Node f = head;
		int length = 0;
		Node temp = head;
		while(temp.next!=null){
			temp=temp.next;
			length++;
		}
		ArrayList<Integer> list = new ArrayList<Integer>();
		while(f!=null && f.next!=null){
			list.add(s.d);
			s = s.next;
			f = f.next.next;
		}
		if(f!=null && f.next==null){
			s = s.next;
		}
		int i=list.size()-1;
		while(s!=null && i>=0){
			System.out.println("i="+i+" "+list.get(i).intValue()+" "+s.d);
			if(list.get(i).intValue()!=s.d){
				return false;
			}
			i--;
			s = s.next;
		}
		return true;
	}
	
	public Result palindrome_recursion(Node head,int l){
		System.out.println(head.d);
		if(l==0){
			return new Result(head,true);
		}
		if(l==1){
			return new Result(head.next,true);
		}
		Result res = palindrome_recursion(head.next,l-2);
		System.out.println(head.d+" "+res.n.d);
		if(head.d!=res.n.d){
			return new Result(head,false);
		}else{
			return new Result(res.n.next,true);
		}
	}
	
	public Node intersection(Node a,Node b){
		if(a==null || b==null) return null;
		int a_len = 0;
		int b_len = 0;
		Node _a = a;
		Node _b = b;
		while(_a!=null && _a.next!=null){
			_a = _a.next;
			a_len++;
		}
		while(_b!=null && _b.next!=null){			
			_b = _b.next;
			b_len++;
		}
		a_len++;
		b_len++;
		boolean intersect = false;
		if(_a==_b){
			intersect = true;
		}
		if(intersect){
			Node longer;
			Node shorter;
			if(a_len>=b_len){
				longer = a;
				shorter = b;
			}
			else{
				longer = b;
				shorter = a;
			}
			int clip = (a_len>b_len?a_len:b_len) - (a_len<=b_len?a_len:b_len);
			for(int i=0;i<clip;i++){
				longer = longer.next;
			}
			_a = longer;
			_b = shorter;
			while(_a!=null){
//				System.out.println(_a.d+" "+_b.d);
				if(_a==_b){
					break;
				}
				_a = _a.next;
				_b = _b.next;
			}
			return _a;
		}else{
			System.out.println("Does not intersect");
			return null;
		}
	}
	
	public Node circular(){
		
		Node head = this;
		Node slow = head;
		Node fast = head;
		Node temp = head;
		while(slow!=null){
//			System.out.println(slow.d+" "+fast.d);
			slow = slow.next;
			fast = fast.next.next;
			if(slow.equals(fast)){
				break;
			}
		}
		if(slow==null){
			return null;
		}
		Node fix = slow;
//		while(true){
//			System.out.println("outer "+slow.d+" "+temp.d);
//			slow=slow.next;
//			while(!slow.equals(fix)){
//				System.out.println("inner "+slow.d+" "+temp.d);
//				if(temp.next==slow.next){
//					return temp.next;
//				}
//				slow=slow.next;
//			}
//			if(temp.next==slow.next){
//				return temp.next;
//			}
//			temp = temp.next;
//			if(temp.next==slow.next){
//				return temp.next;
//			}
//		}
		while(temp!=slow){
			temp = temp.next;
			slow = slow.next;
		}
		return temp;
	}
}

class Result{
	Node n;
	boolean res;
	public Result(Node n,boolean val){
		this.n = n;
		this.res = val;
	}
}
