package com.a2zdsa.arrays.hard;

import java.util.HashMap;

public class LargestSubarrayLengthWith0Sum {
	public static int getLongestZeroSumSubarrayLength(int []arr){
		// Write your code here.
		HashMap<Integer,Integer> hashMap = new HashMap<>();
		int prefixSum = 0;
		int maxLen = 0;

		for( int i = 0; i< arr.length; i++ ){
			prefixSum = prefixSum + arr[i];

			if( prefixSum == 0 ) maxLen = Math.max(maxLen, i+1);

			if( hashMap.containsKey ( prefixSum )){
				maxLen = Math.max( maxLen, i - hashMap.get(prefixSum) );
			}

			if( !hashMap.containsKey(prefixSum) ){
				hashMap.put(prefixSum,i);
			}
		}
		return maxLen;
	}
}
