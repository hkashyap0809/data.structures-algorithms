package com.datastructures.dp;

import java.util.Arrays;

public class BuyAndSellStock2 {
	public static long getMaxProfitRec(int idx, long[] values, boolean buy) {

		if ( idx == values.length )	return 0;
		long profit = 0;
		if ( buy ) {
			long buyProfit = getMaxProfitRec(idx +1, values, false ) - values[idx];
			long notBuyProfit = getMaxProfitRec(idx+1, values, true);
			profit = Math.max(buyProfit, notBuyProfit);
		}else {
			long sellProfit = getMaxProfitRec(idx +1, values, true ) + values[idx];
			long notSellProfit = getMaxProfitRec(idx+1, values, false);
			profit =  Math.max(sellProfit, notSellProfit);
		}
		return profit;
	}
	public static long getMaximumProfitRec(int n, long[] values) {
		return getMaxProfitRec(0,values,true);
	}
	//mem
	public static long getMaxProfitMem(int idx, long[] values, int buy,long[][] dp) {

		if ( idx == values.length )	return 0;
		if ( dp[idx][buy] != -1 )	return dp[idx][buy];
		long profit = 0;

		if ( buy == 1 ) {
			long buyProfit = getMaxProfitMem(idx +1, values, 0, dp ) - values[idx];
			long notBuyProfit = getMaxProfitMem(idx+1, values, 1,dp);
			profit = Math.max(buyProfit, notBuyProfit);
		}else {
			long sellProfit = getMaxProfitMem(idx +1, values, 1 , dp) + values[idx];
			long notSellProfit = getMaxProfitMem(idx+1, values, 0, dp);
			profit =  Math.max(sellProfit, notSellProfit);
		}
		dp[idx][buy] = profit;
		return profit;
	}
	public static long getMaximumProfitMem(int n, long[] values) {
		long[][] dp = new long[n][2];
		for(int i=0;i<dp.length;i++)	Arrays.fill(dp[i],-1);
		return getMaxProfitMem(0,values,1,dp);
	}
	//	tab

	public static long getMaximumProfitTab(int n, long[] values) {
		n = values.length;
		long[][] dp = new long[n+1][2];

		dp[n][0] = 0;
		dp[n][1] = 0;

		for(int idx=n-1;idx>=0;idx--) {
			for(int buy=0;buy<2;buy++) {
				long profit = 0;

				if ( buy == 1 ) {
					long buyProfit = dp[idx+1][0] - values[idx];
					long notBuyProfit = dp[idx+1][1];
					profit = Math.max(buyProfit, notBuyProfit);
				}else {
					long sellProfit = dp[idx +1][1] + values[idx];
					long notSellProfit = dp[idx+1][0];
					profit =  Math.max(sellProfit, notSellProfit);
				}
				dp[idx][buy] = profit;
			}
		}

		return dp[0][1];
	}
	public static long getMaximumProfitSpaceOpt(int n, long[] values) {
		
		long[] prevDp = new long[2];

		prevDp[0] = 0;
		prevDp[1] = 0;

		for(int idx=n-1;idx>=0;idx--) {
			long[] currDp = new long[2];
			for(int buy=0;buy<2;buy++) {
				long profit = 0;

				if ( buy == 1 ) {
					long buyProfit = prevDp[0] - values[idx];
					long notBuyProfit = prevDp[1];
					profit = Math.max(buyProfit, notBuyProfit);
				}else {
					long sellProfit = prevDp[1] + values[idx];
					long notSellProfit = prevDp[0];
					profit =  Math.max(sellProfit, notSellProfit);
				}
				currDp[buy] = profit;
			}
			prevDp = currDp;
		}

		return prevDp[1];
	}
	//optimal

}
