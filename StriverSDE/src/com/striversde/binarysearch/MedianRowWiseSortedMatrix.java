package com.striversde.binarysearch;

public class MedianRowWiseSortedMatrix {
	public static int findMedian(int matrix[][], int m, int n) {
		long low = 1;
		long high = 1000000000;
		long half = (m*n)/2;
		while( low <= high ) {
			long mid = (low+high)/2;
			long countElemLessThanMid = countElementsLessThan(mid,matrix);
			if ( countElemLessThanMid <= half ) {
				low = mid + 1;
			}else {
				high = mid - 1;
			}
		}
		return (int)low;
	}

	private static int countElementsLessThan(long mid, int[][] matrix) {
		int count = 0;
		for(int[] row : matrix) {
			count = count + countElemLessThanInRow(row,mid);
		}
		return count;
	}

	private static int countElemLessThanInRow(int[] row,long target) {
		int low = 0;
		int high = row.length-1;
		while( low <= high ) {
			int mid = (low+high)/2;
			if ( row[mid] <= target ) {
				low = mid+1;
			}else {
				high = mid - 1;
			}
		}
		return low;
	}

}
