package com.a2zdsa.binarySearch.arrays;

import java.util.ArrayList;

public class SearchInRotatedSortedArray1 {
	public static int search(ArrayList<Integer> arr, int n, int k) {
		int low = 0;
		int high = arr.size() - 1;

		while( low <= high ) {
			int mid = (low+high)/2;
			if( arr.get(mid) <= arr.get(high) ) {
				//left side is sorted
				if( k >= arr.get(low) && k<= arr.get(mid) ) {
					high = mid - 1;
				}else {
					low = mid + 1;
				}
			}else {
				//right side is sorted
				if( k>= arr.get(mid) && k<= arr.get(high) ) {
					low = mid + 1;
				}else {
					high = mid - 1;
				}
			}
		}

		return low;
	}
}
