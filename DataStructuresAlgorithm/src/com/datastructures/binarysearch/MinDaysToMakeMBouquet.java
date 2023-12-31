package com.datastructures.binarysearch;

public class MinDaysToMakeMBouquet {
	public int minDays(int[] bloomDay, int m, int k) {
		long n = bloomDay.length;
		if( n < (long)m * (long)k ) return -1;

		long low = bloomDay[0];
		long high = bloomDay[0];

		for(long day : bloomDay ) {
			low = Math.min(low, day);
			high = Math.max(high, day);
		}

		if( bloomDay.length == m*k)	return (int)high;

		while(low <= high ) {

			long mid = (low+high)/2;
			if( canWeMake(bloomDay,m,k,mid) ) {
				high = mid - 1;
			}else {
				low = mid + 1;
			}
		}
		return (int)low;
	}

	private boolean canWeMake(int[] bloomDay, long m, long k,long mid) {
		long bouquetMade = 0;
		long adjacentFlowers = 0;
		for(long day : bloomDay ) {
			if( day <= mid ) {
				adjacentFlowers++;
			}else {
				adjacentFlowers = 0;
			}

			if( adjacentFlowers == k ){
				adjacentFlowers = 0;
				bouquetMade++;
			}
		}
		return bouquetMade>=m;
	}
}
