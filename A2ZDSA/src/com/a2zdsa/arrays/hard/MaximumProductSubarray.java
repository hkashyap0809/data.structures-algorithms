package com.a2zdsa.arrays.hard;

public class MaximumProductSubarray {
	public int maxProduct(int[] nums) {

		int maxProd = Integer.MIN_VALUE;
		int prefixProd = 1;
		int suffixProd = 1;
		int n = nums.length;

		for( int i =0; i< n; i++){
			prefixProd = prefixProd * nums[i];
			suffixProd = suffixProd * nums[n-1-i];

			maxProd = Math.max(maxProd,Math.max(prefixProd,suffixProd));

			if( prefixProd == 0 )   prefixProd = 1;
			if( suffixProd == 0 )   suffixProd = 1;
		}
		return maxProd;  
	}

}
