package com.datastructures.dp;

import java.util.Arrays;

public class BuyAndSellStock5 {
	public static int stockProfitRec(int day, int buy, int[] prices) {
		if ( day >= prices.length)	return 0;

		int profit = 0;
		if ( buy == 1 ) {
			int buyProfit = stockProfitRec(day+1, 0, prices) - prices[day];
			int notBuyProfit = stockProfitRec(day+1, 1, prices);
			profit = Math.max(buyProfit, notBuyProfit);
		}else {
			int sellProfit = stockProfitRec(day+2, 1, prices) + prices[day];
			int notSellProfit = stockProfitRec(day+1, 0, prices);
			profit = Math.max(sellProfit, notSellProfit);
		}
		return profit;
	}
	public static int stockProfitRec(int[] prices) {
		return stockProfitRec(0,1,prices);
	}

	//me
	public static int stockProfitMem(int day, int buy, int[] prices,int[][] dp) {
		if ( day >= prices.length)	return 0;
		if ( dp[day][buy] != -1)return dp[day][buy];

		int profit = 0;
		if ( buy == 1 ) {
			int buyProfit = stockProfitMem(day+1, 0, prices,dp) - prices[day];
			int notBuyProfit = stockProfitMem(day+1, 1, prices,dp);
			profit = Math.max(buyProfit, notBuyProfit);
		}else {
			int sellProfit = stockProfitMem(day+2, 1, prices,dp) + prices[day];
			int notSellProfit = stockProfitMem(day+1, 0, prices,dp);
			profit = Math.max(sellProfit, notSellProfit);
		}
		dp[day][buy] = profit;
		return profit;
	}
	public static int stockProfitMem(int[] prices) {
		int[][] dp = new int[prices.length][2];
		for(int i=0;i<dp.length;i++)	Arrays.fill(dp[i],-1);
		return stockProfitMem(0,1,prices,dp);
	}
	//tab
	public static int stockProfitTab1(int[] prices) {
		int[][] dp =new int[prices.length+2][2];

		for(int day=prices.length-1; day>=0; day--) {
			for(int buy = 0; buy<=1; buy++) {
				int profit = 0;
				if ( buy == 1 ) {
					int buyProfit = dp[day+1][0] - prices[day];
					int notBuyProfit = dp[day+1][1];
					profit = Math.max(buyProfit, notBuyProfit);
				}else {
					int sellProfit = dp[day+2][1] + prices[day];
					int notSellProfit = dp[day+1][0];
					profit = Math.max(sellProfit, notSellProfit);
				}
				dp[day][buy] = profit;
			}
		}
		return dp[0][1];
	}
	public static int stockProfitTab2(int[] prices) {
		int[][] dp =new int[prices.length+2][2];

		for(int day=prices.length-1; day>=0; day--) {

			int buyProfit = dp[day+1][0] - prices[day];
			int notBuyProfit = dp[day+1][1];
			dp[day][1] = Math.max(buyProfit, notBuyProfit);

			int sellProfit = dp[day+2][1] + prices[day];
			int notSellProfit = dp[day+1][0];
			dp[day][0]= Math.max(sellProfit, notSellProfit);

		}
		return dp[0][1];
	}

}
