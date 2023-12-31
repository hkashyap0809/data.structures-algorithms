package com.a2zdsa.arrays.medium;

import java.util.ArrayList;

public class PrintMaxSubarray {
	public int maxSubArray(int[] nums) {
		int maxSum = Integer.MIN_VALUE;
		int sum = 0;

		int start = 0;
		int finalStart = 0;
		int end = -1; 

		for( int i=0; i < nums.length; i++ ){
			sum = sum + nums[i];

			if( sum > maxSum ){
				maxSum = Math.max(sum, maxSum);
				finalStart = start;
				end = i;
			}
			if( sum < 0 ){
				//sum goes negative -> need to start again
				start = i+1;
				sum = 0;
			}
		}

		ArrayList<Integer> maxSubarray = new ArrayList<>();

		maxSum = 0;
		for( int i = finalStart ; i <= end; i++ ){
			maxSum = maxSum + nums[i];
			maxSubarray.add(nums[i]);
		}
		System.out.println(maxSubarray.toString());

		return maxSum;
	}

}
