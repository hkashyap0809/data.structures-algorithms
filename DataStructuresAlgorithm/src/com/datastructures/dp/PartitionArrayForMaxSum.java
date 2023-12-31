package com.datastructures.dp;

import java.util.Arrays;

public class PartitionArrayForMaxSum {

	private static int maxSumPartitioningRec(int idx, int[] arr, int k) {
		if ( idx == arr.length )     return 0;

		int maxCost = Integer.MIN_VALUE;
		int maxElem = Integer.MIN_VALUE;
		int length = 0;
		for( int j = idx; j < Math.min( arr.length ,idx + k ); j++){
			length++;
			maxElem = Math.max( maxElem , arr[j] );
			int cost = (maxElem * length) + maxSumPartitioningRec(j+1 , arr , k);
			maxCost = Math.max( maxCost, cost );
		}

		return maxCost;
	}
	public static int maxSumAfterPartitioningRec(int[] arr, int k) {
		return maxSumPartitioningRec(0,arr,k);
	}
	
	//Memoization 
	public static int maxSumPartitioningMem(int idx, int[] arr, int k,int[] dp){

		if ( idx == arr.length )     return 0;

		if( dp[idx] != -1 )	return dp[idx];

		int maxCost = Integer.MIN_VALUE;
		int maxElem = Integer.MIN_VALUE;
		int length = 0;
		for( int j = idx; j < Math.min( arr.length ,idx + k ); j++){
			length++;
			maxElem = Math.max( maxElem , arr[j] );
			int cost = maxElem * length + maxSumPartitioningMem(j+1 , arr , k, dp);
			maxCost = Math.max( maxCost, cost );
		}
		dp[idx] = maxCost;
		return maxCost;
	}
	public static int maxSumAfterPartitioningMem(int[] arr, int k) {
		int[] dp =new int[arr.length];
		Arrays.fill(dp, -1);
		return maxSumPartitioningMem(0,arr,k,dp);
	}
	//Tabulation
	public static int maxSumAfterPartitioning(int[] arr, int k) {
		int[] dp = new int[arr.length + 1];

		for(int idx = arr.length - 1; idx >=0; idx--) {
			int maxCost = Integer.MIN_VALUE;
			int maxElem = Integer.MIN_VALUE;
			int length = 0;
			for( int j = idx; j < Math.min( arr.length ,idx + k ); j++){
				length++;
				maxElem = Math.max( maxElem , arr[j] );
				int cost = maxElem * length + dp[j+1];
				maxCost = Math.max( maxCost, cost );
			}
			dp[idx] = maxCost;
		}
		return dp[0];
	}

}
