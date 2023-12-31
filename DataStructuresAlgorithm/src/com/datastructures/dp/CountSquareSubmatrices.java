package com.datastructures.dp;

public class CountSquareSubmatrices {
	public static int countSquares(int n, int m, int[][] arr) {
		int row = arr.length;
		int col = arr[0].length;
		
		int[][] dp = new int[row][col];
		int ans = 0;
		if ( arr[0][0] == 1 )
			ans = -1;
		else
			ans = 0 ;
		
		for(int i=0;i<row;i++) 	{
			dp[i][0] = arr[i][0];
			ans+= dp[i][0];
		}
		
		for(int j=0; j<col;j++)	{
			dp[0][j] = arr[0][j];
			ans+= dp[0][j];
		}

		for( int i=1; i<row;i++) {
			for(int j=1; j<col; j++) {
				if ( arr[i][j] == 1 ) {
					dp[i][j] = 1 + Math.min(dp[i][j-1], Math.min(dp[i-1][j], dp[i-1][j-1]));
				}
				ans += dp[i][j];
			}
		}

		return ans;
	}
}
