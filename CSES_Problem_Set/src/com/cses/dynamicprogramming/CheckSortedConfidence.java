package com.cses.dynamicprogramming;

public class CheckSortedConfidence {
	
	private static boolean checkSorted(long[] arr, long len) {
		
		for( int i =0; i< len-1; i++) {
			if( arr[i] > arr[i+1] )	return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		long[] arr = {3,4,5,3,56,7,3,5,7,3,4};
		double confidenceNum = 0.1;
		// here assuming that confidence number is the percentage of the length of 
		// array which is sorted
		long newLen =(long) (arr.length * confidenceNum);
		System.out.println(checkSorted(arr,newLen));
	}

}
