package com.datastructures.dp;

import java.util.Arrays;

public class MinPathSum {
	
//	rec
	public static int minSumPathRec(int i, int j, int[][] grid) {
		if( i==0 && j==0 )	return grid[0][0];
		if ( i<0 || j<0 )	return 100001;
		
		int up = grid[i][j]+ minSumPathRec(i, j-1, grid);
		int left = grid[i][j]+ minSumPathRec(i-1, j, grid);
		return Math.min(up, left); 
		
	}
	public static int minSumPathRec(int[][] grid) {
		// Write your code here.
		return minSumPathRec(grid.length-1,grid[0].length-1,grid);
	}
	
//	mem
	public static int minSumPathMem(int i, int j, int[][] grid,int[][] dp) {
		if( i==0 && j==0 )	return grid[0][0];
		if ( i<0 || j<0 )	return 100001;
		if (dp[i][j] != -1)	return dp[i][j];
		
		int up = grid[i][j]+ minSumPathMem(i, j-1, grid,dp);
		int left = grid[i][j]+ minSumPathMem(i-1, j, grid,dp);
		return Math.min(up, left); 
		
	}
	public static int minSumPathMem(int[][] grid) {
		// Write your code here.
		int[][] dp =new int[grid.length][grid[0].length];
		for(int i=0;i<dp.length;i++)
			Arrays.fill(dp[i], -1);
		return minSumPathMem(grid.length-1,grid[0].length-1,grid,dp);
	}
	
//	tabulation
	public static int minSumPathTab(int[][] grid) {
		// Write your code here.
		int[][] dp =new int[grid.length][grid[0].length];
		for(int i=0;i<grid.length;i++) {
			for(int j=0;j<grid[0].length;j++) {
				if(i==0 && j==0) 
                    dp[i][j]=grid[0][0];
				else {
					int up = 100000001;
					int left = 100000001;
					
                    if(j>0)	left = grid[i][j] + dp[i][j-1];

					if(i>0)	up = grid[i][j] + dp[i-1][j];
					
					dp[i][j] = Math.min(up, left);
				}
			}
		}
		return dp[grid.length-1][grid[0].length-1];
	}
//	space opt
	public static int minSumPath(int[][] grid) {
		// Write your code here.
		int[] prevDp =new int[grid[0].length];
		
		for(int i=0;i<grid.length;i++) {
			int[] currDp = new int[grid[0].length];
			for(int j=0;j<grid[0].length;j++) {
				if(i==0 && j==0) 
                    currDp[j]=grid[0][0];
				else {
					int up = 100000001;
					int left = 100000001;
					
                    if(j>0)	left = grid[i][j] + currDp[j-1];

					if(i>0)	up = grid[i][j] + prevDp[j];
					
					currDp[j] = Math.min(up, left);
				}
			}
			prevDp = currDp;
		}
		return prevDp[grid[0].length-1];
	}
	
	
}
