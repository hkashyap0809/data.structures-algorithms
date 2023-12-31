package com.datastructures.dp;

import java.util.ArrayList;
import java.util.Arrays;

public class BuyAndSellStock3 {
	//rec
	public static int maxProfitRec(int day, boolean buy, int max, ArrayList<Integer> prices, int n) {
		if ( day == n )	return 0;
		if (max == 0 ) return 0;

		int profit =0;
		if ( buy ) {
			int buyProfit = maxProfitRec(day+1, false, max, prices, n) - prices.get(day);
			int notBuyProfit = maxProfitRec(day+1, true, max, prices, n);
			profit = Math.max(buyProfit, notBuyProfit);
		}else {
			int sellProfit = maxProfitRec(day+1, true, max-1, prices, n) + prices.get(day);
			int notSellProfit = maxProfitRec(day+1, false, max, prices, n);
			profit = Math.max(sellProfit, notSellProfit);
		}
		return profit;
	}
	public static int maxProfitRec(ArrayList<Integer> prices, int n) {
		return maxProfitRec(0,true,2,prices,n);
	}

	//mem
	public static int maxProfitMem(int day, int buy, int max, ArrayList<Integer> prices, int n,int[][][] dp) {
		if ( day == n )	return 0;
		if (max == 0 ) return 0;

		if( dp[day][buy][max] != -1) 	return dp[day][buy][max];

		int profit =0;
		if ( buy == 1 ) {
			int buyProfit = maxProfitMem(day+1, 0, max, prices, n,dp) - prices.get(day);
			int notBuyProfit = maxProfitMem(day+1, 1, max, prices, n,dp);
			profit = Math.max(buyProfit, notBuyProfit);
		}else {
			int sellProfit = maxProfitMem(day+1, 1, max-1, prices, n,dp) + prices.get(day);
			int notSellProfit = maxProfitMem(day+1, 0, max, prices, n,dp);
			profit = Math.max(sellProfit, notSellProfit);
		}
		dp[day][buy][max] = profit;
		return profit;
	}
	public static int maxProfitMem(ArrayList<Integer> prices, int n) {
		int[][][] dp = new int[n][2][3];
		for(int i=0;i<dp.length;i++) {
			for(int j=0;j<dp[0].length;j++) {
				Arrays.fill(dp[i][j], -1);
			}
		}
		return maxProfitMem(0,1,2,prices,n,dp);
	}

	//tab
	public static int maxProfitTab(ArrayList<Integer> prices, int n) {
		int[][][] dp = new int[n+1][2][3];


		for(int day = n-1; day>=0; day--) {
			for(int buy=0;buy<2;buy++) {
				for(int max = 1;max<=2;max++) {
					int profit =0 ;
					if ( buy == 1 ) {
						int buyProfit = dp[day+1][0][max] - prices.get(day);
						int notBuyProfit = dp[day+1][1][max];
						profit = Math.max(buyProfit, notBuyProfit);
					}else {
						int sellProfit = dp[day+1][1][max-1] + prices.get(day);
						int notSellProfit = dp[day+1][0][max];
						profit = Math.max(sellProfit, notSellProfit);
					}
					dp[day][buy][max] = profit;
				}
			}
		}

		return dp[0][1][2];
	}
	//space opt
	public static int maxProfit(ArrayList<Integer> prices, int n) {
		int[][] prevDp = new int[2][3];


		for(int day = n-1; day>=0; day--) {
			int[][] currDp = new int[2][3];
			for(int buy=0;buy<2;buy++) {
				for(int max = 1;max<=2;max++) {
					int profit =0 ;
					if ( buy == 1 ) {
						int buyProfit = prevDp[0][max] - prices.get(day);
						int notBuyProfit = prevDp[1][max];
						profit = Math.max(buyProfit, notBuyProfit);
					}else {
						int sellProfit = prevDp[1][max-1] + prices.get(day);
						int notSellProfit = prevDp[0][max];
						profit = Math.max(sellProfit, notSellProfit);
					}
					currDp[buy][max] = profit;
				}
			}
			prevDp = currDp;
		}

		return prevDp[1][2];
	}

	//approach 2

	//	rec
	public static int maxProfitRec(int day, int transaction, ArrayList<Integer> prices, int n) {
		if ( day == n || transaction == 4 )	return 0;

		int profit = 0;
		if ( transaction % 2 == 0 ) {
			int buyProfit = maxProfitRec(day+1, transaction+1 , prices, n) - prices.get(day);
			int notBuyProfit = maxProfitRec(day+1, transaction, prices, n);
			profit = Math.max(buyProfit, notBuyProfit);
		}else {
			int sellProfit = maxProfitRec(day+1, transaction+1, prices, n) + prices.get(day);
			int notSellProfit = maxProfitRec(day+1, transaction, prices, n);
			profit = Math.max(sellProfit, notSellProfit);
		}
		return profit;
	}
	public static int maxProfitRec2(ArrayList<Integer> prices, int n) {
		return maxProfitRec(0,0,prices,n);
	}
	//mem
	public static int maxProfitMem(int day, int transaction, ArrayList<Integer> prices, int n,int [][] dp) {
		if ( day == n || transaction == 4 )	return 0;
		if ( dp[day][transaction] != -1)	return dp[day][transaction];

		int profit = 0;
		if ( transaction % 2 == 0 ) {
			int buyProfit = maxProfitMem(day+1, transaction+1 , prices, n,dp) - prices.get(day);
			int notBuyProfit = maxProfitMem(day+1, transaction, prices, n,dp);
			profit = Math.max(buyProfit, notBuyProfit);
		}else {
			int sellProfit = maxProfitMem(day+1, transaction+1, prices, n,dp) + prices.get(day);
			int notSellProfit = maxProfitMem(day+1, transaction, prices, n,dp);
			profit = Math.max(sellProfit, notSellProfit);
		}
		dp[day][transaction] = profit;
		return profit;
	}
	public static int maxProfitMem2(ArrayList<Integer> prices, int n) {
		int[][] dp = new int[n][4];
		for(int i=0;i<dp.length;i++) {
			Arrays.fill(dp[i],-1);
		}
		return maxProfitMem(0,0,prices,n,dp);
	}
	//tab
	public static int maxProfitTab2(ArrayList<Integer> prices, int n) {
		int[][] dp = new int[n+1][5];
		
		for(int day = n-1;day>=0;day--) {
			for(int transaction = 3; transaction>=0;transaction--) {
				int profit = 0;
				if ( transaction % 2 == 0 ) {
					int buyProfit = dp[day+1][transaction+1] - prices.get(day);
					int notBuyProfit = dp[day+1][transaction];
					profit = Math.max(buyProfit, notBuyProfit);
				}else {
					int sellProfit = dp[day+1][transaction+1] + prices.get(day);
					int notSellProfit = dp[day+1][transaction];
					profit = Math.max(sellProfit, notSellProfit);
				}
				dp[day][transaction] = profit;

			}
		}

		return dp[0][0];
	}
	//space opt
	public static int maxProfitSpaceOpt2(ArrayList<Integer> prices, int n) {
		int[] prevDp = new int[5];
		
		for(int day = n-1;day>=0;day--) {
			int[] currDp = new int[5];
			for(int transaction = 3; transaction>=0;transaction--) {
				int profit = 0;
				if ( transaction % 2 == 0 ) {
					int buyProfit = prevDp[transaction+1] - prices.get(day);
					int notBuyProfit = prevDp[transaction];
					profit = Math.max(buyProfit, notBuyProfit);
				}else {
					int sellProfit = prevDp[transaction+1] + prices.get(day);
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
