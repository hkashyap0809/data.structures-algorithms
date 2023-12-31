package com.datastructures.dp;

import java.util.Arrays;

public class FrogJumpK {
	//Recursion
	public static int frogJumpRecKH(int idx, int[] heights, int k) {

		if ( idx == 0 )	return 0; 

		int res = Integer.MAX_VALUE;

		for(int i = 1; i<=k; i++) {
			int jump = Integer.MAX_VALUE;
			if ( idx - i >= 0)
				jump = Math.abs(heights[idx] - heights[idx-i]) + frogJumpRecKH(idx - i, heights, k );
			res = Math.min(res,  jump);
		}

		return res;
	}
	public static int frogJumpKRec(int n, int heights[], int k) {
		return frogJumpRecKH(n-1,heights, k);
	}
	//Memoization
	public static int frogJumpKMem(int idx, int[] heights, int k, int[] dp) {

		if ( idx == 0 )	return 0; 
		if ( dp[idx] != -1 )return dp[idx];

		int res = Integer.MAX_VALUE;

		for(int i = 1; i<=k; i++) {
			int jump = Integer.MAX_VALUE;
			if ( idx - i >= 0)
				jump = Math.abs(heights[idx] - heights[idx-i]) + frogJumpKMem(idx - i, heights, k ,dp);
			res = Math.min(res,  jump);
		}
		dp[idx] = res;
		return res;
	}
	public static int frogJumpKMem(int n, int heights[],int k) {
		int[] dp = new int[n];
		Arrays.fill(dp, -1);
		return frogJumpKMem(n-1,heights,k,dp);
	}

	//Tabulation
	public static int frogJumpTab(int n, int heights[], int k) {
		int[] dp = new int[n];
		dp[0] = 0;

		for(int idx=1; idx<n; idx++) {

			int res = Integer.MAX_VALUE;

			for(int i = 1; i<=k; i++ ) {
				int jump = Integer.MAX_VALUE;
				if( idx - i >= 0) {
					jump = Math.abs( heights[idx] - heights[idx-i] ) + dp[idx-i]; 
				}
				res = Math.min(res, jump);
			}
			dp[idx] = res;
		}

		return dp[n-1];
	}
}
