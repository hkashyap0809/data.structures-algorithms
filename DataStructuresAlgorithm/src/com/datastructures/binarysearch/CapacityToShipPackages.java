package com.datastructures.binarysearch;

public class CapacityToShipPackages {
	public int shipWithinDays(int[] weights, int days) {
		int low = 0;
		int high = 0;
		for(int weight : weights ) {
			low = Math.max(low, weight);
			high = high + weight;
		}
		
		while( low <= high ) {
			int mid = (low + high)/2;
			
			int daysReq = getRequiredDays(weights,mid);
			
			if( daysReq <= days ) {
				high = mid - 1;
			}else {
				low = mid + 1;
			}
		}
		return low;

	}

	private int getRequiredDays(int[] weights, int capacity) {
		int days = 1;
		int currLoad = 0;
		for(int weight : weights ) {
			
			if( currLoad + weight > capacity ) {
				days++;
				currLoad = weight;
			}else {
				currLoad = currLoad + weight;
			}
		}
		
		return days;
	}
}
