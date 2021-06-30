package com.sorting;

import java.util.Arrays;

public class BubbleSort {

	public static void bubblesort(int[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			boolean swapFlag=false;//more improvisation
			for (int j = 0; j < (arr.length - 1-i); j++) {
				//improved bubble sort
				if (arr[j] > arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
					swapFlag=true;
				}		
			}
			if(!swapFlag)
				break;
		}
	}

	public static void main(String[] args) {
		int[] arr = { 5, 7, 9, 10, 3, 8, 1, 2 };
		//int[] arr = { 1, 3, 5, 9, 10, 11, 12 };
		System.out.println("Before bubble sort " + Arrays.toString(arr));
		bubblesort(arr);
		System.out.println("after bubble sort " + Arrays.toString(arr));
	}
}
