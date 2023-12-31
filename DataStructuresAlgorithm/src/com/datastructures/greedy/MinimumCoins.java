package com.datastructures.greedy;

import java.util.ArrayList;
import java.util.List;

public class MinimumCoins {
	static List<Integer> minPartition(int amount){
		List<Integer> coins = new ArrayList<Integer>();
		int[] denomination = { 1, 2, 5, 10, 20, 50, 100, 200, 500, 2000 };
		int j = denomination.length-1;

		while(amount != 0) {
			if ( denomination[j] > amount ) {
				j--;
			}else {
				coins.add(denomination[j]);
				amount = amount - denomination[j];
			}
		}
		return coins;

	}


}
