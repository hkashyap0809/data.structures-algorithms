package com.datastructures.dp;

import java.util.Arrays;

public class LongestStringChain {
	
	public static boolean compareString(String str1, String str2) {
		int len1 = str1.length();
		int len2 = str2.length();
		
		if ( Math.abs( len1 - len2 ) != 1 ) return false;
		
		int i = 0;
		int j = 0;
		
		while( i < len1) {
			if ( j<len2 && str1.charAt(i) == str2.charAt(j) ) {
				i++;
				j++;
			}else {
				i++;
			}
		}
		
		if( i == len1 && j == len2)	return true;
		return false;
		
	}
	public static int longestStrChain(int n, String[] arr) {
		arr = Arrays
                .stream(arr)
                .sorted((str1, str2) -> str1.length() - str2.length())
                .toArray(String[]::new);
		int[] dp =new int[n];
		int result = 1;
		dp[0] = 1;
		for (int i=1; i<n; i++) {
			dp[i] = 1;
			for(int j=0; j<i; j++) {
				if ( compareString(arr[i],arr[j]) && dp[i] < 1 + dp[j] ) {
					dp[i] = 1 + dp[j];
				}
				result = Math.max(result, dp[i]);
			}
		}
		
		return result;
	}
}
