package com.a2zdsa.arrays.medium;

import java.util.HashMap;

public class CountSubarraySumEqualK {
	public int subarraySum(int[] nums, int k) {

		int prefixSum = 0;
		int count = 0;
		HashMap<Integer,Integer> hashMap = new HashMap<>();

		hashMap.put(prefixSum,1);

		for( int num : nums ){
			prefixSum = prefixSum + num;

			if( hashMap.containsKey( prefixSum - k ) ){
				count = count + hashMap.get(prefixSum-k);
			}
			hashMap.put(prefixSum,hashMap.getOrDefault(prefixSum,0)+1);
		}
		return count;
	}

}
