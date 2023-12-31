package com.striversde.arrays;

public class SortColors {
	//Better
	public void sortColorsBetter(int[] nums) {
		int zeros = 0;
		int ones = 0;
		int twos = 0;
		for ( int i=0; i<nums.length;i++){
			if(nums[i]==0)  zeros++;
			if(nums[i]==1)  ones++;
			if(nums[i]==2)  twos++;
		}

		for(int i=0;i<nums.length;i++){
			if( zeros > 0 ) {nums[i]=0;
			zeros--;}
			else if ( ones > 0) {nums[i]=1;
			ones--;}
			else if (twos > 0 ){ nums[i]=2;
			twos--;}
		}
	}

	//	Optimal
	public void swap(int i,int j, int[] nums) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
	public void sortColorsOtimal(int[] nums) {
		int low = 0;
		int mid = 0;
		int high = nums.length - 1;

		while( mid <= high) {
			if( nums[mid] == 0) {
				swap(mid,low,nums);
				low++;
				mid++;
			}else if( nums[mid] == 1 ) {
				mid++;
			}else if ( nums[mid] == 2) {
				swap(mid,high,nums);
				high--;
			}
		}
	}

}
