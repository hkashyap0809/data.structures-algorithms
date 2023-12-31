package com.datastructures.dp;

import java.util.Arrays;

public class Triangle {
	
	public static int minimumPathSumRec(int i, int j, int[][] triangle) {
		if ( i == triangle.length-1)	return triangle[i][j];
		
		int down = triangle[i][j] + minimumPathSumRec(i+1,j,triangle);
		int downDiag = triangle[i][j] + minimumPathSumRec(i+1,j+1,triangle);
		
		return Math.min(down, downDiag);
			
	}
	public static int minimumPathSumRec(int[][] triangle, int n) {
        return minimumPathSumRec(0,0,triangle);
    }
	
//	mem
	public static int minimumPathSumMem(int i, int j, int[][] triangle, int[][] dp) {
		if ( i == triangle.length-1)	return triangle[i][j];
		if ( dp[i][j] != -1)return dp[i][j];
		
		int down = triangle[i][j] + minimumPathSumMem(i+1,j,triangle,dp);
		int downDiag = triangle[i][j] + minimumPathSumMem(i+1,j+1,triangle,dp);
		
		dp[i][j] = Math.min(down, downDiag);
		return dp[i][j];
			
	}
	public static int minimumPathSumMem(int[][] triangle, int n) {
		int[][] dp = new int[n][n];
		for(int i=0;i<dp.length;i++)
			Arrays.fill(dp[i], -1);
        return minimumPathSumMem(0,0,triangle,dp);
    }
	
//	tabulation
	public static int minimumPathSumTab(int[][] triangle, int n) {
		int[][] dp =new int[n][n];
		for(int j=0;j<n;j++) {
			dp[n-1][j]=triangle[n-1][j];
		}
		
		for(int i = n-2;i>=0;i--) {
			for(int j=i;j>=0;j--) {
				int down = triangle[i][j] + dp[i+1][j];
				int diagDown = triangle[i][j] + dp[i+1][j+1];
				dp[i][j]=Math.min(down, diagDown);
			}
		}
		return dp[0][0];	
	}
//	space optimization
	public static int minimumPathSum(int[][] triangle, int n) {
		int[] prevDp =new int[n];
		
		for(int j=0;j<n;j++) {
			prevDp[j]=triangle[n-1][j];
		}
		
		for(int i = n-2;i>=0;i--) {
			int[] currDp = new int[n];
			for(int j=i;j>=0;j--) {
				int down = triangle[i][j] + prevDp[j];
				int diagDown = triangle[i][j] + prevDp[j+1];
				currDp[j]=Math.min(down, diagDown);
			}
		}
		return prevDp[0];
		
	}
}
