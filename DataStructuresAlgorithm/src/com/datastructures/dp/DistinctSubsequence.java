package com.datastructures.dp;

import java.util.Arrays;

public class DistinctSubsequence {
	public static int distinctSubsequenceRec(int i, int j, String str1, String str2) {

		if(j<0) return 1;
		if(i<0) return 0;

		if(str1.charAt(i) == str2.charAt(j)) {
			return distinctSubsequenceRec(i-1, j-1, str1, str2) + distinctSubsequenceRec(i-1, j, str1, str2);
		}else {
			return distinctSubsequenceRec(i-1, j, str1, str2);
		}
	}
	public static int subsequenceCountingRec(String t, String s, int lt, int ls) {
		return distinctSubsequenceRec(lt-1,ls-1,t,s);
	}

	//mem

	public static int distinctSubsequenceMem(int i, int j, String str1, String str2,int[][] dp) {

		if(j<0) return 1;
		if(i<0) return 0;
		if( dp[i][j] != -1) 	return dp[i][j];

		if(str1.charAt(i) == str2.charAt(j)) {
			dp[i][j] = distinctSubsequenceMem(i-1, j-1, str1, str2,dp) + distinctSubsequenceMem(i-1, j, str1, str2,dp);
		}else {
			dp[i][j] = distinctSubsequenceMem(i-1, j, str1, str2,dp);
		}
		dp[i][j] %= 1000000007;
		return dp[i][j];
	}
	public static int subsequenceCountingMem(String t, String s, int lt, int ls) {
		int[][] dp = new int[lt][ls];
		for(int i=0;i<dp.length;i++) Arrays.fill(dp[i], -1);
		return distinctSubsequenceMem(lt-1,ls-1,t,s,dp)%1000000007;
	}

	//	mem shifting
	public static int distinctSubsequenceMemShift(int i, int j, String str1, String str2,int[][] dp) {

		if(j==0) return 1;
		if(i==0) return 0;
		if( dp[i][j] != -1) 	return dp[i][j];

		if(str1.charAt(i-1) == str2.charAt(j-1)) {
			dp[i][j] = distinctSubsequenceMemShift(i-1, j-1, str1, str2,dp) + distinctSubsequenceMemShift(i-1, j, str1, str2,dp);
		}else {
			dp[i][j] = distinctSubsequenceMemShift(i-1, j, str1, str2,dp);
		}
		dp[i][j] %= 1000000007;
		return dp[i][j];
	}
	public static int subsequenceCountingMemShift(String t, String s, int lt, int ls) {
		int[][] dp = new int[lt+1][ls+1];
		for(int i=0;i<dp.length;i++) Arrays.fill(dp[i], -1);
		return distinctSubsequenceMemShift(lt,ls,t,s,dp)%1000000007;
	}

	//tab
	public static int subsequenceCountingTab(String t, String s, int lt, int ls) {
		int[][] dp = new int[lt+1][ls+1];

		for(int j=0; j<=ls; j++)	dp[0][j] = 0;
		for(int i=0; i<=lt; i++)	dp[i][0] = 1;


		for(int i =1;i<=lt;i++) {
			for(int j=1; j<=ls; j++) {
				if(t.charAt(i-1) == s.charAt(j-1)) {
					dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
				}else {
					dp[i][j] = dp[i-1][j];
				}
				dp[i][j] %= 1000000007;
			}
		}
		return dp[lt][ls] % 1000000007;

	}
	//	space opt
	public static int subsequenceCounting(String t, String s, int lt, int ls) {
		int[] prevDp = new int[ls+1];

		prevDp[0] = 1;

		for(int i =1;i<=lt;i++) {
			int[] currDp = new int[ls+1];
			currDp[0] = 1;
			for(int j=1; j<=ls; j++) {
				if(t.charAt(i-1) == s.charAt(j-1)) {
					currDp[j] = prevDp[j-1] + prevDp[j];
				}else {
					currDp[j] = prevDp[j];
				}
				currDp[j] %= 1000000007;
			}
			prevDp = currDp;
		}
		return prevDp[ls] % 1000000007;

	}


}
