package com.a2zdsa.dynamicProgramming.OneDimensional;

public class HouseRobber2 {
	public int robHelper(int start, int end, int[] nums){
		int n = nums.length;
		int[] dp = new int[n];
		dp[start-1] = nums[start-1];

		for( int i=start; i < end; i++){
			int skipCurrent = dp[i-1];
			int robCurrent = nums[i];
			if( i-2 >= start-1 ){
				robCurrent = nums[i] + dp[i-2];
			}
			dp[i] = Math.max(skipCurrent,robCurrent);
		}
		return dp[end-1];
	}
	public int rob(int[] nums) {

		int n = nums.length;
		if( n == 1 )    return nums[0];
		if( n == 2 )    return Math.max(nums[0],nums[1]);
		int ans1 = robHelper(1,n-1,nums);
		int ans2 = robHelper(2,n,nums);
		return Math.max(ans1,ans2);

	}

}
