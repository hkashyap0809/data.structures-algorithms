package com.datastructures.dp;

public class MinInsDelToConvertString {
	public static int canYouMake(String str, String ptr) {

		int m = str.length();
		int n = ptr.length();
		int[][] dp = new int[m+1][n+1];
		
		for(int i=0;i<=m;i++) dp[i][0] = 0;
		for(int j=0;j<=n;j++) dp[0][j] = 0;

		for(int i=1;i<=m;i++) {
			for(int j=1;j<=n;j++) {
				if( str.charAt(i-1) == ptr.charAt(j-1) ) 
					dp[i][j] = 1 + dp[i-1][j-1];
				else
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
			}
		}
		return m - dp[m][n] + n - dp[m][n];
	}
}
