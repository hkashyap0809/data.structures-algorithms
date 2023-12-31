package com.datastructures.dp;

import java.util.Arrays;

public class WildcardMatching {
	public static boolean wildcardMatchingRec(int i, int j, String pattern, String text) {

		if (i<0 && j<0) return true;
		if (i<0 && j>=0) return false;
		if (i>=0 && j<0) {
			for(int x = 0; x<=i;x++) {
				if(pattern.charAt(x) != '*')	return false;
			}
			return true;
		}

		if(pattern.charAt(i) == text.charAt(j) || pattern.charAt(i)== '?') {
			return wildcardMatchingRec(i-1,j-1, pattern, text);
		}else if(pattern.charAt(i) == '*') {
			return wildcardMatchingRec(i-1, j, pattern, text) || wildcardMatchingRec(i, j-1, pattern, text);
		}else{
			return false;
		}

	}
	public static boolean wildcardMatchingRec(String pattern, String text) {
		int m = pattern.length();
		int n = text.length();
		return wildcardMatchingRec(m-1,n-1,pattern,text);
	}
	//	mem
	public static boolean wildcardMatchingMem(int i, int j, String pattern, String text,int[][] dp) {

		if (i<0 && j<0) return true;
		if (i<0 && j>=0) return false;
		if (i>=0 && j<0) {
			for(int x = 0; x<=i;x++) {
				if(pattern.charAt(x) != '*')	return false;
			}
			return true;
		}

		if(dp[i][j] != -1) {
			if(dp[i][j]==1)
				return true;
			else
				return false;
		}

		boolean result = false;
		if(pattern.charAt(i) == text.charAt(j) || pattern.charAt(i)== '?') {
			result = wildcardMatchingMem(i-1,j-1, pattern, text,dp);
		}else if(pattern.charAt(i) == '*') {
			result = wildcardMatchingMem(i-1, j, pattern, text, dp) || wildcardMatchingMem(i, j-1, pattern, text,dp);
		}else{
			result = false;
		}
		if(result)
			dp[i][j] = 1;
		else
			dp[i][j] = 0;
		return result;

	}
	public static boolean wildcardMatchingMem(String pattern, String text) {

		int m = pattern.length();
		int n = text.length();
		int [][] dp =new int[m][n];
		for(int i=0;i<dp.length;i++)	Arrays.fill(dp[i], -1);
		return wildcardMatchingMem(m-1,n-1,pattern,text,dp);
	}
	//	tab
	public static boolean wildcardMatchingTab(String pattern, String text) {
		int m = pattern.length();
		int n = text.length();

		boolean[][] dp = new boolean[m+1][n+1];

		for(int j=0;j<=n;j++) dp[0][j] = false;

		for(int i=0;i<=m;i++) {
			boolean flag = false;
			for(int x=1; x<=i;x++) {
				if(pattern.charAt(x-1) != '*') {	
					flag = true;
					break;
				}
			}
			if(flag)	dp[i][0] = false;
			else	dp[i][0] = true;
		}
		dp[0][0] = true;

		for(int i=1 ;i<=m;i++) {
			for(int j =1 ;j<=n;j++) {
				if(pattern.charAt(i-1) == text.charAt(j-1) || pattern.charAt(i-1) == '?') {
					dp[i][j] = dp[i-1][j-1];
				}else if(pattern.charAt(i-1) == '*') {
					dp[i][j] = dp[i-1][j] || dp[i][j-1];
				}else {
					dp[i][j] = false;
				}
			}
		}

		return dp[m][n];
	}
	//space opt
	public static boolean wildcardMatching(String pattern, String text) {
		int m = pattern.length();
		int n = text.length();

		boolean[] prevDp = new boolean[n+1];
		Arrays.fill(prevDp, false);

		prevDp[0] = true;


		for(int i=1 ;i<=m;i++) {
			boolean[] currDp = new boolean[n+1];


			boolean flag = false;
			for(int x=1; x<=i;x++) {
				if(pattern.charAt(x-1) != '*') {	
					flag = true;
					break;
				}
			}
			if(flag)	currDp[0] = false;
			else	currDp[0] = true;


			for(int j =1 ;j<=n;j++) {
				if(pattern.charAt(i-1) == text.charAt(j-1) || pattern.charAt(i-1) == '?') {
					currDp[j] = prevDp[j-1];
				}else if(pattern.charAt(i-1) == '*') {
					currDp[j] = prevDp[j] || currDp[j-1];
				}else {
					currDp[j] = false;
				}
			}
			prevDp = currDp;
		}

		return prevDp[n];
	}

}
