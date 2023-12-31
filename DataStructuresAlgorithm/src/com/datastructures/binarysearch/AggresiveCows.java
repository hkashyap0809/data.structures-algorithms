package com.datastructures.binarysearch;

import java.util.Arrays;

public class AggresiveCows {

	//Linear Search
	public static int aggressiveCowsLinear(int []stalls, int k) {
		Arrays.sort(stalls);

		int n = stalls.length;
		int ans = Integer.MIN_VALUE;
		for(int i = 1; i<=stalls[n-1] - stalls[0]; i++){
			if ( canWePlace(stalls, k, i))
				ans = Math.max(ans,i);
			else
				break;
		}
		return ans;
	}

	//Binary Search - Optimal
	public static int aggressiveCowsBinary(int []stalls, int k) {
		Arrays.sort(stalls);

		int n = stalls.length;
		int low = 1;

		int high = stalls[n-1] - stalls[0];
		int ans = Integer.MIN_VALUE;

		while( low <= high ){
			int mid = ( low + high )/2;

			if ( canWePlace(stalls, k, mid) == true){
				ans = Math.max( ans, mid);
				low = mid + 1;
			}else{
				high = mid - 1;
			}
		}

		return ans;

	}

	public static boolean canWePlace(int[] stalls, int k, int dist){
		int lastCoOrdinate = stalls[0];
		int cowsPlaced = 1;

		for(int i = 1; i<stalls.length; i++){

			if ( stalls[i] - lastCoOrdinate >= dist ){
				cowsPlaced++;
				lastCoOrdinate = stalls[i];
			}
			if ( cowsPlaced == k )  return true;
		}
		return false;
	}

}


