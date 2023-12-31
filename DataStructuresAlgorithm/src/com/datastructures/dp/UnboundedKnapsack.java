package com.datastructures.dp;

import java.util.Arrays;

public class UnboundedKnapsack {
	public static int unboundedKnapsackRec(int idx, int[] profit, int[] weight, int maxWeight) {

		if( idx == 0)
			return (maxWeight / weight[0])*profit[0];

		int notTake = unboundedKnapsackRec(idx-1, profit, weight, maxWeight);
		int take = Integer.MIN_VALUE;
		if(weight[idx] <= maxWeight)
			take = profit[idx] + unboundedKnapsackRec(idx, profit, weight, maxWeight - weight[idx]);

		return Math.max(take,notTake);
	}
	public static int unboundedKnapsackRec(int n, int w, int[] profit, int[] weight) {
		return unboundedKnapsackRec(n-1, profit, weight, w);
	}
	//mem
	public static int unboundedKnapsackMem(int idx, int[] profit, int[] weight, int maxWeight,int[][] dp) {

		if( idx == 0)
			return (maxWeight / weight[0])*profit[0];

		if(dp[idx][maxWeight] != -1)return dp[idx][maxWeight];

		int notTake = unboundedKnapsackMem(idx-1, profit, weight, maxWeight,dp);
		int take = Integer.MIN_VALUE;
		if(weight[idx] <= maxWeight)
			take = profit[idx] + unboundedKnapsackMem(idx, profit, weight, maxWeight - weight[idx],dp);

		dp[idx][maxWeight] = Math.max(take,notTake);
		return dp[idx][maxWeight];
	}
	public static int unboundedKnapsackMem(int n, int w, int[] profit, int[] weight) {
		int[][] dp = new int[n][w+1];
		for(int i=0;i<dp.length;i++) {
			Arrays.fill(dp[i], -1);
		}
		return unboundedKnapsackMem(n-1, profit, weight, w,dp);
	}
	//tab
	public static int unboundedKnapsackTab(int n, int w, int[] profit, int[] weight) {
		int[][] dp = new int[n][w+1];
		
		for(int maxWeight = 0; maxWeight<=w; maxWeight++) {
			dp[0][maxWeight] = (maxWeight / weight[0]) * profit[0];
		}
		
		for(int idx = 1;idx<n;idx++) {
			for(int maxWeight = 0; maxWeight<=w;maxWeight++) {
				int notTake = dp[idx-1][maxWeight];
				int take = Integer.MIN_VALUE;
				if(weight[idx] <= maxWeight)
					take = profit[idx] + dp[idx][maxWeight - weight[idx]];

				dp[idx][maxWeight] = Math.max(take,notTake);
			}
		}
		return dp[n-1][w];
	}
}
