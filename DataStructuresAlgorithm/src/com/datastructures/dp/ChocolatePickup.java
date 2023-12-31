package com.datastructures.dp;

import java.util.Arrays;

public class ChocolatePickup {
//	Recursion
	public static int  maximumChocolatesRec(int row, int aliceCol, int bobCol, int[][] grid) {
		if( aliceCol < 0 || aliceCol > grid[0].length-1 || bobCol < 0 || bobCol > grid[0].length-1) return -100000;
		
		if(row == grid.length-1) {
			if(aliceCol == bobCol) {
				return grid[row][aliceCol];
			}else {
				return grid[row][aliceCol] + grid[row][bobCol];
			}
		}
		
		int maxChocolate = -100000;
		for(int i=-1;i<=1;i++) {
			for(int j=-1; j<=1;j++) {
				int currMaxChoc = -100000;
				if (aliceCol == bobCol) {
					currMaxChoc = grid[row][aliceCol] + maximumChocolatesRec(row+1, aliceCol+i, bobCol+j, grid);
				}else {
					currMaxChoc = grid[row][aliceCol] + grid[row][bobCol] + maximumChocolatesRec(row+1, aliceCol+i, bobCol+j, grid);
				}
				maxChocolate = Math.max(maxChocolate, currMaxChoc);
			}
		}
		return maxChocolate;
			
	}
	public static int maximumChocolatesRec(int r, int c, int[][] grid) {
		
		return maximumChocolatesRec(0,0,grid[0].length-1,grid);
	}
	
//	Memoization
	public static int  maximumChocolatesMem(int row, int aliceCol, int bobCol, int[][] grid,int[][][] dp) {
		if( aliceCol < 0 || aliceCol > grid[0].length-1 || bobCol < 0 || bobCol > grid[0].length-1) return -100000;
		
		if(row == grid.length-1) {
			if(aliceCol == bobCol) {
				return grid[row][aliceCol];
			}else {
				return grid[row][aliceCol] + grid[row][bobCol];
			}
		}
		
		if(dp[row][aliceCol][bobCol] != -1)return dp[row][aliceCol][bobCol];
		
		int maxChocolate = -100000;
		for(int i=-1;i<=1;i++) {
			for(int j=-1; j<=1;j++) {
				int currMaxChoc = -100000;
				if (aliceCol == bobCol) {
					currMaxChoc = grid[row][aliceCol] + maximumChocolatesMem(row+1, aliceCol+i, bobCol+j, grid,dp);
				}else {
					currMaxChoc = grid[row][aliceCol] + grid[row][bobCol] + maximumChocolatesMem(row+1, aliceCol+i, bobCol+j, grid,dp);
				}
				maxChocolate = Math.max(maxChocolate, currMaxChoc);
			}
		}
		dp[row][aliceCol][bobCol] = maxChocolate;
		return dp[row][aliceCol][bobCol];
			
	}
	public static int maximumChocolatesMem(int r, int c, int[][] grid) {
		int[][][] dp = new int[grid.length][grid[0].length][grid[0].length];
		for(int i=0;i<dp.length;i++) {
			for(int j=0;j<grid[0].length;j++) {
				Arrays.fill(dp[i][j], -1);
			}
		}
		return maximumChocolatesMem(0,0,grid[0].length-1,grid,dp);
	}
	
//	Tabulation
	public static int maximumChocolatesTab(int r, int c, int[][] grid) {
		int row = grid.length;
		int col = grid[0].length;
		int[][][] dp = new int[row][col][col];
		
//		base case
		for(int j=0;j<col;j++) {
			for(int k=0;k<col;k++) {
				if(j==k) {
					dp[row-1][j][k] = grid[row-1][j];
				}else {
					dp[row-1][j][k] = grid[row-1][j] + grid[row-1][k];
				}
			}
		}
		
		for(int i = row-2 ;i>=0 ;i--) {
			for(int j = col-1; j>=0 ; j--) {
				for(int k = col-1; k>=0; k--) {
					
					int maxChocolate = -1000000;
					for( int x = -1 ; x<=1 ; x++) {
						for(int y=-1; y<=1; y++) {
							int currMax = -1000000;
							if(j==k) {
								currMax = grid[i][j] ;
								if (j+x<0 || j+x >col-1 || k+y <0 || k+y>col-1)
									currMax += -1000000;
								else
									currMax += dp[i+1][j+x][k+y];
							}else {
								currMax = grid[i][j] + grid[i][k]; 
								if (j+x<0 || j+x >col-1 || k+y <0 || k+y>col-1)
									currMax += -1000000;
								else
								 	currMax += dp[i+1][j+x][k+y];
							}
							maxChocolate = Math.max(maxChocolate,currMax);
						}
					}
					dp[i][j][k] = maxChocolate;
				}
			}
		}
		
		return dp[0][0][col-1];
	}
//	Space optimization
	public static int maximumChocolates(int r, int c, int[][] grid) {
		int row = grid.length;
		int col = grid[0].length;
		int[][] prevDp = new int[col][col];
		
//		base case
		for(int j=0;j<col;j++) {
			for(int k=0;k<col;k++) {
				if(j==k) {
					prevDp[j][k] = grid[row-1][j];
				}else {
					prevDp[j][k] = grid[row-1][j] + grid[row-1][k];
				}
			}
		}
		
		for(int i = row-2 ;i>=0 ;i--) {
			int[][] currDp = new int[col][col];
			for(int j = col-1; j>=0 ; j--) {
				for(int k = col-1; k>=0; k--) {
					
					int maxChocolate = -1000000;
					for( int x = -1 ; x<=1 ; x++) {
						for(int y=-1; y<=1; y++) {
							int currMax = -1000000;
							if(j==k) {
								currMax = grid[i][j] ;
								if (j+x<0 || j+x >col-1 || k+y <0 || k+y>col-1)
									currMax += -1000000;
								else
									currMax += prevDp[j+x][k+y];
							}else {
								currMax = grid[i][j] + grid[i][k]; 
								if (j+x<0 || j+x >col-1 || k+y <0 || k+y>col-1)
									currMax += -1000000;
								else
								 	currMax += prevDp[j+x][k+y];
							}
							maxChocolate = Math.max(maxChocolate,currMax);
						}
					}
					currDp[j][k] = maxChocolate;
				}
			}
			prevDp = currDp;
		}
		
		return prevDp[0][col-1];
	}
	
	
}
