package com.striversde.arrays4;

import java.util.HashMap;

public class TwoSum {
	public int[] twoSum(int[] nums, int target) {
		HashMap<Integer,Integer> hashMap = new HashMap<>();
		int[] result = new int[2];
		for(int i=0;i<nums.length;i++)        {

			if ( hashMap.containsKey(target - nums[i]) ){
				result[0] = hashMap.get(target - nums[i]);
				result[1] = i;
			}else{
				hashMap.put(nums[i],i);
			}
		}
		return result;
	}
}
