package com.datastructures.math;

public class LargestPrimeFactorOfN {
	static long largestPrimeFactor(int N) {
		int i = 2;
		int res = Integer.MIN_VALUE;
		while ( N > 1 & i*i <= N){
			if ( N % i == 0 ){
				res = Math.max( res, i);
				N = N / i;
			}else{
				i++;
			}
		}
		if ( N > 1 ) res = Math.max(res,N);
		return res;
	}

}
