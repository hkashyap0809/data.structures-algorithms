package com.striversde.arrays3;

public class Power {
	public double myPow(double x, int n) {
		if ( n==0 ) return 1.0;        
		long  k = (long)n;
		if ( k < 0) k= -1*k;

		double res = 1.0;
		while( k > 0 ){
			if ( k%2 == 1){
				//odd
				res = x * res;
				k = k-1;
			}else{
				//even power
				x = x * x;
				k = k/2;
			}
		}

		if ( n < 0 )    
			return 1/res;
		else
			return res;

	}
}
