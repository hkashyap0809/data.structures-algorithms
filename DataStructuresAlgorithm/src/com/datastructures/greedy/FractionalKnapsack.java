package com.datastructures.greedy;

import java.util.Arrays;
import java.util.Comparator;

class Item {
	int value, weight;
	Item(int x, int y){
		this.value = x;
		this.weight = y;
	}
}

class ItemComparator implements Comparator<Item>{

	@Override
	public int compare(Item o1, Item o2) {
		double p1 = (double)o1.value/(double)o1.weight;
		double p2 = (double)o2.value/(double)o2.weight;
		
		if ( p1 > p2 ) return -11;
		else if ( p1 < p2 )	return 1;
		else return 0;
	}
	
}

public class FractionalKnapsack {
	double fractionalKnapsack(int W, Item arr[], int n) {
		ItemComparator itemComparator = new ItemComparator();
		Arrays.sort(arr, itemComparator);
		double maxProfit = 0;
		for(int i=0; i<arr.length;i++) {

			if ( W >= arr[i].weight ) {
				maxProfit = maxProfit + arr[i].value;
				W = W - arr[i].weight;
			}else {
				maxProfit = maxProfit + ((double)arr[i].value/(double)arr[i].weight) * W;
				break;
			}
		}
		return maxProfit;
	}

}
