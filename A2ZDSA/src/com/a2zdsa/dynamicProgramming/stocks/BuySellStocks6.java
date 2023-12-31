package com.a2zdsa.dynamicProgramming.stocks;

import java.util.Arrays;

public class BuySellStocks6 {
	public int buySellStock6Helper(int idx, int buy, int[] prices, int fee , int[][] dp){
		if ( idx >= prices.length ) return 0;

		if( dp[idx][buy] != -1 )    return dp[idx][buy];

		if( buy == 1 ){
			int buyProfit = buySellStock6Helper(idx+1, 0, prices, fee ,dp) - prices[idx];
			int notBuyProfit = buySellStock6Helper(idx+1, 1, prices, fee ,dp);
			return dp[idx][buy] = Math.max(buyProfit,notBuyProfit);
		}else{
			int sellProfit = buySellStock6Helper(idx+1, 1, prices, fee ,dp) + prices[idx] - fee;
			int notBuyProfit = buySellStock6Helper(idx+1, 0, prices, fee ,dp);
			return dp[idx][buy] = Math.max( sellProfit, notBuyProfit );
		}
	}
	public int maxProfitMem(int[] prices, int fee) {
		int n = prices.length;
		int[][] dp = new int[n][2];
		for( int[] row : dp ){
			Arrays.fill( row, -1 );
		}
		return buySellStock6Helper(0,1,prices,fee,dp);
	}
	//************************************************************************************************************************

	public int maxProfit(int[] prices, int fee ){
		int n = prices.length;
		int[][] dp = new int[n+1][2];

		for( int idx = n-1; idx>=0; idx-- ){
			for( int buy = 0; buy <2; buy++ ){
				if( buy == 1 ){
					int buyProfit = dp[idx+1][0] - prices[idx];
					int notBuyProfit = dp[idx+1][1];
					dp[idx][buy] = Math.max(buyProfit,notBuyProfit);
				}else{
					int sellProfit = dp[idx+1][1] + prices[idx] - fee;
					int notBuyProfit = dp[idx+1][0];
					dp[idx][buy] = Math.max( sellProfit, notBuyProfit );
				}   
			}
		}
		return dp[0][1];
	}

}
