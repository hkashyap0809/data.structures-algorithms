package com.datastructures.recursion;

import java.util.Arrays;

public class CombinationSum4 {
	public int countCombination(int[] nums, int target,int[] dp){

		if( target == 0 )   return 1;
		if( dp[target] != -1)   return dp[target];
		int ways = 0;

		for( int i = 0; i < nums.length ; i++){
			if( nums[i] <= target ){
				ways = ways + countCombination(nums,target-nums[i],dp);
			}
		}
		dp[target] = ways;
		return ways;
	}
	public int combinationSum4(int[] nums, int target) {
		int[] dp = new int[target+1];
		Arrays.fill(dp,-1);
		return countCombination(nums,target,dp);
	}

}
