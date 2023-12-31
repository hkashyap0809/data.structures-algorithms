package com.striversde.linkedlistandarrays;

public class TrappingRainWater {

	//Brute
	public int trapBrute(int[] height) {
		int ans = 0;
		for( int i =0; i<height.length;i++) {
			int leftMax = height[i];
			for( int j = i; j>=0; j--) 
				leftMax = Math.max(leftMax, height[j]);


			int rightMax = height[i];
			for(int j=i;j<height.length;j++)
				rightMax = Math.max(rightMax, height[j]);

			ans = ans + Math.min(leftMax, rightMax) - height[i];
		}
		return ans;
	}

	//Better
	public int trapBetter(int[] height) {
		int n = height.length;

		int[] leftMax = new int[n];
		int[] rightMax = new int[n];

		leftMax[0] = height[0];
		rightMax[n-1] = height[n-1];

		for( int i = 1; i < n;i++) 
			leftMax[i] = Math.max(leftMax[i-1], height[i]);

		for( int i = n-2; i >= 0;i--) 
			rightMax[i] = Math.max(rightMax[i+1], height[i]);

		int ans = 0;
		for( int i=0; i<n; i++) {
			ans = ans + Math.min(leftMax[i], rightMax[i]) - height[i];
		}
		return ans;
	}

	//Optimal
	public int trap(int[] height) {
		int n = height.length;
		int left = 0;
		int right = n-1;
		int leftMax = 0;
		int rightMax = 0;
		int ans = 0;

		while( left <= right ) {
			if ( height[left] <= height[right] ) {
				//left one is minimum
				if ( height[left]>=leftMax) {
					leftMax = height[left];
				}else {
					ans = ans + (leftMax - height[left]);
				}
				left++;
			}else {
				//right one is minimum
				if ( height[right]>=rightMax) {
					rightMax = height[right];
				}else {
					ans = ans + (rightMax - height[right]);
				}
				right--;
			}
		}
		return ans;
	}

}
