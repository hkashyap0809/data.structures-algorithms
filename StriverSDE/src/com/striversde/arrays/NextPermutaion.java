package com.striversde.arrays;

public class NextPermutaion {
	public void reverse(int start, int end, int[] nums) {
		while( start <= end ) {
			int temp = nums[start];
			nums[start] = nums[end];
			nums[end] = temp;
			start++;
			end--;
		}
	}

	public void nextPermutation(int[] nums) {
		
		int n = nums.length;
		//find the breaking index such that we have longest prefix
		int brkIdx = -1;
		for( int i = n-2; i>=0;i--) {
			if( nums[i] < nums[i+1] ) {
				brkIdx = i;
				break;
			}
		}
		//if no break index found then that is the last permutation
		//just reverse it
		if (brkIdx == -1 ) {
			reverse(0,n-1,nums);
			return;
		}
		//find the next biggest number
		int nextSmallIdx = n-1;
		for (int i = n-1; i>brkIdx; i--) {
			if ( nums[i] > nums[brkIdx] ) {
				nextSmallIdx = i;
				break;
			}
		}
		// swap the numbers
		int temp =nums[nextSmallIdx];
		nums[nextSmallIdx] = nums[brkIdx];
		nums[brkIdx] = temp;
		//reverse the remaining numbers
		reverse(brkIdx+1,n-1,nums);
	}
}
