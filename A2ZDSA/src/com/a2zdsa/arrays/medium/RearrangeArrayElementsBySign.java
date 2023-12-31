package com.a2zdsa.arrays.medium;

public class RearrangeArrayElementsBySign {
	public int[] rearrangeArray(int[] nums) {
		int len = nums.length;
		int[] pos = new int[len/2];
		int[] neg = new int[len/2];

		int p = 0;
		int n = 0;
		for(int i=0;i<len;i++){
			if(nums[i] >= 0 )
				pos[p++] = nums[i];
			else
				neg[n++] = nums[i];
		}
		p=0;
		n=0;
		boolean turn = true;
		for( int i =0; i<len; i++){
			if( turn ){
				nums[i] = pos[p++];
				turn = false;
			}else{
				nums[i] = neg[n++];
				turn = true;
			}
		}
		return nums;
	}

}
