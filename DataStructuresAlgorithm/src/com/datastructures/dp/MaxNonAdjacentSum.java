package com.datastructures.dp;

import java.util.ArrayList;
import java.util.Arrays;

public class MaxNonAdjacentSum {

//	RECURSION
//	public static int maximumNonAdjacentSum(ArrayList<Integer> nums) {
//		return maximumNonAdjacentSum(nums,nums.size()-1);
//
//	}
//
//	public static int maximumNonAdjacentSum(ArrayList<Integer> nums, int idx) {
//
//		if(idx == 0)	return nums.get(idx);
//		if(idx<0)	return 0;
//
//		int take = nums.get(idx) + maximumNonAdjacentSum(nums, idx-2);
//		int notTake = maximumNonAdjacentSum(nums, idx-1);
//
//		return Math.max(take, notTake);
//	}
	
//	MEMOIZATION
//	public static int maximumNonAdjacentSum(ArrayList<Integer> nums) {
//		int[] dp = new int[nums.size()];
//		Arrays.fill(dp, -1);
//		return maximumNonAdjacentSum(nums,nums.size()-1,dp);
//
//	}
//
//	public static int maximumNonAdjacentSum(ArrayList<Integer> nums, int idx, int[] dp) {
//
//		if(idx == 0)	return nums.get(idx);
//		if(idx<0)	return 0;
//		if(dp[idx]!=-1)	return dp[idx];
//
//		int take = nums.get(idx) + maximumNonAdjacentSum(nums, idx-2,dp);
//		int notTake = maximumNonAdjacentSum(nums, idx-1,dp);
//
//		dp[idx]= Math.max(take, notTake);
//		return dp[idx];
//	}
	
//	TABULATION
	public static int maximumNonAdjacentSum(ArrayList<Integer> nums) {
		int[] dp = new int[nums.size()];
		
		dp[0]=nums.get(0);
		
		for(int i=1; i<nums.size();i++) {
			int take = nums.get(i) ;
			if(i>1) 
				take = take + dp[i-2];
			int notTake = dp[i-1];
			dp[i] = Math.max(take, notTake);
		}
		return dp[nums.size()-1];
	}
	
//	SPACE OPTIMIZATION
	public static int maximumNonAdjacentSum(ArrayList<Integer> nums) {
		
		int prev = nums.get(0);
		int prev2 = 0;
		for(int i=1;i<nums.size();i++) { 
			int take = nums.get(i);
			if(i>1) take = take + prev2;
			
			int notTake = prev;
			int curr = Math.max(take, notTake);
			
			prev2 = prev;
			prev = curr;
		}
		return prev;
	}
}
