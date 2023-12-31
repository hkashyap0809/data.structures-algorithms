package com.datastructures.binarysearch;

public class LowerUpperBound {
	public static int lowerBound(int []arr, int n, int x) {
		int low = 0;
		int high = arr.length-1;
		int res = arr.length;
		while ( low <= high ) {
			int mid = ( low + high )/2;
			if ( arr[mid]>=x) {
				res = mid;
				high = mid - 1;
			}else {
				low = mid+1;
			}
		}
		return res;
	}

	public static int upperBound(int []arr, int x, int n){
		int low = 0;
		int high = arr.length - 1;
		while( low <= high ) {
			int mid = (low + high)/2;
			if ( arr[mid] <= x) {
				low = mid +1;
			}else {
				high = mid - 1;
			}
		}
		return low;
	}

}
