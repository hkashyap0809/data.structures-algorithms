package com.striversde.dp1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LongestIncreasingSubsequence {

	//Recursion
	public static int lengthOfLISRec(int[] nums, int idx, int prevIdx) {
		if (idx == nums.length)
			return 0;

		int notTakePrev = lengthOfLISRec(nums, idx+1, prevIdx);
		int takePrev = Integer.MIN_VALUE;

		if(prevIdx == -1 || nums[prevIdx]<nums[idx])
			takePrev = 1 + lengthOfLISRec(nums, idx+1, idx);

		return Math.max(notTakePrev, takePrev);
	}
	public static int lengthOfLISRec(int[] nums) {
		return lengthOfLISRec(nums,0,-1);

	}

	//Memoization
	private static int lengthOfLISMem(int[] nums, int idx, int prevIdx, int[][]dp) {
		if(idx == nums.length)	return 0;

		if(dp[idx][prevIdx+1]!=-1) return dp[idx][prevIdx+1];

		int notTakePrev = lengthOfLISMem(nums, idx+1, prevIdx, dp);
		int takePrev = Integer.MIN_VALUE;

		if(prevIdx == -1 || nums[idx] > nums[prevIdx])
			takePrev = 1 + lengthOfLISMem(nums, idx+1, idx, dp);

		dp[idx][prevIdx+1] = Math.max(takePrev, notTakePrev);
		return dp[idx][prevIdx+1];
	}

	public static int lengthOfLISMem(int[] nums) {
		int[][] dp = new int [nums.length][nums.length+1];
		for(int i=0;i<dp.length;i++) {
			Arrays.fill(dp[i], -1);
		}
		return lengthOfLISMem(nums,0,-1,dp);
	}


	//Simple Tabulation
	public int lengthOfLISTab2(int[] nums) {
		int[][] dp = new int[nums.length+1][nums.length+1];

		//		base case
		for(int i=0;i<dp.length;i++) {
			Arrays.fill(dp[i], 0);
		}

		for(int idx=nums.length-1;idx>=0;idx--) {
			for(int prevIdx=idx-1;prevIdx>=-1;prevIdx--) {

				int notTakePrev = dp[idx+1][prevIdx+1];
				int takePrev = Integer.MIN_VALUE;
				if(prevIdx == -1 || nums[idx] > nums[prevIdx])
					takePrev = 1 + dp[idx+1][idx+1];

				dp[idx][prevIdx+1] = Math.max(takePrev, notTakePrev);
			}
		}
		return dp[0][0];
	}

	//	Space Optimization
	public int lengthOfLISSpaceOpt(int[] nums) {
		int[] nextDp = new int[nums.length+1];
		int[] currDp = new int[nums.length+1];

		//		base case
		Arrays.fill(nextDp, 0);
		Arrays.fill(currDp, 0);


		for(int idx=nums.length-1;idx>=0;idx--) {

			for(int prevIdx=idx-1;prevIdx>=-1;prevIdx--) {

				int notTakePrev = nextDp[prevIdx+1];

				int takePrev = Integer.MIN_VALUE;

				if(prevIdx == -1 || nums[idx] > nums[prevIdx])
					takePrev = 1 + nextDp[idx+1];

				currDp[prevIdx+1] = Math.max(takePrev, notTakePrev);
			}
			nextDp = currDp;
		}
		return nextDp[0];
	}

	//	Intuitive
	public int lengthOfLIS(int[] nums) {
		int[] LIS = new int[nums.length];
		Arrays.fill(LIS,1);
		int maxLength = 1;

		for(int i=0 ;i<nums.length;i++) {
			for(int j=0;j<i;j++) {
				if(nums[j] < nums[i])
					LIS[i] = Math.max(LIS[i], 1 + LIS[j]);
			}
			maxLength = Math.max(maxLength, LIS[i]);
		}
		return maxLength;
	}
	//Printing LIS
	public void printLIS(int[] nums) {
		int[] dp = new int[nums.length];
		int[] hash = new int[nums.length];

		for(int i=0;i<nums.length;i++) {
			dp[i]=1;
			hash[i]=i;
		}

		int maxLength = 1;
		int lastIndex = 0;
		for(int i=0;i<nums.length;i++) {
			for(int j=0;j<i;j++) {
				if(nums[i] > nums[j] && dp[i] < 1 + dp[j]) {
					dp[i] = Math.max(dp[i], 1 + dp[j]);
					hash[i] = j;
				}
			}
			if(dp[i] > maxLength) {
				maxLength = dp[i];
				lastIndex = i;
			}
		}

		String LIS="";
		while(hash[lastIndex] != lastIndex) {
			LIS=Integer.toString(nums[lastIndex]) +","+LIS;
			lastIndex = hash[lastIndex];
		}
		LIS = Integer.toString(nums[lastIndex])+","+LIS;
		System.out.println(LIS);
	}

	//Optimal - Binary Search
	public int lengthOfLISBinary(int[] nums) {
		List<Integer> LIS = new ArrayList<Integer>();
		LIS.add(nums[0]);

		for(int i=1;i<nums.length;i++) {
			if(nums[i] > LIS.get(LIS.size()-1)) {
				LIS.add(nums[i]);
			}else {
				int newIdx = Collections.binarySearch(LIS, nums[i]);
				if (newIdx == -1)
					newIdx = 0;
				else if(newIdx < 0){
					newIdx = newIdx + 1;
					newIdx = -1 * newIdx;
				}
				LIS.set(newIdx, nums[i]);
			}
		}

		return LIS.size();
	}
//	
	public static int findNumberOfLIS(int n, int[] arr) {
		int[] dp = new int[n];
		int[] count = new int[n];
		Arrays.fill(dp, 1);
		Arrays.fill(count,1);
		
		int maxLen = 1;
		for(int i=1;i<n;i++) {
			for(int j=0;j<i;j++) {
				
				if(arr[j]< arr[i] && dp[i] < 1 + dp[j]) {
					dp[i] = 1 + dp[j];
					count[i] = count[j];
				}else if(arr[j] < arr[i] && dp[i] == 1 + dp[j] ){
					count[i] = count[i] + count[j];
				}
			}
			maxLen = Math.max(maxLen, dp[i]);
		}
		
		int result = 0;
		for(int i=0;i<n;i++) {
			if( dp[i] == maxLen )	result+=count[i];
		}
		return result;
	}

}
