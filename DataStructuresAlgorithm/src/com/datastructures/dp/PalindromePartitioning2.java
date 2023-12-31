package com.datastructures.dp;

import java.util.Arrays;

public class PalindromePartitioning2 {
	private static boolean isPalindrome(String str) {
		if ( str.length() <= 1)	return true;

		int i = 0;
		int j = str.length() - 1;
		while ( i <= j ) {
			if ( str.charAt(i) != str.charAt(j) ) {
				return false;
			}else {
				i++;
				j--;
			}
		}
		return true;
	}
	//Recursion
	private static int palindromePartitioningRec(int idx, String str) {
		if ( idx == str.length() )	return 0;

		String temp = "";
		int minCost = Integer.MAX_VALUE;
		for(int j = idx; j<str.length(); j++) {
			temp = temp + str.charAt(j);
			if ( isPalindrome(temp) ) {
				int cost = 1 + palindromePartitioningRec(j+1, str);
				minCost = Math.min(minCost, cost);
			}

		}
		return minCost;
	}


	public static int palindromePartitioningRec(String str) {
		return palindromePartitioningRec(0,str)-1;
	}

	//Memoization
	private static int palindromePartitioningMem(int idx, String str, int[] dp) {
		if ( idx == str.length() )	return 0;

		if ( dp[idx] != -1 )	return dp[idx];

		String temp = "";
		int minCost = Integer.MAX_VALUE;
		for(int j = idx; j<str.length(); j++) {
			temp = temp + str.charAt(j);
			if ( isPalindrome(temp) ) {
				int cost = 1 + palindromePartitioningMem(j+1, str,dp);
				minCost = Math.min(minCost, cost);
			}

		}
		dp[idx] = minCost;
		return minCost;
	}


	public static int palindromePartitioningMem(String str) {
		int[] dp = new int[str.length()];
		Arrays.fill(dp, -1);;
		return palindromePartitioningMem(0,str,dp)-1;
	}
	
	//Tabulation
	public static int palindromePartitioning(String str) {
		int n = str.length();
		int[] dp = new int[n+1];

		for(int idx=n-1; idx>=0; idx--) {
			String temp = "";
			int minCost = Integer.MAX_VALUE;
			for(int j = idx; j<str.length(); j++) {
				temp = temp + str.charAt(j);
				if ( isPalindrome(temp) ) {
					int cost = 1 + dp[j+1];
					minCost = Math.min(minCost, cost);
				}

			}
			dp[idx] = minCost;
		}

		return dp[0]-1;
	}

}
