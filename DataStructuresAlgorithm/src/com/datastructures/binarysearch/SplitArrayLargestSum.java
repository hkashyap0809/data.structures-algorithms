package com.datastructures.binarysearch;

public class SplitArrayLargestSum {
	public int splitArray(int[] nums, int k) {
		int low = nums[0];
		int high = 0;

		for( int num : nums ) {
			low = Math.max(low, num);
			high = high + num ;
		}
		while( low <= high ) {
			int mid = ( low + high )/2;
			int sumAllocatedTo = sumAllocatedHelper(nums,mid);
			if( sumAllocatedTo > k ) {
				low = mid + 1;
			}else {
				high = mid - 1;
			}
		}
		return low;

	}

	private int sumAllocatedHelper(int[] nums, int mid) {
		int allocated = 1;
		int lastAllocated = nums[0];
		for(int i=1;i<nums.length;i++) {
			if(lastAllocated + nums[i] > mid ) {
				allocated++;
				lastAllocated = nums[i];
			}else {
				lastAllocated = lastAllocated + nums[i];
			}
		}
		return allocated;
	}

}
