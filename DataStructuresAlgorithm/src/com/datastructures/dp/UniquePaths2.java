package com.datastructures.dp;

import java.util.ArrayList;
import java.util.Arrays;

public class UniquePaths2 {
	//Recursion
	public static int mazeObstaclesRecH(int i , int j, ArrayList<ArrayList<Integer>> mat) {
		if( i>=0 && j>=0 && mat.get(i).get(j)==-1) return 0;
		if( i==0 && j==0) return 1;
		if( i<0 || j<0 ) return 0;

		return mazeObstaclesRecH(i-1, j, mat) + mazeObstaclesRecH(i, j-1, mat);
	}
	public static int mazeObstaclesRec(int n, int m, ArrayList<ArrayList<Integer>> mat) {
		return mazeObstaclesRecH(n-1,m-1,mat);
	}

	//Memoization
	public static int mazeObstaclesMem(int i , int j, ArrayList<ArrayList<Integer>> mat,int[][] dp) {
		if( i>=0 && j>=0 && mat.get(i).get(j)==-1) return 0;
		if( i==0 && j==0) return 1;
		if( i<0 || j<0 ) return 0;

		if(dp[i][j] != -1)	return dp[i][j];

		dp[i][j] = mazeObstaclesMem(i-1, j, mat,dp) + mazeObstaclesMem(i, j-1, mat,dp);
		return dp[i][j];
	}
	
	public static int mazeObstaclesMem(int n, int m, ArrayList<ArrayList<Integer>> mat) {
		int[][] dp = new int[n][m];
		for(int i=0;i<dp.length;i++)
			Arrays.fill(dp[i], -1);
		return mazeObstaclesMem(n-1,m-1,mat,dp);
	}

	//Tabulation
	public static int mazeObstaclesTab(int n, int m, ArrayList<ArrayList<Integer>> mat) {
		int[][] dp = new int[n][m];
        int mod = 1000000007;
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(mat.get(i).get(j)==-1)	dp[i][j]=0;
				else if(i==0 && j==0)	dp[i][j]=1;
				else {
					int up = 0;
					int left = 0;
					if (i >0 ) left = dp[i-1][j];
					if ( j>0 ) up = dp[i][j-1];
					dp[i][j] = (up + left) % mod;
				}
			}
		}
        
        return dp[n-1][m-1];
	}
//	Space Optmization
	public static int mazeObstacles(int n, int m, ArrayList<ArrayList<Integer>> mat) {
		int[] prevDp = new int[m];
		int mod = 1000000007;
		
		for(int i=0;i<n;i++) {
			int[] currDp =new int[m];
			for(int j=0;j<m;j++) {
				if(mat.get(i).get(j)==-1)	currDp[j]=0;
				else if(i==0 && j==0)	currDp[j]=1;
				else {
					int up = 0;
					int left = 0;
					if ( j>0 ) left = currDp[j-1];
					if ( i>0 ) up = prevDp[j];
					currDp[j] = (up + left) % mod;
				}
			}
			prevDp = currDp;
		}
		return prevDp[m-1];
	}
}
