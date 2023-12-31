package com.datastructures.binarysearch;

public class MedianOfTwoSortedArrays {
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int n1 = nums1.length;
		int n2 = nums2.length;
		if ( n2 < n1 )	return findMedianSortedArrays(nums2,nums1);
		
		int low = 0; 
		int high = n1;
		
		double median = 0;
		while( low <= high ) {
			int cut1 = (low+high)/2;
			int cut2 = (n1+n2+1)/2 - cut1;
			int l1 = cut1 > 0 ? nums1[cut1-1] : Integer.MIN_VALUE;
			int l2 = cut2 > 0 ? nums2[cut2-1] : Integer.MIN_VALUE;
			int r1 = cut1 < n1 ? nums1[cut1] : Integer.MAX_VALUE;
			int r2 = cut2 < n2 ? nums2[cut2] : Integer.MAX_VALUE;
			
			if ( l1 <= r2 && l2 <= r1 ) {
				if ( (n1+n2)%2 == 0 ) {
					median = Math.max(l1, l2) + Math.min(r1, r2);
					median = median / 2;
				}else {
					median = Math.max(l1, l2);
				}
				return median;
			}else if ( l1 >= r2 ) {
				high = cut1 - 1 ;
				
			}else {
				low = cut1 + 1;
			}
		}
		return median;
	}
}
