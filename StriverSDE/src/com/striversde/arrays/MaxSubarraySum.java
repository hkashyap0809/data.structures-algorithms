package com.striversde.arrays;

public class MaxSubarraySum {
	public int maxSubArray(int[] nums) {
		int result = Integer.MIN_VALUE;
		int sum = 0;
		for( int i=0;i<nums.length;i++){
			sum+=nums[i];
			result = Math.max(result,sum);
			if ( sum < 0 )  sum = 0;
		}
		return result;
	}
	//Print max subarray sum
	public void printMaxSubArray(int[] nums) {
		int result = Integer.MIN_VALUE;
		int sum = 0;

		int start = -1;
		int end = -1;
		int sum0 = 0;
		for(int i=0; i<nums.length; i++){
			if (sum == 0 )	sum0 = i;
			sum = sum + nums[i];
			if ( result < sum ) {
				result = sum;
				start = sum0; 
				end = i;
			}
			result = Math.max(result,sum);

			if( sum < 0 ) sum = 0;
		}

		for( int i= start; i<=end; i++) {
			System.out.print(nums[i]+" ");
		}
	}
}
