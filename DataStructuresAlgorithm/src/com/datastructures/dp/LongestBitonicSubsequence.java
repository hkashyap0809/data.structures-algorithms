package com.datastructures.dp;

import java.util.Arrays;

public class LongestBitonicSubsequence {
	public static int longestBitonicSequence(int[] arr, int n) {

		int[] dp1 = new int[n];
		int[] dp2 = new int[n];


		Arrays.fill(dp1, 1);
		Arrays.fill(dp2, 1);


		for(int i=0; i<n;i++) {
			for(int j=0; j<i; j++) {
				if( arr[j] < arr[i] && dp1[i] < 1 + dp1[j]) {
					dp1[i] = 1+ dp1[j];
				}
			}
		}
		for(int i=0;i<n;i++)
			System.out.print(dp1[i]+"  ");

		int result = 1;
		for(int i=n-1; i>=0;i--) {
			for(int j=n-1; j>i; j--) {
				if( arr[j] < arr[i] && dp2[i] < 1 + dp2[j]) {
					dp2[i] = 1+ dp2[j];
				}
			}
			dp1[i] = dp1[i] + dp2[i] - 1 ;
			result = Math.max(result, dp1[i]);
		}
		return result;
	}
	public static void main(String[] args) {
		int[] arr = {1,5,4,3,2,6,7,10,8,9};
		for(int i=0;i<arr.length;i++) 
			System.out.print(arr[i]+"  ");
		System.out.println();
		longestBitonicSequence(arr,arr.length);
	}
}
