package com.a2zdsa.binarySearch.arrays;

public class FindMinInRotatedSortedArray {
	public int findMin(int[] nums) {
		if( nums.length == 1 )  return nums[0];
		int low = 0;
		int high = nums.length - 1;

		if( nums[low] < nums[high] )    return nums[low];
		while( low <= high ){
			int mid = (low+high)/2;

			if( nums[mid+1] < nums[mid] )   return nums[mid+1];
			if( nums[mid-1] > nums[mid] ) return nums[mid];

			if( nums[mid] > nums[high] ){
				low = mid + 1;
			}else{
				high = mid - 1;
			}

		}
		return nums[low];

	}

}
