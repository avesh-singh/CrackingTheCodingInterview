package com_01_Arrays_and_Strings;

public class RotateMatrix {

	public static int[][] transpose(int[][] arr){
		int rows = arr.length;
		int columns = arr[0].length;
		int temp = 0;
		for(int i=0;i<rows;i++){
			for(int j=i;j<columns;j++){
				temp = arr[i][j];
				arr[i][j] = arr[j][i];
				arr[j][i] = temp;
			}
		}
		return arr;
	}
	
	public static int[][] reverse(int[][] arr){
		int rows = arr.length;
		int columns = arr[0].length;
		int temp = 0;
		for(int i=0;i<=(rows/2-1);i++){
			for(int j=0;j<columns;j++){
				temp = arr[i][j];
				arr[i][j] = arr[rows-i-1][j];
				arr[rows-i-1][j] = temp;
			}
		}
		return arr;
	}
	
	public static void print(int[][] arr){
		for(int i=0;i<arr.length;i++){
			for(int j=0;j<arr[0].length;j++){
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		int[][] arr= {{1,1,2,3},{13,3,2,23},{5,1,27,29},{19,2,6,16}};
//		int[][] arr = {{1,2,3},{4,5,6},{7,8,9}};
		System.out.println("Original Array");
		print(arr);
		arr = transpose(arr);
		System.out.println("Transpose");
		print(arr);
		arr = reverse(arr);
		System.out.println("Rotated by 90 deg.");
		print(arr);
	}

}
