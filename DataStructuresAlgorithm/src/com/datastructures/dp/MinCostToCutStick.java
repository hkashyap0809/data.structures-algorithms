package com.datastructures.dp;

import java.util.Arrays;

public class MinCostToCutStick {
	//	Recursive Solution
	public int minCost(int n,int[] cuts, int i, int j) {

		if(i > j) return 0;

		int minCost = Integer.MAX_VALUE;
		for(int idx = i ; idx <=j; idx++) {
			int cost = cuts[j+1] - cuts[i-1];
			int leftCut = minCost(n,cuts,i,idx-1);
			int rightCut = minCost(n,cuts,idx+1,j);
			minCost = Math.min(minCost, cost+leftCut+rightCut);
		}
		return minCost;
	}

	public int minCostRec(int n, int[] cuts) {

		Arrays.sort(cuts);
		int[] newCuts = new int[cuts.length+2];
		newCuts[0] = 0;
		newCuts[newCuts.length-1] = n;

		for(int i=1;i<=cuts.length;i++) {
			newCuts[i]=cuts[i-1];
		}
		cuts = newCuts;

		return minCost(n,cuts,1,cuts.length-2);
	}

	//	memoization
	public int minCost(int n,int[] cuts, int i, int j,int[][] dp) {

		if(i > j) return 0;
		if(dp[i][j] != -1)	return dp[i][j];

		int minCost = Integer.MAX_VALUE;
		for(int idx = i ; idx <=j; idx++) {
			int cost = cuts[j+1] - cuts[i-1];
			int leftCut = minCost(n,cuts,i,idx-1,dp);
			int rightCut = minCost(n,cuts,idx+1,j,dp);
			minCost = Math.min(minCost, cost+leftCut+rightCut);
		}
		dp[i][j]=minCost;
		return minCost;
	}

	public int minCostMem(int n, int[] cuts) {

		Arrays.sort(cuts);
		int[] newCuts = new int[cuts.length+2];
		newCuts[0] = 0;
		newCuts[newCuts.length-1] = n;

		for(int i=1;i<=cuts.length;i++) {
			newCuts[i]=cuts[i-1];
		}
		cuts = newCuts;
		int[][] dp = new int[cuts.length][cuts.length];
		for(int i=0;i<dp.length;i++)
			Arrays.fill(dp[i],-1);
		return minCost(n,cuts,1,cuts.length-2,dp);
	}



	//	tabulation
	public int minCost(int n, int[] cuts) {

		Arrays.sort(cuts);
		int[] newCuts = new int[cuts.length+2];
		newCuts[0] = 0;
		newCuts[newCuts.length-1] = n;

		for(int i=1;i<=cuts.length;i++) {
			newCuts[i]=cuts[i-1];
		}
		cuts = newCuts;

		int[][] dp = new int[cuts.length][cuts.length];

		for(int i=0;i<dp.length;i++)
			Arrays.fill(dp[i],0);

		for(int i = cuts.length-2; i>=1 ; i--) {
			for(int j = 1 ; j<=cuts.length-2;j++) {
				if(i > j ) continue;

				int minCost = Integer.MAX_VALUE;
				for(int idx = i ;idx <=j;idx++) {
					int cost = cuts[j+1] - cuts[i-1];
					int leftCut = dp[i][idx-1];
					int rightCut = dp[idx+1][j];
					minCost = Math.min(minCost, cost+leftCut+rightCut);
				}
				dp[i][j]=minCost;
			}
		}
		return dp[1][cuts.length-2];
	}

}
