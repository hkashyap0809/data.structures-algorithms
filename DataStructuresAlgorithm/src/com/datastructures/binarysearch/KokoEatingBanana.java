package com.datastructures.binarysearch;

public class KokoEatingBanana {
	public int minEatingSpeed(int[] piles, int h) {
		int low = 1;
		int high = piles[0];
		for(int pile : piles) {
			high = Math.max(high, pile);
		}

		while( low <= high ) {
			int mid = (low + high)/2;
			int reqTime = timeToEatAllBanana(piles,mid);
			if ( reqTime <= h) {
				high = mid - 1;
			}else {
				low = mid + 1;
			}

		}
		return low;
	}

	private int timeToEatAllBanana(int[] piles, int n) {
		int timeToEat = 0;
		for(int pile : piles ) {
			timeToEat += Math.ceil((double)pile/(double)n);
		}
		return timeToEat;
	}
}
