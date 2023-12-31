package com.a2zdsa.dynamicProgramming.stocks;

import java.util.Arrays;

public class BuySellStocks3 {

	public int buySellStock3Helper(int idx, int buy, int[] prices, int transaction,int[][][] dp){
		if( idx == prices.length )  return 0;
		if( transaction == -1 )  return 0;

		if( dp[idx][buy][transaction] != -1 )   return dp[idx][buy][transaction];

		if( buy == 1 ){
			//allowed to buy
			int buyProfit = buySellStock3Helper(idx+1, 0,prices, transaction,dp) - prices[idx];
			int notBuyProfit = buySellStock3Helper(idx+1,1, prices, transaction ,dp );
			return dp[idx][buy][transaction] = Math.max( buyProfit, notBuyProfit );
		}else{
			//allowed to sell
			int sellProfit = buySellStock3Helper( idx+1, 1 , prices, transaction - 1  ,dp) + prices[idx];
			int notSellProfit = buySellStock3Helper( idx + 1, 0 , prices, transaction ,dp);
			return dp[idx][buy][transaction] = Math.max( sellProfit, notSellProfit );
		}
	}
	public int maxProfitMem(int[] prices) {
		int[][][] dp = new int[prices.length][2][2];

		for( int[][] row1 : dp ){
			for( int[] row2 : row1 ){
				Arrays.fill(row2,-1);
			}
		}
		return buySellStock3Helper(0,1,prices,1,dp);
	}
	//************************************************************************************************************************
	public int maxProfit(int[] prices ){
		int n = prices.length;
		int[][][] dp = new int[n+1][2][3];

		for( int idx = n-1; idx >= 0 ; idx -- ){
			for( int buy = 0; buy < 2 ; buy++ ){
				for( int transaction = 1; transaction<3; transaction++){
					if( buy == 1 ){
						//allowed to buy
						int buyProfit = dp[idx+1][0][transaction] - prices[idx];
						int notBuyProfit = dp[idx+1][1][transaction];
						dp[idx][buy][transaction] = Math.max( buyProfit, notBuyProfit );
					}else{  
						//allowed to sell
						int sellProfit = dp[idx+1][1][transaction-1] + prices[idx];
						int notSellProfit = dp[idx + 1][0][transaction];
						dp[idx][buy][transaction] = Math.max( sellProfit, notSellProfit );
					}
				}
			}
		}
		return dp[0][1][2];
	}
}
