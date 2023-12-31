package com.a2zdsa.binarySearch.arrays;

public class SearchInRotatedSortedArray2 {
	public static boolean searchInARotatedSortedArrayII(int []nums, int key) {
		int low = 0;
		int high = nums.length - 1;

		while( low <= high && nums[low] == nums[high] ){
			if( nums[low] == key )  return true;
			low++;
			high--;
		}

		while( low <= high ){
			int mid = (low+high)/2;


			if( nums[mid] == key )  return true;

			if( nums[mid] >= nums[low]){

				if( key >= nums[low] && key <= nums[mid] ){
					high = mid - 1;
				}else{
					low = mid + 1;
				}
			}else{
				if( key >= nums[mid] && key <= nums[high] ){
					low = mid + 1;
				}else{
					high = mid - 1;
				}
			}
		}
		return false;
	}

}
