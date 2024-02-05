package com.datastructures.stack;

import java.util.Stack;

public class LargestRectangleAreaHistogram {
	
	//Brute Force
	public static int largestRectangleAreaBrute(int[] heights) {
		return 0;
	}
	
	
	// 2 - pass solution
	private static int[] nextSmallerIndex(int[] height) {
		int[] right = new int[height.length];
		
		Stack<Integer> stack = new Stack<>();
		for ( int i=height.length-1; i>=0; i-- ){
			while( !stack.isEmpty() && height[ stack.peek() ] >= height[i] ) {
				stack.pop();
			}
			
			if ( stack.isEmpty() ) {
				right[i] = height.length - 1;
			}else {
				right[i] = stack.peek() - 1;
			}
			stack.push(i);
		}		
		return right;
	}
	
	private static int[] prevSmallerIndex(int[] height) {
		int[] left = new int[height.length];
		Stack<Integer> stack = new Stack<>();
		
		for(int i = 0; i<height.length;i++) {
			while ( !stack.isEmpty() &&  height[ stack.peek() ] >= height[i] ) {
				stack.pop();
			}
			
			if ( stack.isEmpty() ) {
				left[i] = 0;
			}else{
				left[i] = stack.peek() + 1;
			}
			stack.push(i);
		}
		return left;
	}
	public static int largestRectangleArea(int[] heights) {
		
		
		int[] left = prevSmallerIndex(heights);
		int[] right = nextSmallerIndex(heights);
		
		int maxArea = Integer.MIN_VALUE;
		for(int i=0; i<heights.length;i++) {
			int area = ( right[i] - left[i] + 1 ) * heights[i];
			maxArea = Math.max(maxArea, area);
		}
		
		return maxArea;
	}
	
	
	
	//Best - Single Pass solution
	
	public static void main(String[] args) {
		int[] arr = {2,1,5,6,2,3,1};
//		largestRectangleArea(arr);
		System.out.println(largestRectangleArea(arr));
	}
}
