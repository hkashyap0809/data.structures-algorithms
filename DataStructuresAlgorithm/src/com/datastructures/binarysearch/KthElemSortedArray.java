package com.datastructures.binarysearch;

public class KthElemSortedArray {
	public long kthElement( int nums1[], int nums2[], int n, int m, int k) {
		int n1 = nums1.length;
		int n2 = nums2.length;
		if ( n2 < n1 )	return kthElement(nums2,nums1, m,n,k);

		int low = 0; 
		int high = n1;

		//edge cases
		if ( k < n1 ) high = k;
		if ( k > n2 )	low = k - n2;

		long maxElem = 0;
		while( low <= high ) {
			int cut1 = (low+high)/2;
			int cut2 = k - cut1;
			int l1 = cut1 > 0 ? nums1[cut1-1] : Integer.MIN_VALUE;
			int l2 = cut2 > 0 ? nums2[cut2-1] : Integer.MIN_VALUE;
			int r1 = cut1 < n1 ? nums1[cut1] : Integer.MAX_VALUE;
			int r2 = cut2 < n2 ? nums2[cut2] : Integer.MAX_VALUE;

			if ( l1 <= r2 && l2 <= r1 ) {
				maxElem = Math.max(l1,l2);
				return maxElem;
			}else if ( l1 >= r2 ) {
				high = cut1 - 1 ;

			}else {
				low = cut1 + 1;
			}


		}
		return maxElem;


	}

}
