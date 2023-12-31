package com.datastructures.dp;

import java.util.Arrays;

public class MatrixChainMultiplication {
	//Recursion
	private static int matrixMultiplicationRec(int i, int j, int[] arr) {

		if ( i==j )	return 0;

		int minSteps = Integer.MAX_VALUE;

		for(int k = i; k<=j-1;k++) {

			int steps = arr[i-1] * arr[k] * arr[j] + matrixMultiplicationRec(i, k, arr) + 
					matrixMultiplicationRec(k+1, j, arr);
			minSteps = Math.min(minSteps, steps);
		}

		return minSteps;
	}
	public static int matrixMultiplicationRec(int[] arr , int N) {
		return matrixMultiplicationRec(1,arr.length-1,arr);
	}
	//Memoization
	private static int matrixMultiplicationMem(int i, int j, int[] arr,int[][] dp) {

		if ( i==j )	return 0;

		int minSteps = Integer.MAX_VALUE;

		if ( dp[i][j] != -1 ) return dp[i][j];

		for(int k = i; k<=j-1;k++) {

			int steps = arr[i-1] * arr[k] * arr[j] + matrixMultiplicationMem(i, k, arr,dp) + 
					matrixMultiplicationMem(k+1, j, arr,dp);
			minSteps = Math.min(minSteps, steps);
		}
		dp[i][j] = minSteps;

		return minSteps;
	}
	public static int matrixMultiplicationMem(int[] arr , int N) {
		int[][] dp = new int[arr.length][arr.length];
		for(int i=0;i<dp.length;i++) {
			Arrays.fill(dp[i],-1);;
		}
		return matrixMultiplicationMem(1,arr.length-1,arr,dp);
	}
	//Tabulation
	public static int matrixMultiplication(int[] arr, int N) {
		int[][] dp = new int[arr.length][arr.length];


		for( int i=0;i <arr.length; i++) {
			dp[i][i] = 0;
		}

		for(int i = N-1; i>=1; i--) {
			for(int j = i+1; j<=N-1; j++) {
				int minSteps = Integer.MAX_VALUE;

				for(int k = i; k<=j-1;k++) {

					int steps = arr[i-1] * arr[k] * arr[j] + dp[i][k] + dp[k+1][j];
					minSteps = Math.min(minSteps, steps);
				}
				dp[i][j] = minSteps;
			}
		}
		return dp[1][N-1];

	}

}
