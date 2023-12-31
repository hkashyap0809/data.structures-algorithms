package com.datastructures.dp;

import java.util.Arrays;

public class RodCutting {
	
	public static int cutRodRec(int idx, int n, int[] price) {
		if ( idx == 0 )	{		
				return n * price[idx];
		}
				
		int notTake = cutRodRec(idx-1, n, price);
		int take = Integer.MIN_VALUE;
		if (  n >= (idx+1) )
			take = price[idx] +  cutRodRec(idx, n - (idx+1), price );
		
		return Math.max(take, notTake);
	}
	public static int cutRodRev(int price[], int n) {
		return cutRodRec(price.length-1, n, price);
	}
	
	//Memoization
	public static int cutRodMem(int idx, int n, int[] price,int[][] dp) {
		if ( idx == 0 )	{		
				return n * price[idx];
		}
		if ( dp[idx][n] != -1 )	return dp[idx][n];
				
		int notTake = cutRodMem(idx-1, n, price,dp);
		int take = Integer.MIN_VALUE;
		if (  n >= (idx+1) )
			take = price[idx] +  cutRodMem(idx, n - (idx+1), price ,dp);
		dp[idx][n] = Math.max(take, notTake);
		return Math.max(take, notTake);
	}
	public static int cutRodMem(int price[], int n) {
		int[][] dp = new int[n][n+1];
		for(int i=0; i<price.length;i++) {
			Arrays.fill(dp[i], -1);
		}
		return cutRodMem(price.length-1, n, price,dp);
	}
	//Tabulation
	public static int cutRodTab(int price[], int n) {
		int[][] dp = new int[n][n+1];
		
		for ( int j=0; j<=n; j++) {
			dp[0][j] = j * price[0];
		}
		
		for(int idx = 1; idx < n; idx++) {
			for(int rodLen = 0; rodLen<=n; rodLen ++ ){
				int notTake = dp[idx-1][rodLen];
				int take = Integer.MIN_VALUE;
				if (  rodLen >= (idx+1) )
					take = price[idx] +  dp[idx][rodLen - (idx+1) ];
				
				dp[idx][rodLen] = Math.max(take, notTake);
			}
		}
		return dp[n-1][n];
	}
	//Space Optimization
	public static int cutRod(int price[], int n) {
		int[] prevDp = new int[n+1];
		
		for ( int j=0; j<=n; j++) {
			prevDp[j] = j * price[0];
		}
		
		for(int idx = 1; idx < n; idx++) {
			int[] currDp = new int[n+1];
			for(int rodLen = 0; rodLen<=n; rodLen ++ ){
				int notTake = prevDp[rodLen];
				int take = Integer.MIN_VALUE;
				if (  rodLen >= (idx+1) )
					take = price[idx] +  currDp[rodLen - (idx+1) ];
				
				currDp[rodLen] = Math.max(take, notTake);
			}
			prevDp = currDp;
		}
		return prevDp[n];
	}
	
	
}
