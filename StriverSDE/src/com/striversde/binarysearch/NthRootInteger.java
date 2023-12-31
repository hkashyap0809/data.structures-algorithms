package com.striversde.binarysearch;

public class NthRootInteger {
	public static int NthRootInt(int n, int m) {
		int low = 1;
		int high = m;

		while( high >= low ) {
			int mid = (low+high)/2;
			int res = (int)Math.pow(mid, n);
			if ( res == m ) {
				return mid;
			}else if(res<m) {
				low = mid+1;
			}else {
				high = mid-1;
			}

		}
		return -1;
	}
	public static double NthRootDouble(int n, int m) {
		double low = 1;
		double high = m;
		double tol = 1e-5;
		
		while( high - low > tol ) {
			double mid = (low+high)/2;
			double res = Math.pow(mid, n);
			if( res < m ) {
				high = mid;
			}else {
				low = mid;
			}
		}
		
		return low;
		
	}

}
