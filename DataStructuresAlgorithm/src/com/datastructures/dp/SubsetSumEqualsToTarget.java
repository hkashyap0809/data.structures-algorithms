package com.datastructures.dp;

import java.util.Arrays;

public class SubsetSumEqualsToTarget {
	//Recursion
	public static boolean subsetSumRec(int idx, int k, int[] arr){
		if ( k==0 ) return true;
		if ( idx == 0 ) return ( arr[0] == k );

		boolean notTake = subsetSumRec(idx-1, k, arr);
		boolean take = false;
		if( k >= arr[idx])
			take = subsetSumRec(idx-1, k - arr[idx], arr);

		return take || notTake;
	}
	public static boolean subsetSumToKRec(int n, int k, int arr[]){
		return subsetSumRec(n-1,k,arr);
	}

	//    Memoization
	public static boolean subsetSumMem(int idx, int k, int[] arr,int[][] dp){
		if ( k==0 ) return true;
		if ( idx == 0 ) return ( arr[0] == k );
		if (dp[idx][k] != -1 && dp[idx][k]==1) return true;
		if (dp[idx][k] != -1 && dp[idx][k]==0)  return false;


		boolean notTake = subsetSumMem(idx-1, k, arr,dp);
		boolean take = false;

		if( k >= arr[idx])
			take = subsetSumMem(idx-1, k - arr[idx], arr,dp);

		if (take || notTake ) 
			dp[idx][k] = 1;
		else
			dp[idx][k] = 0;

		return take || notTake;
	}
	public static boolean subsetSumToKMem(int n, int k, int arr[]){
		int[][] dp = new int[n][k+1];
		for(int i=0;i<dp.length;i++)
			Arrays.fill(dp[i],-1);

		return subsetSumMem(n-1,k,arr,dp);
	}

	//    Tabulation
	public static boolean subsetSumToKTab(int n, int k, int arr[]){
		boolean[][] dp = new boolean[n][k+1];

		for(int i=0;i<dp.length;i++)
			Arrays.fill(dp[i],false);
		
		if ( arr[0] <= k)		dp[0][arr[0]] = true;

		for(int i=0;i<n;i++)
			dp[i][0] = true;

		for(int i=1;i<n;i++){
			for(int j=1;j<=k;j++){
				boolean notTake = dp[i-1][j];
				boolean take = false;
				if( j >= arr[i])
					take = dp[i-1][j-arr[i]];
				dp[i][j] = take || notTake;
			}
		}
		return dp[n-1][k];
	}
	//Space Optimization
	public static boolean subsetSumToK(int n, int k, int arr[]){
		boolean[] prevDp = new boolean[k+1];
		Arrays.fill(prevDp,false);

		for(int j=0;j<=k; j++)
			prevDp[j] = (arr[0] == j);

		// for(int i=0;i<n;i++)
		prevDp[0] = true;

		for(int i=1;i<n;i++){
			boolean[] currDp = new boolean[k+1];
			currDp[0] = true;
			for(int j=1;j<=k;j++){
				boolean notTake = prevDp[j];
				boolean take = false;
				if( j >= arr[i])
					take = prevDp[j-arr[i]];
				currDp[j] = take || notTake;
			}
			prevDp = currDp;
		}
		return prevDp[k];
	}

}
