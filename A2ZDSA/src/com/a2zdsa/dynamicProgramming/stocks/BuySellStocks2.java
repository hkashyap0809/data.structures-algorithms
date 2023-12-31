package com.a2zdsa.dynamicProgramming.stocks;

import java.util.Arrays;

public class BuySellStocks2 {
	public int helper(int idx, int[] prices, int buy,int[][] dp ){

		if( idx >= prices.length )  return 0;

		if( dp[idx][buy] != -1 )    return dp[idx][buy];

		if( buy == 1 ){
			//allowed to buy
			int a = helper(idx+1,prices,0,dp) - prices[idx];
			int b = helper(idx+1,prices,1,dp);
			return dp[idx][buy] = Math.max(a,b);
		}else{
			//allowed to sell
			int a = helper(idx+1,prices,1,dp) + prices[idx];
			int b = helper(idx+1,prices,0,dp);
			return dp[idx][buy] = Math.max(a,b);
		}
	}
	public int maxProfitMem(int[] prices) {
		int[][] dp = new int[prices.length][2];
		for( int[] row : dp ){
			Arrays.fill(row,-1);
		}
		return helper(0,prices,1,dp);
	}
	public int maxProfit(int[] prices ){
		int n = prices.length;
		int[][] dp = new int[n+1][2];

		dp[n][0] = 0;
		dp[n][1] = 0;

		for(int idx = n-1; idx>=0; idx-- ){
			for( int buy = 0; buy < 2; buy++ ){
				if( buy == 1 ){
					//allowed to buy    
					int a = dp[idx+1][0] - prices[idx];
					int b = dp[idx+1][1];
					dp[idx][buy] = Math.max(a,b);
				}else{
					//allowed to sell
					int a = dp[idx+1][1] + prices[idx];
					int b = dp[idx+1][0];
					dp[idx][buy] = Math.max(a,b);
				}
			}
		}

		return dp[0][1];
	}

}
