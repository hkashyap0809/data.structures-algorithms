package com.striversde.dp1;

public class MaxProductSubarray {

	//	O(n)
	public int maxProduct(int[] nums) {
		int prefix = 1;
		int suffix = 1;
		int result = Integer.MIN_VALUE;

		for(int i=0;i<nums.length;i++) {
			if(prefix == 0)	prefix = 1;
			if(suffix == 0)	suffix = 1;

			prefix = prefix * nums[i];
			suffix = suffix * nums[nums.length-i-1];

			result = Math.max(result, Math.max(prefix, suffix));
		}
		return result;
	}


	//	O(n^2)
	public int maxProduct2(int[] nums) {

		int result = Integer.MIN_VALUE;
		for(int i=0;i<nums.length;i++) {
			int product = 1;
			for(int j=i;j<nums.length;j++) {
				product = product * nums[j];
				result = Math.max(product, result);
			}
		}
		return result;
	}
	//	O(n^3)
	public int maxProduct3(int[] nums) {

		int result = Integer.MIN_VALUE;
		for(int i=0;i<nums.length;i++) {
			for(int j=i;j<nums.length;j++) {
				int product = 1;
				for(int k=i;k<=j;k++) {
					product = product * nums[k];
				}
				result = Math.max(product, result);
			}
		}
		return result;
	}


}
