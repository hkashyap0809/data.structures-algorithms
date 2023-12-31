package com.striversde.arrays3;

public class ReversePair {

	public static int reversePairs(int[] nums) {

		return mergeSortCountReversePairs(0,nums.length-1,nums);
	}


	private static int mergeSortCountReversePairs(int low, int end, int[] nums) {
		int countReverse = 0;
		if ( low < end ) {
			int mid = (low+end)/2;
			countReverse += mergeSortCountReversePairs(low,mid,nums);
			countReverse += mergeSortCountReversePairs(mid+1,end,nums);
			countReverse += countReversePairs(low,mid,end,nums);
			merge(low,mid,end,nums);
			return countReverse;
		}else {
			return countReverse;
		}

	}

	private static void merge(int low, int mid, int end, int[] nums) {
		int[] sortedArr = new int[end-low+1];
		int i = low;
		int j = mid+1;

		int k=0;
		while( i<= mid && j<=end) {
			if( nums[i] > nums[j] ) {
				sortedArr[k++]=nums[j++];
			}else {
				sortedArr[k++]=nums[i++];
			}
		}

		while(i<=mid) {
			sortedArr[k++]=nums[i++];
		}
		while(j<=end) {
			sortedArr[k++]=nums[j++];
		}

		for(int x=0;x<sortedArr.length;x++) {
			nums[low+x]=sortedArr[x];
		}		
	}

	private static int countReversePairs(int low, int mid, int end, int[] nums) {
		int countReversePairs = 0;

		int j = mid+1;
		for(int i = low; i<= mid; i++) {
			while( j<= end && nums[i]> 2*nums[j] ) {
				j++;
			}
			countReversePairs += j-(mid+1);
		}

		return countReversePairs;

	}

}
