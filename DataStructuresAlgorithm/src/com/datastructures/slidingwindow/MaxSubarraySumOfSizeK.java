package com.datastructures.slidingwindow;

public class MaxSubarraySumOfSizeK {
	public static int maxSubarraySum(int[] arr, int k) {
		int i=0;
		int j=0;
		int res = Integer.MIN_VALUE;
		int sum =0;
		while( j< arr.length ) {
			sum = sum + arr[j];
			if ( j-i+1 < k ) {
				j++;
			}else if ( j-i+1 == k ) {
				res = Math.max(res, sum);
				sum = sum - arr[i];
				i++;
				j++;
			}
		}
		return res;
	}

}
