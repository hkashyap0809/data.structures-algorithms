package com.datastructures.dp;

public class PartitionMinimumSubsetSumDifference {
	public static int minSubsetSumDifference(int[] arr, int n) {
		int totalSum = 0;
		for(int i=0;i<arr.length;i++) {
			totalSum +=arr[i];
		}
		
		boolean[] prevDp = new boolean[totalSum+1];
		
		if(arr[0]<= totalSum) prevDp[arr[0]] = true;
		prevDp[0] = true;
		
		for(int idx = 1;idx<arr.length;idx++) {
			boolean[] currDp =new boolean[totalSum+1];
			currDp[0] = true;
			for(int tar = 1; tar<=totalSum; tar++) {
				boolean notTake = prevDp[tar];
				boolean take = false;
				if( tar >= arr[idx] )
					take = prevDp[tar - arr[idx]];
				
				currDp[tar] = take || notTake;
			}
			prevDp = currDp;
		}
		
		int minDiff = 10000;
		for(int i=0 ; i<prevDp.length;i++) {
			if(prevDp[i]==true) {
				int s1 = i;
				int s2 = totalSum - s1;
				minDiff = Math.min(minDiff, Math.abs(s2-s1));
			}
		}
		return minDiff;
	}
}
