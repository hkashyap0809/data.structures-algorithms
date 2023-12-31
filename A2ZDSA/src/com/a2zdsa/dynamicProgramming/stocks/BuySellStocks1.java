package com.a2zdsa.dynamicProgramming.stocks;

public class BuySellStocks1 {
	public int maxProfit(int[] prices) {
		int profit = 0;
		int buyPrice = prices[0];
		for(int i = 1; i< prices.length; i++ ){
			profit = Math.max( profit, prices[i] - buyPrice);
			buyPrice = Math.min( buyPrice, prices[i]);
		}
		return profit;
	}

}
