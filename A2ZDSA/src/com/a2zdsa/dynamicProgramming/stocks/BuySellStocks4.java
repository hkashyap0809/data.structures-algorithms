package com.a2zdsa.dynamicProgramming.stocks;


public class BuySellStocks4 {

	public int maxProfit(int k, int[] prices) {
		int n = prices.length;
		int[][][] dp = new int[n+1][2][k+1];

		for( int idx = n-1; idx >= 0 ; idx -- ){
			for( int buy = 0; buy < 2 ; buy++ ){
				for( int transaction = 1; transaction<=k; transaction++){
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
		return dp[0][1][k];

	}
}
