package com_01_Arrays_and_Strings;

public class URLify {

	public static void convert(char[] arr,int len){
		int i = arr.length-1;
		int j = 0;
		for(j=len-1;j>=0;j--){
			if(arr[j]!=' '){
				System.out.println(j+" "+i);
				swap(arr,i,j);
				i--;
				print(arr);
			}else{
				if(arr[i]==' '){
					arr[i] = '0';
					arr[i-1] = '2';
					arr[i-2] = '%';
					i-=3;
				}
			}
		}
	}

	public static void swap(char[] input,int a, int b){
		char temp = input[a];
		input[a] = input[b];
		input[b] = temp;
	}
	
	public static void print(char[] arr){
		for(int a=0;a<arr.length;a++){
			System.out.print(arr[a]);
		}
		System.out.println();
	}

	public static void main(String[] args) {
		String input = "Mr John Smith    ";
		int len = 13;
		char[] arr = input.toCharArray();
		convert(arr,len);
		print(arr);
	}

}
