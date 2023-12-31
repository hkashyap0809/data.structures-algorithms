package com.datastructures.test;

import java.util.Arrays;
import java.util.HashMap;

public class InterestingPairOfNumbers {
	public static int countPairsMap(int[] arr, int k) {
		int count = 0;
		HashMap<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < arr.length; i++) {
			int diff = k - arr[i];

			if (map.containsKey(diff)) {
				count += map.get(diff);
				if (arr[i] == diff) {
					// Decrement the frequency of diff to avoid double counting
					map.put(diff, map.get(diff) - 1);
				}
			}

			if (!map.containsKey(arr[i])) {
				map.put(arr[i], 1);
			} else {
				map.put(arr[i], map.get(arr[i]) + 1);
			}
		}

		return count;
	}

	public static int countPairs(int[] arr, int k) {
		int n = arr.length;
		Arrays.sort(arr);
		int count = 0;

		int i = 0; 
		int j = n-1;
//		while( i < j && j >=0) {
//			System.out.println(i+" "+j);
//
//			int sum = Math.abs(arr[i]-arr[j]) + Math.abs(arr[i]+arr[j]);
//
//
//			if( sum == k ) {
//				count++;
//				//				while( i < j && arr[i] == arr[i+1]) i++;
//				//				while( i < j && arr[j] == arr[j-1]) j--;
//			}
//			else if( sum < k ) {
//				i++;
//			}else {
//				j--;
//			}
//		}
		return count;
	}
	public static int countPairs2(int[] arr, int k) {
		int n = arr.length;
		int count = 0;
		for(int i=0;i<n;i++) {
			for(int j =i+1; j<n;j++) {
				int sum = Math.abs(arr[i]-arr[j]) + Math.abs(arr[i]+arr[j]);
				if( sum == k )count++;
			}
		}
		return count;
	}

	public static void main(String[] args) {
		int arr1[] = {-1, 0,1, 3, 5}, k1 = 2;
		int arr2[] = {-2, -1, 0, 1, 2}, k2 = 3;
		int arr3[] = {-5, -2, 3, 5}, k3 = 10;
		int arr4[] = {-100, 0, 100}, k4 = 100;
		int arr5[] = {-1, 0, 1, 2}, k5 = 0;

		System.out.println(countPairsMap(arr1, k1)+" "+ countPairs(arr1, k1) +" " +countPairs2(arr1, k1));
		System.out.println(countPairs(arr2, k2) +" " +countPairs2(arr2, k2));
		System.out.println(countPairs(arr3, k3) +" " +countPairs2(arr3, k3));
		System.out.println(countPairs(arr4, k4) +" " +countPairs2(arr4, k4));
		System.out.println(countPairs(arr5, k5) +" " +countPairs2(arr5, k5));


	}
}
