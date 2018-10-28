package com_02_Linked_list;

import java.util.Stack;

public class Linked_list {
	
	public static void display(Node temp,String delimiter){
		int count = 12;
		while(temp!=null && count!=0){
			System.out.print(temp.d+delimiter);
			temp=temp.next;
			count--;
		}
		System.out.println();
	}
//	sum of two numbers given as linked lists
	public static int sum(Node num1,Node num2, Node ans){
		if(num1==null || num2==null) return 0;
		if(num1.next==null && num2.next==null){
			ans.d = (num1.d+num2.d)%10;
			return (num1.d+num2.d)/10;
		}
		int temp = num1.d + num2.d + sum(num1.next,num2.next,ans.next);
		ans.d = temp%10;
		return temp/10;
	}
	
	public static void main(String[] args) {
//		input for addition of two numbers
//		creating the numbers
//		Node num1 = new Node(3);
//		num1.appendToTail(2);
//		num1.appendToTail(3);
//		Node num2 = new Node(9);
//		num2.appendToTail(2);
//		num2.appendToTail(1);
//		
//		int length1 = 0;
//		Node temp1 = num1;
//		int length2 = 0;
//		Node temp2 = num2;
//		while(temp1!=null){
//			length1++;
//			temp1 = temp1.next;
//		}
//		while(temp2!=null){
//			length2++;
//			temp2 = temp2.next;
//		}
//		int length=length1>length2?length1:length2;
//		Node ans = new Node(0);
//		for(int i=0;i<length;i++){
//			ans.appendToTail(0);
//		}
////		padding numbers with zeros
//		Node zero;
//		Node temp = num1;
//		for(int i=length1;i<length;i++){
//			zero = new Node(0);
//			zero.next = temp;
//			temp = zero;
//		}
//		num1 = temp;
//		temp = num2;
//		for(int i=length2;i<length;i++){
//			zero = new Node(0);
//			zero.next = temp;
//			temp = zero;
//		}
//		num2 = temp;
//		System.out.println("Number 1");
//		display(num1,"");
//		System.out.println("Number 2");
//		display(num2,"");
//		ans.d += sum(num1,num2,ans.next);
//		display(ans,"");
			
//		input for checking the palindrome
//		Node pal = new Node(1);
//		pal.appendToTail(2);
//		pal.appendToTail(3);
////		pal.appendToTail(3);
//		pal.appendToTail(2);
//		pal.appendToTail(1);
//		System.out.println(pal.palindrome_recursion(pal,5).res);
		Node list1 = new Node(3);
		list1.appendToTail(1);
		list1.appendToTail(5);
		list1.appendToTail(9);
	    Node list2 = new Node(4);
	    list2.appendToTail(6);
	    list2.appendToTail(7);
	    list2.appendToTail(2);
	    list2.appendToTail(1);
	    Node last = list1.next.next.next;
	    Node intersect = list2.next.next;
	    last.next = intersect;
	    display(list1," ");
	    display(list2," ");
	    Node ans = list1.intersection(list1, list2);
	    if(ans!=null){
	    	System.out.println(ans.d);
	    }
//	    Node t = new Node(2);
//	    Node t1 = new Node(2);
//	    Node t2 = new Node(1);
//	    t.next = t2;
//	    t1.next = t2;
//	    System.out.println(t.equals(t1));
//	    long mem = list1;
//	    System.out.println(mem);
	    Node list = new Node(0);
	    list.appendToTail(1);
	    list.appendToTail(2);
	    list.appendToTail(3);
	    list.appendToTail(4);
	    list.appendToTail(5);
	    list.appendToTail(6);
	    Node anchor = list.next.next;
	    Node temp = list;
	    while(temp.next!=null){
	    	temp=temp.next;
	    }
	    temp.next = anchor;
	    display(list," ");
	    if(list.circular()!=null){
	    	System.out.println(list.circular().d);
	    }
	}

}
