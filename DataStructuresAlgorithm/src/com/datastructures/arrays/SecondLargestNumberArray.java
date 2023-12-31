package com.datastructures.arrays;

public class SecondLargestNumberArray {
	public int print2largest(int arr[], int n) {
		int largest = arr[0];
		//change if negative numbers are present
		int secondLargest = -1;

		for(int num : arr ) {
			if ( num > largest ) {
				secondLargest = largest;
				largest = num;
			}else if ( num < largest && num > secondLargest) {
				secondLargest = num;
			}
		}
		return secondLargest;
	}

}
