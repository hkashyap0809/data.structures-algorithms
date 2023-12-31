package com.a2zdsa.dynamicProgramming.subsequences;

import java.util.Arrays;

public class CoinChange2 {
	public int coinChange2(int idx, int amount, int[] coins,int[][] dp){


		if ( idx == coins.length-1 ){
			return amount%coins[idx] == 0 ? 1 : 0;    
		}

		if( dp[idx][amount] != -1 ) return dp[idx][amount];

		int notTake = coinChange2( idx+1, amount, coins, dp);
		int take = 0;
		if( amount >= coins[idx] )
			take = coinChange2( idx, amount - coins[idx], coins,dp);

		return dp[idx][amount] = notTake + take;
	}
	public int changeMem(int amount, int[] coins) {
		int[][] dp = new int[coins.length][amount+1];
		for( int[] row : dp )   Arrays.fill( row,-1);
		return coinChange2(0,amount,coins,dp);

	}
	public int change(int target, int[] coins ){
		int n = coins.length;
		int[][] dp = new int[n][target+1];

		for( int j = 0; j<= target; j++ ){
			dp[n-1][j]= j%coins[n-1]==0 ? 1 : 0;
		}

		for( int idx = n-2; idx >=0 ; idx-- ){
			for( int amount = 0; amount <= target; amount++ ){
				int notTake = dp[idx+1][amount];
				int take = 0;
				if( amount >= coins[idx] )
					take = dp[idx][amount - coins[idx]];

				dp[idx][amount] = notTake + take;
			}
		}
		return dp[0][target];
	}
}
