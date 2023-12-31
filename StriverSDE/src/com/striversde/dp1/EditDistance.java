package com.striversde.dp1;

import java.util.Arrays;

public class EditDistance {
	public static int editDistanceRec(int i, int j, String str1, String str2) {

		if(i<0)	return j+1;
		if(j<0)	return i+1;

		if( str1.charAt(i) == str2.charAt(j)) {
			return editDistanceRec(i-1, j-1, str1, str2);
		}else {
			int insertion = 1 + editDistanceRec(i, j-1, str1, str2);
			int deletion = 1 + editDistanceRec(i-1, j, str1, str2);
			int replace = 1 + editDistanceRec(i-1,j-1,str1,str2);
			return Math.min(insertion, Math.min(deletion, replace));
		}
	}

	public static int editDistanceRec(String str1, String str2) {
		int len1 = str1.length();
		int len2 = str2.length();
		return editDistanceRec(len1-1,len2-1,str1,str2);
	}

	//	mem
	public static int editDistanceMem(int i, int j, String str1, String str2,int[][] dp) {

		if(i<0)	return j+1;
		if(j<0)	return i+1;
		if(dp[i][j] != -1) return dp[i][j];

		if( str1.charAt(i) == str2.charAt(j)) {
			dp[i][j] = editDistanceMem(i-1, j-1, str1, str2,dp);
		}else {
			int insertion = 1 + editDistanceMem(i, j-1, str1, str2,dp);
			int deletion = 1 + editDistanceMem(i-1, j, str1, str2,dp);
			int replace = 1 + editDistanceMem(i-1,j-1,str1,str2,dp);
			dp[i][j] = Math.min(insertion, Math.min(deletion, replace));
		}
		return dp[i][j];
	}

	public static int editDistanceMem(String str1, String str2) {
		int len1 = str1.length();
		int len2 = str2.length();
		int[][] dp = new int[len1][len2];
		for(int i=0;i<dp.length;i++)	Arrays.fill(dp[i], -1);
		return editDistanceMem(len1-1,len2-1,str1,str2,dp);
	}
	//	mem shift
	public static int editDistanceMemShift(int i, int j, String str1, String str2,int[][] dp) {

		if(i==0)	return j;
		if(j==0)	return i;
		if(dp[i][j] != -1) return dp[i][j];

		if( str1.charAt(i-1) == str2.charAt(j-1)) {
			dp[i][j] = editDistanceMemShift(i-1, j-1, str1, str2,dp);
		}else {
			int insertion = 1 + editDistanceMemShift(i, j-1, str1, str2,dp);
			int deletion = 1 + editDistanceMemShift(i-1, j, str1, str2,dp);
			int replace = 1 + editDistanceMemShift(i-1,j-1,str1,str2,dp);
			dp[i][j] = Math.min(insertion, Math.min(deletion, replace));
		}
		return dp[i][j];
	}

	public static int editDistanceMemShift(String str1, String str2) {
		int len1 = str1.length();
		int len2 = str2.length();
		int[][] dp = new int[len1+1][len2+1];
		for(int i=0;i<dp.length;i++)	Arrays.fill(dp[i], -1);
		return editDistanceMemShift(len1,len2,str1,str2,dp);
	}
	//	tabulation

	public static int editDistanceTab(String str1, String str2) {
		int len1 = str1.length();
		int len2 = str2.length();

		int[][] dp = new int[len1+1][len2+1];

		for(int i=0;i<=len1;i++) dp[i][0] = i;
		for(int j=0;j<=len2;j++) dp[0][j] = j;

		for(int i=1;i<=len1;i++) {
			for(int j=1;j<=len2;j++) {
				if( str1.charAt(i-1) == str2.charAt(j-1)) {
					dp[i][j] = dp[i-1][j-1];
				}else {
					int insertion = 1 + dp[i][j-1];
					int deletion = 1 + dp[i-1][j];
					int replace = 1 + dp[i-1][j-1];
					dp[i][j] = Math.min(insertion, Math.min(deletion, replace));
				}
			}
		}
		return dp[len1][len2];
	}
	
//	space opt
	public static int editDistanceSpaceOpt(String str1, String str2) {
		int len1 = str1.length();
		int len2 = str2.length();

		int[] prevDp = new int[len2+1];

		for(int j=0;j<=len2;j++) prevDp[j] = j;

		for(int i=1;i<=len1;i++) {
			int[] currDp = new int[len2+1];
            currDp[0]=i;
			for(int j=1;j<=len2;j++) {
				if( str1.charAt(i-1) == str2.charAt(j-1)) {
					currDp[j] = prevDp[j-1];
				}else {
					int insertion = 1 + currDp[j-1];
					int deletion = 1 + prevDp[j];
					int replace = 1 + prevDp[j-1];
					currDp[j] = Math.min(insertion, Math.min(deletion, replace));
				}
			}
			prevDp = currDp;
		}
		return prevDp[len2];
	}
	

}
