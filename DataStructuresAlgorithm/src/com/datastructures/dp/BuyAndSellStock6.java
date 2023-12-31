package com.datastructures.dp;

import java.util.Arrays;

public class BuyAndSellStock6 {
	public static int stockProfitRec(int day, int buy, int[] prices,int fee) {
		if ( day >= prices.length)	return 0;

		int profit = 0;
		if ( buy == 1 ) {
			int buyProfit = stockProfitRec(day+1, 0, prices,fee) - prices[day];
			int notBuyProfit = stockProfitRec(day+1, 1, prices,fee);
			profit = Math.max(buyProfit, notBuyProfit);
		}else {
			int sellProfit = stockProfitRec(day+1, 1, prices,fee) + prices[day]-fee;
			int notSellProfit = stockProfitRec(day+1, 0, prices,fee);
			profit = Math.max(sellProfit, notSellProfit);
		}
		return profit;
	}
	public static int maximumProfitRec(int n, int fee, int[] prices) {
		return stockProfitRec(0,1,prices,fee);
	}


	//me
	public static int stockProfitMem(int day, int buy, int[] prices,int[][] dp,int fee) {
		if ( day >= prices.length)	return 0;
		if ( dp[day][buy] != -1)return dp[day][buy];

		int profit = 0;
		if ( buy == 1 ) {
			int buyProfit = stockProfitMem(day+1, 0, prices,dp,fee) - prices[day];
			int notBuyProfit = stockProfitMem(day+1, 1, prices,dp,fee);
			profit = Math.max(buyProfit, notBuyProfit);
		}else {
			int sellProfit = stockProfitMem(day+1, 1, prices,dp,fee) + prices[day]-fee;
			int notSellProfit = stockProfitMem(day+1, 0, prices,dp,fee);
			profit = Math.max(sellProfit, notSellProfit);
		}
		dp[day][buy] = profit;
		return profit;
	}
	public static int maximumProfitMem(int n, int fee, int[] prices) {		
		int[][] dp = new int[prices.length][2];
		for(int i=0;i<dp.length;i++)	Arrays.fill(dp[i],-1);
		return stockProfitMem(0,1,prices,dp,fee);
	}
	//tab
	public static int maximumProfitTab1(int n, int fee, int[] prices) {	
		int[][] dp =new int[prices.length+2][2];

		for(int day=prices.length-1; day>=0; day--) {
			for(int buy = 0; buy<=1; buy++) {
				int profit = 0;
				if ( buy == 1 ) {
					int buyProfit = dp[day+1][0] - prices[day];
					int notBuyProfit = dp[day+1][1];
					profit = Math.max(buyProfit, notBuyProfit);
				}else {
					int sellProfit = dp[day+1][1] + prices[day]-fee;
					int notSellProfit = dp[day+1][0];
					profit = Math.max(sellProfit, notSellProfit);
				}
				dp[day][buy] = profit;
			}
		}
		return dp[0][1];
	}
	
	
	public static int maximumProfitTab2(int n, int fee, int[] prices) {	
		int[][] dp =new int[prices.length+2][2];

		for(int day=prices.length-1; day>=0; day--) {

			int buyProfit = dp[day+1][0] - prices[day];
			int notBuyProfit = dp[day+1][1];
			dp[day][1] = Math.max(buyProfit, notBuyProfit);

			int sellProfit = dp[day+1][1] + prices[day]-fee;
			int notSellProfit = dp[day+1][0];
			dp[day][0]= Math.max(sellProfit, notSellProfit);

		}
		return dp[0][1];
	}

}
