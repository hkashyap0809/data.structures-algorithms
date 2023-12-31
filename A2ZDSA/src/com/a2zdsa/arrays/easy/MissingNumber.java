package com.a2zdsa.arrays.easy;

public class MissingNumber {
	public int missingNumber(int[] nums) {

		int n = nums.length;

		long total = 0;
		for(int num : nums ){
			total = total + num;
		}

		long sum = (n*(n+1))/2;
		return (int)(sum - total);

	}
}
