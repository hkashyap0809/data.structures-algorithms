package com.datastructures.binarysearch;

public class SmallestDivisorGivenThreshold {

	public int smallestDivisor(int[] nums, int threshold) {
		int low = 1;
		int high = nums[0];
		for(int num : nums ) {
			high = Math.max(high, num);
		}

		while( low <= high ) {
			int mid = (low +high )/2;
			int total = getThreshold(nums,mid);			
			if( total <= threshold ) {
				high = mid - 1 ;
			}else {
				low = mid + 1;
			}
		}
		return low;

	}

	private int getThreshold(int[] nums, int mid) {
		double total = 0;
		for(int num : nums ) {
			total = total + Math.ceil((double)num/(double)mid);
		}
		return (int)total;
	}
}
