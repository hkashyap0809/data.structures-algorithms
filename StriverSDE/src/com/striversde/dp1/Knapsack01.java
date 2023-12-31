package com.striversde.dp1;

import java.util.Arrays;

public class Knapsack01 {
	//Recursion
	public static int maxValKnapsackRec(int idx, int[] weight, int[] value, int maxWeight) {
		if (idx == 0 ) {
			if(weight[0]<= maxWeight)	return value[0];
			else return 0;
		}

		int notTake = maxValKnapsackRec(idx-1, weight, value, maxWeight );
		int take = Integer.MIN_VALUE;
		if ( weight[idx] <= maxWeight )
			take = value[idx] + maxValKnapsackRec(idx-1, weight, value, maxWeight - weight[idx]);

		return Math.max(take,notTake);
	}
	static int knapsackRec(int[] weight, int[] value, int n, int maxWeight) {
		return maxValKnapsackRec(n-1,weight,value,maxWeight);
	}

	//Memoization
	public static int maxValKnapsackMem(int idx, int[] weight, int[] value, int maxWeight,int[][] dp){
		if (idx == 0 ) {
			if(weight[0]<= maxWeight)	
				return value[0];
			else 
				return 0;
		}
		if( dp[idx][maxWeight] != -1)	return dp[idx][maxWeight];

		int notTake = maxValKnapsackMem(idx-1, weight, value, maxWeight,dp );
		int take = Integer.MIN_VALUE;
		if ( weight[idx] <= maxWeight )
			take = value[idx] + maxValKnapsackMem(idx-1, weight, value, maxWeight - weight[idx],dp);

		return dp[idx][maxWeight] = Math.max(take,notTake);
	}

	public static int knapsackMem(int[] weights, int[] values, int n, int maxWeight) {
		int[][] dp = new int[n][maxWeight+1];
		for(int i=0;i<dp.length;i++)
			Arrays.fill(dp[i],-1);
		return maxValKnapsackMem(n-1,weights,values,maxWeight,dp);
	}

	//Tabulation
	public static int knapsackTab(int[] weights, int[] values, int n, int maxWeight) {

		int[][] dp =new int[n][maxWeight+1];
		for(int i=0;i<=maxWeight;i++){
			if(i>=weights[0])
				dp[0][i] = values[0];
		}


		for(int idx = 1; idx <n;idx++){
			for(int weight = 0;weight<=maxWeight;weight++){

				int notTake = dp[idx-1][weight];
				int take = Integer.MIN_VALUE;

				if ( weights[idx] <= weight )
					take = values[idx] + dp[idx-1][weight-weights[idx]];
				dp[idx][weight] = Math.max(take,notTake);
			}
		}
		return dp[n-1][maxWeight];
	}
	//space optimization 1
	public static int knapsackSO1(int[] weights, int[] values, int n, int maxWeight) {


		int[] prevDp = new int[maxWeight+1];

		for(int i=0;i<=maxWeight;i++){
			if(i>=weights[0])
				prevDp[i] = values[0];
		}


		for(int idx = 1; idx <n;idx++){
			int[] currDp = new int[maxWeight+1];

			for(int weight = 0;weight<=maxWeight;weight++){

				int notTake = prevDp[weight];
				int take = Integer.MIN_VALUE;

				if ( weights[idx] <= weight )
					take = values[idx] + prevDp[weight-weights[idx]];
				currDp[weight] = Math.max(take,notTake);
			}
			prevDp = currDp;
		}
		return prevDp[maxWeight];
	}
	//space optimization 2
	public static int knapsack(int[] weights, int[] values, int n, int maxWeight) {


		int[] prevDp = new int[maxWeight+1];

		for(int i=0;i<=maxWeight;i++){
			if(i>=weights[0])
				prevDp[i] = values[0];
		}


		for(int idx = 1; idx <n;idx++){
			for(int weight = maxWeight;weight>=0;weight--){

				int notTake = prevDp[weight];
				int take = Integer.MIN_VALUE;

				if ( weights[idx] <= weight )
					take = values[idx] + prevDp[weight-weights[idx]];
				prevDp[weight] = Math.max(take,notTake);
			}

		}
		return prevDp[maxWeight];
	}
}
