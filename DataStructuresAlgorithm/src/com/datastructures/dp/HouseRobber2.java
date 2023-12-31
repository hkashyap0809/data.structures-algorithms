package com.datastructures.dp;

//https://leetcode.com/problems/house-robber-ii/description/
public class HouseRobber2 {
	
	public int rob(int[] nums) {
		if (nums.length == 0)	return 0;
		if (nums.length == 1) return nums[0];
		if (nums.length == 2)	return Math.max(nums[0],nums[1]);
		int prev = nums[0];
		int prev2 = 0;
		for(int i=1;i<nums.length-1;i++){
			int take = nums[i];
			if(i>1) take= take + prev2;
			int notTake = prev;
			int curr = Math.max(take,notTake);

			prev2 = prev;
			prev = curr;
		}
		int ans = prev;

		prev = nums[1];
		prev2 = 0;
		for(int i=2;i<nums.length;i++){
			int take = nums[i];
			if(i>1) take= take + prev2;
			int notTake = prev;
			int curr = Math.max(take,notTake);

			prev2 = prev;
			prev = curr;
		}   
		return Math.max(ans,prev);
	}

}
