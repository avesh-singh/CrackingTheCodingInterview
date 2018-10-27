package com_01_Arrays_and_Strings;

public class UniqueCharacters {

	public static int partition(int start,int end,char[] input){

		int pivot = input[end];
		int i = start-1;
		int j = 0;
		for (j=start;j<end ;j++ ) {
			if(input[j]<=pivot){
				i++;
				swap(input,i,j);
			}
		}
		swap(input,i+1,end);
		return i+1;
//		}
	}
	public static void quickSort(int start,int end,char[] input){
		if(start<end){
			int pivot = partition(start,end,input);
			quickSort(start,pivot-1,input);
			quickSort(pivot+1,end,input);
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
//		Scanner scan = new Scanner(System.in);
		String input = "NBHJHYUYU BNBN";
		char[] arr = input.toCharArray();
		quickSort(0,input.length()-1,arr);
		print(arr);
		// binary sort --- recursive
	}

}
