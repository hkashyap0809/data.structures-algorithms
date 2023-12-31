package com.datastructures.dp;

import java.util.ArrayList;

public class BuyAndSellStock1 {
	public static int maximumProfit(ArrayList<Integer> prices){
		int minPrice = prices.get(0);
		int maxProfit = 0;
		
		for(int i =1 ; i<prices.size(); i++) {
			int currProfit = prices.get(i) - minPrice;
			maxProfit = Math.max(maxProfit, currProfit);
			minPrice = Math.min(minPrice, prices.get(i));
		}
		return maxProfit;
	}
}
