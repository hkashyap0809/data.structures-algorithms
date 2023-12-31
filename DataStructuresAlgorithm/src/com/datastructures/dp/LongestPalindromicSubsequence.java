package com.datastructures.dp;

public class LongestPalindromicSubsequence {
	public int longestPalindromeSubseq(String s) {
		int len = s.length();
		String sRev="";
		for ( int i=0; i<len;i++) {
			sRev= s.charAt(i) + sRev;
		}

		int[] prevDp = new int[len+1];

		for(int i = 1; i<=len;i++) {
			int[] currDp = new int[len+1];
			for(int j = 1; j<=len;j++) {
				if ( s.charAt(i-1) == sRev.charAt(j-1)) {
					currDp[j] = 1 + prevDp[j-1];
				}else {
					currDp[j] = Math.max(currDp[j-1], prevDp[j]);
				}
			}
			prevDp = currDp;
		}

		return prevDp[len];

	}
}
