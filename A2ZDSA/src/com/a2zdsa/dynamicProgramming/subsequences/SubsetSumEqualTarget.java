package com.a2zdsa.dynamicProgramming.subsequences;

import java.util.Arrays;

public class SubsetSumEqualTarget {
	public static boolean subsetSumToKHelper(int idx, int[] arr, int k, int[][] dp){

		if( k == 0 )    return true;
		if( idx == arr.length-1 ){
			return arr[idx] == k ;
		}
		if( dp[idx][k] != -1 )  return dp[idx][k] == 1 ? true : false;

		boolean notTake = subsetSumToKHelper(idx+1, arr, k,dp);

		boolean take = false;
		if( k >= arr[idx] )
			take = subsetSumToKHelper(idx+1, arr, k - arr[idx], dp);

		dp[idx][k] = take||notTake == true ? 1 : 0;

		return take||notTake;
	}
	public static boolean subsetSumToK(int n, int k, int arr[]){
		int[][] dp = new int[n][k+1];
		for( int[] row : dp )   Arrays.fill( row, -1 );
		return subsetSumToKHelper(0,arr,k,dp);
	}

	public static boolean subsetSumToK1( int n, int target, int arr[]){
		boolean[][] dp = new boolean[n][target+1];

		for( int i = 0; i<=target ; i++ ){
			dp[0][i] = i == arr[0] ;
		}
		for( int i=0;i<n;i++)
			dp[i][0] = true;

		for( int idx = 1; idx < n ; idx++ ){
			for( int k = 0 ; k<=target; k++ ){

				boolean notTake = dp[idx-1][k];

				boolean take = false;
				if( k >= arr[idx] )
					take = dp[idx-1][k - arr[idx]];

				dp[idx][k] = take||notTake;
			}
		}
		return dp[n-1][target];
	}


}
