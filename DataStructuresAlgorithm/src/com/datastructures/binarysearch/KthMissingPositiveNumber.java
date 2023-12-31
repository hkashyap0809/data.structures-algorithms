package com.datastructures.binarysearch;

public class KthMissingPositiveNumber {


	//Linear - Brute
	public int findKthPositiveBrute(int[] nums, int k) {
		for(int num : nums ) {
			if(num<=k) k++;
			else
				return k;
		}
		return k;
	}

	//Binary Search
	public int findKthPositive(int[] nums, int k) {
		int low = 0;
		int high = nums.length - 1;
		while( low <= high ) {
			int mid = (low+high)/2;
			int missing = nums[mid] - ( mid + 1 );

			if ( missing < k ) {
				low = mid + 1;
			}else {
				high = mid - 1; 
			}

		}

		//return high + k + 1;
		return low+k;
	}	

}
