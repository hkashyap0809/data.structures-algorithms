package com.striversde.arrays4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LargestSubarraySumK {


	//Brute
	public static int LongestSubsetWithZeroSumBrute(ArrayList<Integer> arr) {

		int maxLen = 0;
		int n = arr.size();
		for(int i = 0; i < n; i++ ) {
			for(int j = i; j < n; j++ ) {
				int sum = 0;
				for(int k=i; k<=j ; k++) {
					sum = sum + arr.get(k);
					if ( sum == 0 ) {
						maxLen = Math.max(maxLen, j-i+1);
					}
				}
			}
		}
		return maxLen;
	}

	//Brute - 2
	public static int LongestSubsetWithZeroSumBrute2(ArrayList<Integer> arr) {

		int maxLen = 0;
		int n = arr.size();
		for(int i = 0; i < n; i++ ) {
			int sum = 0;
			for(int j = i; j < n; j++ ) {
				sum = sum + arr.get(j);
				if ( sum == 0 ) {
					maxLen = Math.max(maxLen, j-i+1);
				}
			}
		}
		return maxLen;
	}

	//Better for negatives and zeroes
	public static int LongestSubsetWithZeroSum(ArrayList<Integer> arr) {
		HashMap<Long,Integer> prefixSumMap = new HashMap<>();
		int n = arr.size();
		int maxLen = 0;
		long sum = 0;
		int target = 0;

		for( int i = 0; i< n;i++) {

			sum = sum + arr.get(i);

			if ( sum == target ){
				maxLen = Math.max(maxLen,i+1);
			}

			if ( prefixSumMap.containsKey( sum - target ) ) {
				int mapIdx = prefixSumMap.get( sum - target);
				maxLen = Math.max(maxLen, i - mapIdx);
			}

			if ( !prefixSumMap.containsKey(sum) ) {
				prefixSumMap.put(sum,i);
			}
		}
		return maxLen;

	}
	//Optimal for positives with sum k
	public static int longestSubarrayWithSumK(int []a, long k) {
		int maxLen = 0;
		int right = 0;
		int left = 0;
		int n = a.length;
		long sum = 0;
		while ( right < n ) {
			sum = sum + a[right];


			while( sum > k ) {
				sum = sum - a[left];
				left++;
			}
			if ( sum == k ) {
				maxLen = Math.max(maxLen, right - left + 1 );
			}
			right++;
		}
		return maxLen;
	}
	
}
