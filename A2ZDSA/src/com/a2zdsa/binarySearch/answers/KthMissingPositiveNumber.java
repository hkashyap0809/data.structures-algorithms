package com.a2zdsa.binarySearch.answers;

public class KthMissingPositiveNumber {
	
	public int findKthPositiveLinear(int[] arr, int k) {

		int len = arr.length;
		for( int i = 0; i< len ;i++ ){
			if( arr[i] <= k ){
				k++;
			}else{
				return k;
			}
		}
		return k;
	}
	
	

}
