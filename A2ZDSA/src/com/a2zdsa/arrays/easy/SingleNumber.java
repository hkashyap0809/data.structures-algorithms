package com.a2zdsa.arrays.easy;

public class SingleNumber {
	public int singleNumber(int[] nums) {
		int res = 0;
		for(int num : nums){
			res = res ^ num;
		}
		return res;
	}

}
