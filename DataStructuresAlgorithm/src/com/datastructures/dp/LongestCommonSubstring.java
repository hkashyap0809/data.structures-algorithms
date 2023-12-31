package com.datastructures.dp;

public class LongestCommonSubstring {
	public static int lcs(String str1, String str2) {
		int m = str1.length();
		int n = str2.length();
		
		int[][] dp =new int[m+1][n+1];
		for(int i=0;i<=m;i++)dp[i][0]=0;
		for(int j=0;j<=n;j++)dp[0][j]=0;
		
		int maxSub = 0;
		for(int i=1;i<=m;i++) {
			for(int j=1;j<=n;j++) {
				if(str1.charAt(i-1) == str2.charAt(j-1)) {
					dp[i][j] = 1 + dp[i-1][j-1];
				}else {
					dp[i][j]=0;
				}
				maxSub = Math.max(maxSub, dp[i][j]);
			}
		}
		return maxSub;
	}
}
