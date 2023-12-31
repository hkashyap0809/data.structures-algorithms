package com.striversde.linkedlistandarrays;

public class MaxConsecutiveOnes {
	public int findMaxConsecutiveOnes(int[] nums) {
		int left = 0;
		int right = 0;
		int len = nums.length ;
		int maxOnes = 0;
		while( right < len ){
			if ( nums[right] == 0 ) {
				left = right + 1;
			}
			maxOnes = Math.max( right - left + 1, maxOnes);
			right++;
		}
		return maxOnes;
	}

}
