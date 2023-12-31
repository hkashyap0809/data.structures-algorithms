package com.datastructures.dp;

public class MinimumInsertionsStringPalindrome {

	public static int minInsertion(String str) {
		int len = str.length();
		String rev = "";
		for(int i=0;i<len;i++)	rev = str.charAt(i) + rev;

		int[][] dp = new int[len+1][len+1];

		for(int i=0;i<=len;i++) dp[i][0] = 0;
		for(int j=0;j<=len;j++) dp[0][j] = 0;

		for(int i=1;i<=len;i++) {
			for(int j=1;j<=len;j++) {
				if( str.charAt(i-1) == rev.charAt(j-1) ) 
					dp[i][j] = 1 + dp[i-1][j-1];
				else
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
			}
		}
		return len - dp[len][len];
	}
}
