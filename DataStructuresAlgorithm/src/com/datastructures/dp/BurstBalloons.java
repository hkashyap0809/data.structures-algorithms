package com.datastructures.dp;

import java.util.Arrays;

public class BurstBalloons {
	
	private static int maxCoinsRec(int i, int j, int[] a) {
		if ( i > j )	return 0;
		
		int maxCost = Integer.MIN_VALUE;
		for ( int idx = i; idx <=j; idx++) {
			int cost = a[idx] * a[i-1] * a[j+1] + maxCoinsRec(i, idx-1, a) + maxCoinsRec(idx+1, j, a);
			maxCost = Math.max(maxCost, cost);
		}
		return maxCost;
	}
	public static int maxCoinsRec(int a[]) {
		int[] balloons = new int[a.length+2];
		balloons[0]=1;
		for(int i=0;i<a.length;i++) {
			balloons[i+1] = a[i];
		}
		balloons[balloons.length-1] = 1;
		return maxCoinsRec(1,balloons.length-2,balloons);
	}
	//Memoization
	private static int maxCoinsMem(int i, int j, int[] a,int[][] dp) {
		if ( i > j )	return 0;
		if ( dp[i][j] != -1 )	return dp[i][j];
		
		int maxCost = Integer.MIN_VALUE;
		for ( int idx = i; idx <=j; idx++) {
			int cost = a[idx] * a[i-1] * a[j+1] + maxCoinsMem(i, idx-1, a,dp) + maxCoinsMem(idx+1, j, a,dp);
			maxCost = Math.max(maxCost, cost);
		}
		dp[i][j] = maxCost;
		return maxCost;
	}
	public static int maxCoinsMem(int a[]) {
		int[] balloons = new int[a.length+2];
		balloons[0]=1;
		for(int i=0;i<a.length;i++) {
			balloons[i+1] = a[i];
		}
		balloons[balloons.length-1] = 1;
		int[][] dp =new int[balloons.length][balloons.length];
		for(int i=0;i<dp.length;i++)
			Arrays.fill(dp[i], -1);
		return maxCoinsMem(1,balloons.length-2,balloons,dp);
	}
	//Tabulation
	public static int maxCoins(int a[]) {
		int[] balloons = new int[a.length+2];
		balloons[0]=1;
		for(int i=0;i<a.length;i++) {
			balloons[i+1] = a[i];
		}
		balloons[balloons.length-1] = 1;
		int[][] dp =new int[balloons.length][balloons.length];
		int n = balloons.length;
		
		for(int i = n-2; i>=1; i--) {
			for(int j = i; j<=n-2;j++) {
				
				int maxCost = Integer.MIN_VALUE;
				for ( int idx = i; idx <=j; idx++) {
					int cost = balloons[idx] * balloons[i-1] * balloons[j+1] + dp[i][idx-1] + dp[idx+1][j];
					maxCost = Math.max(maxCost, cost);
				}
				dp[i][j] = maxCost;
			}
		}
		return dp[1][n-2];
	}
}
