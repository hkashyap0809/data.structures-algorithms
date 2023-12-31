package com.a2zdsa.arrays.easy;

import java.util.HashMap;

public class LongestSubarrayWithGivenSum {
	//Brute

	//Better
	public static int longestSubarrayWithSumKBetter(int []a, long t) {
		int maxLen = 0;
		int n = a.length;
		for(int i = 0; i < n; i++ ) {
			long sum = 0;
			for(int j = i; j < n; j++ ) {
				sum = sum + a[j];
				if ( sum == t ) {
					maxLen = Math.max(maxLen, j-i+1);
				}
			}
		}
		return maxLen;
	}

	//Hashing -> positives + negatives
	public static int longestSubarrayWithSumKHash(int []nums, long k) {
		HashMap<Long,Integer> hashMap = new HashMap<>();

		int len = nums.length;
		long prefixSum = 0;
		long maxLen = 0;

		for( int i = 0; i < len; i++ ){
			prefixSum = prefixSum + nums[i];
			if( prefixSum == k )    maxLen = Math.max(maxLen, i+1);

			if( hashMap.containsKey(prefixSum - k) )
				maxLen = Math.max( maxLen, i - hashMap.get(prefixSum-k)  );

			if( !hashMap.containsKey(prefixSum))
				hashMap.put( prefixSum,i );
		}
		return (int)maxLen;
	}


	//Sliding window -> best for positives
	public static int longestSubarrayWithSumKSlidingWindow(int[] nums, long k){
		int i = 0;
		int j = 0;
		int maxLen = -1;
		int len = nums.length;
		long sum = 0;
		while( j < len ){
			sum = sum + nums[j];

			while( sum > k ){
				sum = sum - nums[i];
				i++;
			}
			if( sum == k ){
				maxLen = Math.max(maxLen, j - i + 1);
			}
			j++;
		}
		return maxLen;
	}


}
