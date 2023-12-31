package com.striversde.arrays2;

public class MergeSortedArrays {
	public void merge(int[] nums1, int m, int[] nums2, int n) {

		int i = m-1;
		int j = n-1;
		int k = m+n-1;
		while(i >= 0 && j >= 0){
			if(nums1[i] < nums2[j])
				nums1[k--] = nums2[j--];
			else
				nums1[k--] = nums1[i--];
		}
		while( i >=0 )
			nums1[k--] = nums1[i--];

		while(j >= 0)
			nums1[k--] = nums2[j--];

	}

	//gap method
	public static void swap(int i, int j, long arr1[], long arr2[]) {
		long temp = arr1[i];
		arr1[i] = arr2[j];
		arr2[j] = temp;
	}
	public static int ceil(int a) {
		if ( a == 1)	return 0;
		return a%2==0 ? a/2 : (a+1)/2;
	}
	public static void merge(long arr1[], long arr2[], int n, int m) {
		int gap = ceil(m+n);

		while(gap>0) {
			int left = 0;
			int right = left + gap;

			while(right < n+m) {

				if ( right < n ) {
					if ( arr1[left] > arr1[right]) {
						swap(left,right,arr1,arr1);
					}
				}else {
					int tempRight = right - n;
					if ( left < n ) {
						if ( arr1[left] > arr2[tempRight] ) {
							swap(left,tempRight,arr1,arr2);
						}
					}else {
						int tempLeft = left - n;
						if ( arr2[tempLeft] > arr2[tempRight]) {
							swap(tempLeft,tempRight,arr2,arr2);
						}
					}
				}
				left++;
				right++;
			}
			gap = ceil(gap);
		}
	}
}
