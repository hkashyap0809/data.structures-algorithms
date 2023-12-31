package com.datastructures.dp;

import java.util.Arrays;

public class BuyAndSellStock4 {
	public static int maxProfitRec(int day, int transaction, int[] prices, int n, int k) {
		if ( day == n || transaction == 2*k)	return 0;
		
		int profit = 0;
		if( transaction % 2 == 0) {
			int buyProfit = maxProfitRec(day+1, transaction+1, prices, n, k) - prices[day]; 
			int notBuyProfit = maxProfitRec(day + 1, transaction, prices, n, k);
			profit = Math.max(buyProfit, notBuyProfit);
		}else {
			int sellProfit = maxProfitRec(day+1, transaction+1, prices, n, k) + prices[day]; 
			int notSellProfit = maxProfitRec(day + 1, transaction, prices, n, k);
			profit = Math.max(sellProfit, notSellProfit);
		}
		return profit;
	}
	public static int maximumProfitRec(int[] prices, int n, int k){
		return maxProfitRec(0,0,prices,n,k);
	}
	//mem
	public static int maxProfitMem(int day, int transaction, int[] prices, int n, int k,int[][] dp) {
		if ( day == n || transaction == 2*k)	return 0;
		if ( dp[day][transaction] != -1)	return dp[day][transaction];
		
		int profit = 0;
		if( transaction % 2 == 0) {
			int buyProfit = maxProfitMem(day+1, transaction+1, prices, n, k, dp) - prices[day]; 
			int notBuyProfit = maxProfitMem(day + 1, transaction, prices, n, k,dp);
			profit = Math.max(buyProfit, notBuyProfit);
		}else {
			int sellProfit = maxProfitMem(day+1, transaction+1, prices, n, k,dp) + prices[day]; 
			int notSellProfit = maxProfitMem(day + 1, transaction, prices, n, k,dp);
			profit = Math.max(sellProfit, notSellProfit);
		}
		dp[day][transaction] = profit;
		return profit;
	}
	public static int maximumProfitMem(int[] prices, int n, int k){
		int[][] dp = new int[n][2*k];
		for(int i=0;i<dp.length;i++) {
			Arrays.fill(dp[i], -1);
		}
        return maxProfitMem(0,0,prices,n,k,dp);
    }
	
	// tab
	public static int maximumProfitTab(int[] prices, int n, int k){
		int[][] dp = new int[n+1][(2*k)+1];
		
		
		for(int day = n-1; day>=0;day--) {
			for( int transaction = (2*k)-1; transaction>=0; transaction--) {
				int profit = 0;
				if( transaction % 2 == 0) {
					int buyProfit = dp[day+1][transaction+1] - prices[day]; 
					int notBuyProfit = dp[day + 1][transaction];
					profit = Math.max(buyProfit, notBuyProfit);
				}else {
					int sellProfit = dp[day+1][transaction+1] + prices[day]; 
					int notSellProfit = dp[day + 1][transaction];
					profit = Math.max(sellProfit, notSellProfit);
				}
				dp[day][transaction] = profit;
			}
		}
		return dp[0][0];
	}
	
	//space opt
	public static int maximumProfitSpaceOpt(int[] prices, int n, int k){
		int[] prevDp = new int[(2*k)+1];
		
		
		for(int day = n-1; day>=0;day--) {
			int[] currDp = new int[(2*k)+1];
			for( int transaction = (2*k)-1; transaction>=0; transaction--) {
				int profit = 0;
				if( transaction % 2 == 0) {
					int buyProfit = prevDp[transaction+1] - prices[day]; 
					int notBuyProfit = prevDp[transaction];
					profit = Math.max(buyProfit, notBuyProfit);
				}else {
					int sellProfit = prevDp[transaction+1] + prices[day]; 
					int notSellProfit = prevDp[transaction];
					profit = Math.max(sellProfit, notSellProfit);
				}
				currDp[transaction] = profit;
			}
			prevDp = currDp;
		}
		return prevDp[0];
	}
	

}
