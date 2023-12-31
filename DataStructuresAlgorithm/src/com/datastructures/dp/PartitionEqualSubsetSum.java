package com.datastructures.dp;

import java.util.Arrays;

public class PartitionEqualSubsetSum {
	//	Recursion
	public static boolean subsetSumToKRec(int idx, int target, int[] arr) {
		if(target ==0 )	return true;
		if (idx == 0) return arr[idx] == target;

		boolean notTake = subsetSumToKRec(idx-1,target,arr);
		boolean take = false;
		if( arr[idx] <= target){
			take = subsetSumToKRec(idx-1, target - arr[idx], arr);
		}

		return take || notTake;
	}
	public static boolean canPartitionRec(int[] arr, int n) {
		int sum = 0;
		for(int i=0;i<arr.length;i++)
			sum = sum + arr[i];

		if(sum%2==0)
			return subsetSumToKRec(n-1, sum/2, arr);
		else 
			return false;

	}

	//	Tabulation
	public static boolean canPartitionTab(int[] arr, int n) {
		int totalSum = 0;
		for(int i=0;i<arr.length;i++)
			totalSum += arr[i];
		if( totalSum%2 == 1) return false;

		int target = totalSum/2;

		boolean[][] dp = new boolean[arr.length][target+1];

		for(int i=0;i<dp.length;i++)
			Arrays.fill(dp[i],false);

		for(int j=0;j<=target;j++) {
			dp[0][j] = arr[0]==j;
		}

		for(int i=0;i<arr.length;i++)
			dp[i][0] = true;

		for(int idx = 1; idx<arr.length;idx++) {
			for(int tar = 1; tar<=target; tar++) {
				boolean notTake = dp[idx-1][tar];
				boolean take = false;
				if(arr[idx]<=tar)
					take = dp[idx-1][tar-arr[idx]];
				dp[idx][tar] = take || notTake;
			}
		}
		return dp[arr.length-1][target];

	}
	//	Space Optimization
	public static boolean canPartition(int[] arr, int n) {
		int totalSum = 0;
		for(int i=0;i<arr.length;i++)
			totalSum += arr[i];
		if( totalSum%2 == 1) return false;

		int target = totalSum/2;

		boolean[] prevDp = new boolean[target+1];


		for(int j=0;j<=target;j++) {
			prevDp[j] = arr[0]==j;
		}

		prevDp[0] = true;

		for(int idx = 1; idx<arr.length;idx++) {
			boolean[] currDp = new boolean[target+1]; 
			for(int tar = 1; tar<=target; tar++) {
				boolean notTake = prevDp[tar];
				boolean take = false;
				if(arr[idx]<=tar)
					take = prevDp[tar-arr[idx]];
				currDp[tar] = take || notTake;
			}
			prevDp = currDp;
		}
		return prevDp[target];

	}

}
