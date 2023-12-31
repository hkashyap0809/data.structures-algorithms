package com.datastructures.dp;

import java.util.Arrays;

public class FrogJump {
	//Recursion
	public static int frogJumpRecH(int idx, int[] heights) {

		if ( idx == 0 )	return 0; 

		int res = Integer.MAX_VALUE;
		int jump1 = frogJumpRecH(idx-1, heights) + Math.abs(heights[idx] - heights[idx-1]);
		int jump2 = Integer.MAX_VALUE;
		if ( idx >  1)
			jump2 = frogJumpRecH(idx-2, heights) + Math.abs(heights[idx] - heights[idx-2]);
		res = Math.min(jump1, jump2);
		return res;
	}
	public static int frogJumpRec(int n, int heights[]) {
		return frogJumpRecH(n-1,heights);
	}
	//Memoization
	public static int frogJumpMem(int idx, int[] heights, int[] dp) {

		if ( idx == 0 )	return 0; 
		if ( dp[idx] != -1 )	return dp[idx];

		int res = Integer.MAX_VALUE;
		int jump1 = frogJumpMem(idx-1, heights,dp) + Math.abs(heights[idx] - heights[idx-1]);
		int jump2 = Integer.MAX_VALUE;
		if ( idx >  1)
			jump2 = frogJumpMem(idx-2, heights,dp) + Math.abs(heights[idx] - heights[idx-2]);
		res = Math.min(jump1, jump2);
		dp[idx]=res;
		return res;
	}
	public static int frogJumpMem(int n, int heights[]) {
		int[] dp = new int[n];
		Arrays.fill(dp, -1);
		return frogJumpMem(n-1,heights,dp);
	}
	//Tabulation
	public static int frogJumpTab(int n, int heights[]) {
		int[] dp = new int[n];
		dp[0] = 0;

		for(int idx=1; idx<n; idx++) {
			int res = Integer.MAX_VALUE;
			int jump1 = dp[idx-1] + Math.abs(heights[idx] - heights[idx-1]);
			int jump2 = Integer.MAX_VALUE;
			if ( idx >  1)
				jump2 = dp[idx-2] + Math.abs(heights[idx] - heights[idx-2]);
			res = Math.min(jump1, jump2);
			dp[idx]=res;
		}

		return dp[n-1];
	}
	//Space Optimization
	public static int frogJump(int n, int heights[]) {
		int dp1 = 0;
		int dp2 = Math.abs(heights[1] - heights[0]);

		for(int idx=1; idx<n; idx++) {
			int res = Integer.MAX_VALUE;
			int jump1 = dp1 + Math.abs(heights[idx] - heights[idx-1]);
			int jump2 = Integer.MAX_VALUE;
			if ( idx >  1)
				jump2 = dp2 + Math.abs(heights[idx] - heights[idx-2]);
			res = Math.min(jump1, jump2);
			
			dp2 = dp1;
			dp1 = res; 
		}

		return dp1;
	}
}
