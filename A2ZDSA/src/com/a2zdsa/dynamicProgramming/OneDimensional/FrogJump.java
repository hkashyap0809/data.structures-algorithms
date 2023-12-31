package com.a2zdsa.dynamicProgramming.OneDimensional;

import java.util.Arrays;

public class FrogJump {
	//Recursion
	public static int frogJumpHelperREC(int idx, int[] heights){
		if( idx == 0 ){
			return 0;
		}

		int oneStep = Math.abs(heights[idx] - heights[idx-1]) + frogJumpHelperREC(idx-1,heights);

		int twoStep = Integer.MAX_VALUE;
		if( idx - 2 >=0 )
			twoStep = Math.abs(heights[idx] - heights[idx-2]) + frogJumpHelperREC(idx-2,heights);

		return Math.min(oneStep,twoStep);
	}

	//Memoization
	public static int frogJumpHelperMEM(int idx, int[] heights,int[] dp){
		if( idx <= 0 ){
			return 0;
		}
		if( dp[idx] != -1 )	return dp[idx];

		int oneStep = Math.abs(heights[idx] - heights[idx-1]) + frogJumpHelperMEM(idx-1,heights,dp);

		int twoStep = Integer.MAX_VALUE;
		if( idx - 2 >=0 )
			twoStep = Math.abs(heights[idx] - heights[idx-2]) + frogJumpHelperMEM(idx-2,heights,dp);


		return dp[idx] = Math.min(oneStep,twoStep);
	}
	public static int frogJumpMEM(int idx, int[] heights){
		int[] dp = new int[heights.length];
		Arrays.fill(dp,-1);
		return frogJumpHelperMEM(idx, heights,dp);
	}

	//Tabulation
	public static int frogJumpHelperTAB(int n, int[] heights){

		int[] dp = new int[n];
		for( int idx = 1; idx < n; idx ++ ){
			int oneStep = Math.abs(heights[idx] - heights[idx-1]) + dp[idx-1];

			int twoStep = Integer.MAX_VALUE;
			if( idx - 2 >=0 )
				twoStep = Math.abs(heights[idx] - heights[idx-2]) + dp[idx-2];


			dp[idx] = Math.min(oneStep,twoStep);
		}
		return dp[n-1];
	}


	public static int frogJump(int n, int heights[]) {

		//		return frogJumpHelperREC(n-1,heights);
		//		return frogJumpMEM(n-1,heights);
		return frogJumpHelperTAB(n,heights);


	}

}
