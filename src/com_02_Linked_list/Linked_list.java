package com_02_Linked_list;

public class Linked_list {
	
	public static void display(Node temp,String delimiter){
		while(temp!=null){
			System.out.print(temp.d+delimiter);
			temp=temp.next;
		}
		System.out.println();
	}
	
	public static int sum(Node num1,Node num2, Node ans){
		if(num1==null || num2==null) return 0;
//		System.out.println(num1.d+"+"+num2.d);
		if(num1.next==null && num2.next==null){
			ans.d = (num1.d+num2.d)%10;
//			System.out.println(num1.d+num2.d);
			return (num1.d+num2.d)/10;
		}
		int temp = num1.d + num2.d + sum(num1.next,num2.next,ans.next);
//		System.out.println("temp "+temp);
		ans.d = temp%10;
//		System.out.println(ans.d);
		return temp/10;
	}
	
	public static void main(String[] args) {
		Node num1 = new Node(3);
		num1.appendToTail(2);
		num1.appendToTail(3);
		Node num2 = new Node(9);
		num2.appendToTail(2);
		num2.appendToTail(1);
		
		int length1 = 0;
		Node temp1 = num1;
		int length2 = 0;
		Node temp2 = num2;
		while(temp1!=null){
			length1++;
			temp1 = temp1.next;
		}
		while(temp2!=null){
			length2++;
			temp2 = temp2.next;
		}
		int length=length1>length2?length1:length2;
		Node ans = new Node(0);
		for(int i=0;i<length;i++){
			ans.appendToTail(0);
		}
		Node zero;
		Node temp = num1;
		for(int i=length1;i<length;i++){
			zero = new Node(0);
			zero.next = temp;
			temp = zero;
		}
		num1 = temp;
		temp = num2;
		for(int i=length2;i<length;i++){
			zero = new Node(0);
			zero.next = temp;
			temp = zero;
		}
		num2 = temp;
		System.out.println("Number 1");
		display(num1,"");
		System.out.println("Number 2");
		display(num2,"");
		ans.d += sum(num1,num2,ans.next);
		display(ans,"");
	}

}
