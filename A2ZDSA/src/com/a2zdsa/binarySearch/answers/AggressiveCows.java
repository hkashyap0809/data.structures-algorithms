package com.a2zdsa.binarySearch.answers;

import java.util.Arrays;

public class AggressiveCows {
	
	// stalls = [ 0 , 3 , 4 , 7 , 9 , 10] , k = 3
	// low = 0 , high = 10 , mid = 5 , cP = 2 
	// low = 0, high = 4 , mid = 2, cP = 3
	// low = 3 high = 4, mid = 3, cP = 3
	// low = 4 high = 4, mid = 4 cP = 3
	// low = 5 high = 4, m
	public static int aggressiveCows(int []stalls, int k) {
		
		Arrays.sort(stalls);
		
		int n = stalls.length;
		int low = 0 ;
		int high = stalls[n-1] - stalls[0];
		
		
		while( low <= high ) {
			
			int mid = (low+high)/2;
			
			int cowsPlaced = getCountOfCowsPlaced(stalls,mid);
			if( cowsPlaced >= k ) {
				//can place more than the required number  of cows
				low = mid + 1;
			}else {
				high = mid - 1;
			}
		}
		return high;		
		
	}

	private static int getCountOfCowsPlaced(int[] stalls, int mid) {
		int cowsPlaced = 1;
		int lastCowPlacedAt = stalls[0];
		
		for( int i =1; i< stalls.length; i++ ) {
			if( stalls[i] - lastCowPlacedAt >= mid ) {
				cowsPlaced++;
				lastCowPlacedAt = stalls[i];
			}
		}
		return cowsPlaced;
	}

}
