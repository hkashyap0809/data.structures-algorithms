package com.datastructures.dp;

public class ShortestCommonSuperSequence {
	public static String shortestSupersequence(String a, String b) {
		int m = a.length();
		int n = b.length();
		int[][] dp = new int[m+1][n+1];
		
		for(int i=0;i<=m;i++) dp[i][0] = 0;
		for(int j=0;j<=n;j++) dp[0][j] = 0;
		//Longest Common Subsequence
		for(int i=1;i<=m;i++) {
			for(int j=1;j<=n;j++) {
				if( a.charAt(i-1) == b.charAt(j-1) ) 
					dp[i][j] = 1 + dp[i-1][j-1];
				else
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
			}
		}
		//Forming the shortest common supersequence
		int i = m;
		int j = n;
		String ans = "";
		while(i>0 && j>0) {
			if(a.charAt(i-1) == b.charAt(j-1)) {
				ans = a.charAt(i-1) + ans;
				i--;
				j--;
			}else if(dp[i-1][j] > dp[i][j-1]) {
				ans = a.charAt(i-1) + ans;
				i--;
			}else {
				ans = b.charAt(j-1) + ans;
				j--;
			}
		}
		
		while(i>0){
            ans = a.charAt(i-1) + ans;
            i--;
        }
		
		while(j>0){
            ans = b.charAt(j-1) + ans;
            j--;
        }
			
		return ans;
	}
}
