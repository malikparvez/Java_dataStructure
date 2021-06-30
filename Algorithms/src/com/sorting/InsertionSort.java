package com.sorting;

import java.util.Arrays;

public class InsertionSort {

	public static void insertionSort(int []arr) {
		
		for (int i = 0; i < arr.length; i++) {
			int temp=arr[i];
			int j;
			for (j = i-1; j>=0 && arr[j]>temp; j--) {
			 arr[j+1] = arr[j];
			}
			arr[j+1]=temp;
		}		
	}
	
	
	public static void main(String[] args) {
		int[] arr = {1,3,6,7,8,2};
		System.out.println("Before insertion sort "+Arrays.toString(arr));
		insertionSort(arr);
		System.out.println("After insertion sort "+Arrays.toString(arr));
	
	}

}

