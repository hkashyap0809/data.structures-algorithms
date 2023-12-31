package com.a2zdsa.arrays.easy;

public class MaxConsecutiveOnes {
	public int findMaxConsecutiveOnes(int[] nums) {
		int i = 0;
		int j = 0;
		int len = nums.length;
		int maxOnes = 0;

		while( j < len ){

			if( nums[j] == 0 ){
				i=j+1;
			}
			maxOnes = Math.max(maxOnes, j - i + 1);
			j++;
		}
		return maxOnes;
	}

}
