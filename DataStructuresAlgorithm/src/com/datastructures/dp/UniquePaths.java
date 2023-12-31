package com.datastructures.dp;

import java.util.Arrays;

public class UniquePaths {
	//Recursion
	public static int uniquePathsRecH(int i, int j) {
		if(i==0 && j==0)	return 1;
		if(i<0 || j<0)	return 0;
		
		return uniquePathsRecH(i-1,j) + uniquePathsRecH(i,j-1);
	}
	public static int uniquePathsRec(int m, int n) {
		// Write your code here.
		return uniquePathsRecH(m-1,n-1);
	}
	
//	Memoization
	public static int uniquePathsMem(int i, int j,int[][] dp) {
		if(i==0 && j==0)	return 1;
		if(i<0 || j<0)	return 0;
		if(dp[i][j] != -1 )	return dp[i][j];
		
		dp[i][j] = uniquePathsMem(i-1,j,dp) + uniquePathsMem(i,j-1,dp);
		return dp[i][j];
	}
	public static int uniquePathsMem(int m, int n) {
		// Write your code here.
		int[][] dp = new int[m][n];
		for(int i=0;i<m;i++)
			Arrays.fill(dp[i], -1);
		return uniquePathsMem(m-1,n-1,dp);
	}
//	Tabulation
	public static int uniquePathsTab(int m, int n) {
		// Write your code here.
		int[][] dp = new int[m][n];
		for(int i=0;i<m;i++) {
			for(int j=0;j<n;j++) {
				if(i==0 && j==0) dp[i][j]=1;
				else{
					int up = 0;
					int left = 0;
					if(i>0)	left = dp[i-1][j];
					if(j>0)	up = dp[i][j-1];
				
					dp[i][j]=up+left;
				}

			}
		}
		return dp[m-1][n-1];	
	}
	
//	Space Optimization
	public static int uniquePaths(int m, int n){
		// Write your code here.
		int[] prevDp = new int[n];
		for(int i=0;i<m;i++) {
			int[] currDp = new int[n];
			for(int j=0;j<n;j++) {
				if(i==0 && j==0) currDp[j]=1;
				else{
					int up = 0;
					int left = 0;
					if(j>0)	left = currDp[j-1];
					if(i>0) up = prevDp[j];
				
					currDp[j]=up+left;
				}

			}
			prevDp = currDp;
		}
		return prevDp[n-1];	
	}

}
