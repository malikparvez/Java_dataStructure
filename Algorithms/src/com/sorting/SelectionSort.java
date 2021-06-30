package com.sorting;
import java.util.Arrays;
public class SelectionSort {
	
	public static void selectionSort(int []arr) {
	
	
		for (int i = 0; i < arr.length; i++) {
			
			for (int j = i+1; j < arr.length; j++) {
			
				if (arr[i] > arr[j]) {
				int temp = arr[j];
				arr[j] = arr[i];
				arr[i] = temp;}
				else
					continue;
			}
		}		
	}
	
	
	public static void main(String[] args) {
		int[] arr = { 10, 5, 11, 2, 7, 9, 12, 15 };
		System.out.println("Before selection sort "+Arrays.toString(arr));
		selectionSort(arr);
		System.out.println("After selection sort "+Arrays.toString(arr));
	
	}

}
