package com.datastructures.dp;

import java.util.Arrays;

public class LongestCommonSubsequence {

	//	rec
	public static int lcsRec(int i, int j, String s, String t) {

		if(i<0 || j<0)	return 0;

		if(s.charAt(i) == t.charAt(j))
			return 1 + lcsRec(i-1,j-1,s,t);

		return Math.max(lcsRec(i-1,j,s,t), lcsRec(i,j-1,s,t));
	}
	public static int lcsRec(String s, String t) {
		return lcsRec(s.length()-1,t.length()-1,s,t);
	}
	//	mem
	public static int lcsMem(int i, int j, String s, String t,int[][] dp) {

		if(i<0 || j<0)	return 0;
		if(dp[i][j] != -1)	return dp[i][j];

		if(s.charAt(i) == t.charAt(j))
			dp[i][j] =  1 + lcsMem(i-1,j-1,s,t,dp);
		else
			dp[i][j] =  Math.max(lcsMem(i-1,j,s,t,dp), lcsMem(i,j-1,s,t,dp));
		
		return dp[i][j];
	}
	public static int lcsMem(String s, String t) {
		int[][] dp = new int[s.length()][t.length()];
		for(int i=0;i<dp.length;i++) {
			Arrays.fill(dp[i], -1);
		}
		return lcsMem(s.length()-1,t.length()-1,s,t,dp);
	}
//	mem shifting
	public static int lcsMemShift(int i, int j, String s, String t,int[][] dp) {

		if(i==0 || j==0)	return 0;
		if(dp[i][j] != -1)	return dp[i][j];

		if(s.charAt(i-1) == t.charAt(j-1))
			dp[i][j] =  1 + lcsMemShift(i-1,j-1,s,t,dp);
		else
			dp[i][j] =  Math.max(lcsMemShift(i-1,j,s,t,dp), lcsMemShift(i,j-1,s,t,dp));
		
		return dp[i][j];
	}
	public static int lcsMemShift(String s, String t) {
		int[][] dp = new int[s.length()+1][t.length()+1];
		for(int i=0;i<dp.length;i++) {
			Arrays.fill(dp[i], -1);
		}
		return lcsMemShift(s.length(),t.length(),s,t,dp);
	}
//	tab
	public static int lcsTab(String s, String t) {
		int m = s.length();
		int n = t.length();
		int[][] dp = new int[m+1][n+1];
		
		
		for(int i=1;i<=m;i++) {
			for(int j=1;j<=n;j++) {
				if(s.charAt(i-1) == t.charAt(j-1))
					dp[i][j] = 1 + dp[i-1][j-1];
				else
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
			}
		}
		return dp[m][n];
	}
//	space opt
	public static int lcs(String s, String t) {
		int m = s.length();
		int n = t.length();
		int[] prevDp = new int[n+1];
		
		
		for(int i=1;i<=m;i++) {
			int[] currDp = new int[n+1];
			
			for(int j=1;j<=n;j++) {
				if(s.charAt(i-1) == t.charAt(j-1))
					currDp[j] = 1 + prevDp[j-1];
				else
					currDp[j] = Math.max(prevDp[j], currDp[j-1]);
			}
			prevDp = currDp;
		}
		return prevDp[n];
	}
	public static int printLCS(String s, String t) {
		int m = s.length();
		int n = t.length();
		int[][] dp = new int[m+1][n+1];
		
		
		for(int i=1;i<=m;i++) {
			for(int j=1;j<=n;j++) {
				if(s.charAt(i-1) == t.charAt(j-1))
					dp[i][j] = 1 + dp[i-1][j-1];
				else
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
			}
		}
		
		int i = m;
		int j = n;
		String ans = "";
		while( i>0 && j>0) {
			if(s.charAt(i-1) == t.charAt(j-1)) {
				ans = s.charAt(i-1) + ans;
				i--;
				j--;
			}else if(dp[i-1][j] > dp[i][j-1]) {
				i--;
			}else {
				j--;
			}
		}
		System.out.println(ans);
		return dp[m][n];
	}
	

}
