package com.a2zdsa.arrays.medium;

import java.util.HashMap;

public class TwoSum {
	public int[] twoSum(int[] nums, int target) {
		HashMap<Integer,Integer> hashMap = new HashMap<>();

		int len = nums.length;

		for(int i=0; i<len; i++ ){
			if( hashMap.containsKey(target - nums[i]) ){
				return new int[]{i, hashMap.get(target-nums[i])};
			}
			hashMap.put(nums[i],i);
		}
		return new int[]{-1,-1};
	}
}
