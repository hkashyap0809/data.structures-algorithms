package com.a2zdsa.dynamicProgramming.OneDimensional;

import java.util.Arrays;

public class HouseRobber1 {
	
	public int robHelper( int idx, int[] nums, int[] dp){
		if( idx < 0 )  return 0;
		if( dp[idx] != -1 ) return dp[idx];

		int skipCurrent = robHelper(idx-1,nums,dp);
		int robCurrent = nums[idx] + robHelper(idx-2, nums,dp);

		return dp[idx] = Math.max(skipCurrent,robCurrent);
	}
	public int robMEM(int[] nums) {
		int[] dp = new int[nums.length];
		Arrays.fill(dp,-1);
		return robHelper(nums.length-1,nums,dp);
	}
	
	public int robTAB(int[] nums) {
        if( nums.length == 1 )  return nums[0];
        if( nums.length == 2 )  return Math.max(nums[0],nums[1]);

        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for( int idx = 1; idx < nums.length; idx++){
            int skipCurrent = dp[idx-1];
            int robCurrent = nums[idx];
            if( idx-2 >=0 )
                robCurrent = nums[idx] + dp[idx-2];
            dp[idx] = Math.max(skipCurrent,robCurrent);
        }
        return dp[nums.length-1]; 
    }

}
