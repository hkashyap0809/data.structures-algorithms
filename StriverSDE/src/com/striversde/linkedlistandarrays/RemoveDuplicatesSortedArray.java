package com.striversde.linkedlistandarrays;

public class RemoveDuplicatesSortedArray {
	public int removeDuplicates(int[] nums) {
		int i = 0;
		int j = 0;
		int len = nums.length;

		while ( j < len ){
			if( nums[i] != nums[j]){
				i = i + 1;
				nums[i] = nums[j];
			}
			j++;
		}
		return i+1;
	}

}
