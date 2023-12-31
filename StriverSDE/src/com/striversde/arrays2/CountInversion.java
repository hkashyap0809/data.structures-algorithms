package com.striversde.arrays2;

public class CountInversion {
	
	private static long countInversion(int start, int end, long[] arr) {

		if ( start < end ) {
			int inversion = 0;
			int mid = ( start + end )/2;
			inversion += countInversion(start, mid, arr);
			inversion += countInversion(mid+1, end, arr);
			inversion += mergeAndCountInversion(start, mid, end, arr);
			return inversion;
		}else {
			return 0;
		}
		
	}
	
	private static long mergeAndCountInversion(int start, int mid, int end, long[] arr) {
		long[] sortedArr = new long[end - start + 1];
		
		int inversion = 0;
		int i = start;
		int j = mid+1; 
		int k = 0;
		
		while ( i <= mid && j <= end) {
			
			if ( arr[i] > arr[j] ) {
				sortedArr[k++] = arr[j++];
				inversion = inversion + (mid - i + 1);
			}else {
				sortedArr[k++] = arr[i++];
			}
			
		}
		while ( i <= mid ) {
			sortedArr[k++] = arr[i++];
		}
		while ( j <= end ) {
			sortedArr[k++] = arr[j++];
		}
		
		for( int x=0;x<sortedArr.length;x++) {
			arr[start + x ] = sortedArr[x];
		}
		
		return inversion;
	}
	public static long getInversions(long arr[], int n) {
		return countInversion(0,n-1,arr);
	}
}
