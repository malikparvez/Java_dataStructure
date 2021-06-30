package com.Searching;

import java.util.*;

public class BinarySearch {

//works only for sorted arrays	
	public static int binarySearch(int[] arr, int key) {
		int left = 0, mid, right = arr.length - 1;
		while (left <= right) {
			mid = (left + right) / 2;
			
			if (arr[mid] == key)
				return mid;

			else if (arr[mid] > key)
				right = mid - 1;

			else if (arr[mid] < key)
				left = mid + 1;

		}
		return -1;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = { 10, 5, 11, 2, 7, 9, 12, 15 };
		Arrays.sort(arr);
		System.out.println(Arrays.toString(arr));
		System.out.println("Enter key to search index:");
		int key = sc.nextInt();
		int index = binarySearch(arr, key);
		if (index != -1)
			System.out.println(key + " found at index: " + index);
		sc.close();
	}

}
