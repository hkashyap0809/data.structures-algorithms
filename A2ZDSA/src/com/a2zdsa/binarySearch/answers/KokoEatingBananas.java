package com.a2zdsa.binarySearch.answers;

public class KokoEatingBananas {


	// [ 3 , 6 , 7 , 11 ] h = 8
	// low = 1, high = 11, mid = 6, tE = 6
	//low =1, high = 5 , mid = 3, tE = 10
	// low  = 4, high = 5, mid = 4, tE = 8
	// high = 3, low = 4

	public int minEatingSpeed(int[] piles, int h) {


		long low = 1;
		long high = piles[0];
		for( int pile : piles )	high = Math.max( high,  pile);


		while( low <= high ) {
			long mid = low + ( high - low) / 2;
			long timeToEat = getTimeToEat(piles, mid);
			if( timeToEat <= h ) {
				high = mid - 1;
			}else {
				low = mid + 1;
			}
		}
		return (int)low;
	}

	private long getTimeToEat(int[] piles, long mid) {
		long countHours = 0;
		for( int pile : piles ) {

			countHours = countHours + (long)Math.ceil((double)pile / (double) mid);
		}
		return countHours;
	}

}

