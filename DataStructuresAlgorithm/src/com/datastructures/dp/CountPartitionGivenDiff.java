package com.datastructures.dp;

public class CountPartitionGivenDiff {
	public static int countPartitions(int n, int d, int[] arr) {
		int totalSum = 0;
		for(int i = 0; i<arr.length; i++) {
			totalSum += arr[i];
		}
		
		if ( (totalSum - d <= 0) || ((totalSum - d)%2 != 0) ) return 0;
		
		int target = ( totalSum - d ) / 2;
		
		
		int[] prevDp = new int[target+1];
		
		if ( arr[0] == 0) prevDp[0] = 2;
		else	prevDp[0] = 1;
		
		if( arr[0] !=0 && arr[0]<= target )	prevDp[arr[0]] = 1;
		
		
		for ( int idx = 1; idx <arr.length;idx++) {
			int[] currDp = new int[target+1];
			for(int tar = 0; tar <= target; tar++) {
				int notTake = prevDp[tar];
				int take = 0;
				if ( arr[idx] <= tar)
					take = prevDp[tar - arr[idx]];
				
				currDp[tar] = take + notTake;
				currDp[tar] = currDp[tar] % 1000000007;
			}
			prevDp = currDp;
		}
		return prevDp[target] % 1000000007;
	}
}
