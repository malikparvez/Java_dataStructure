package com.Searching;

import java.util.Scanner;

public class LinearSearch {
//works on any array
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = { 10, 5, 11, 2, 7, 9, 12, 15 };
		System.out.println("Enter key to search index: ");
		int key = sc.nextInt();
		int index = linearSearch(arr, key);
		if (index != -1)
			System.out.println("found " + key + " at index: " + index);
		else
			System.out.println("Not found " + key);
		sc.close();
	}

	public static int linearSearch(int[] arr, int key) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == key)
				return i;
		}
		return -1;
	}

}
