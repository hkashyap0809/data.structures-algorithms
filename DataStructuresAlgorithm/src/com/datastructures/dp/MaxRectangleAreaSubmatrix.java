package com.datastructures.dp;

import java.util.Stack;

public class MaxRectangleAreaSubmatrix {
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
	public static int largestRectangle(int[] heights) {
		
		
		int[] left = prevSmallerIndex(heights);
		int[] right = nextSmallerIndex(heights);
		
		int maxArea = Integer.MIN_VALUE;
		for(int i=0; i<heights.length;i++) {
			int area = ( right[i] - left[i] + 1 ) * heights[i];
			maxArea = Math.max(maxArea, area);
		}
		
		return maxArea;
	}
	public static int maximalAreaOfSubMatrixOfAll1(int[][] mat, int n, int m) {
		int row = mat.length;
		int col = mat[0].length;
		
		int maxArea = largestRectangle(mat[0]);
		for ( int i=1; i<row; i++) {
			for( int j = 0; j<col; j++) {
				
				if( mat[i][j] != 0 ) {
					mat[i][j] = mat[i][j] + mat[i-1][j];
				}
			}
			
			maxArea = Math.max(maxArea, largestRectangle(mat[i]));
		}
		return maxArea;
	}
}
