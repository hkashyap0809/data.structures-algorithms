package com.datastructures.test;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

//There is a line chart consisting of N points (numbered from 0 to N-1) connected
//by line segments. The K-th point has coordinates x = K, y = Y[K]. There are no
//horizontal lines; that is, no two consecutive points has the same y-coordinate.
//We can draw an infinitely long horizontal line. What is the maximum number of points of intersection of the line with the chart?
//Write a function:
//int solution(vector<int> &Y);
//that, given array Y, returns the maximum number of common points between the
//horizontal line and our line chart if we draw the line optimally.
//Examples:
//1. Given Y = [1, 2, 1, 2, 1, 3, 2], the function should return 5. A horizontal line at y =
//1.5 intersects the chart at points (0.5, 1.5), (1.5, 1.5), (2.5, 1.5), (3.5, 1.5) and
//(4.25,1.5)


public class MicrosoftHorizontalLine {
	
	static int solution(int[] Y) {
		
		TreeMap<Integer,Integer> hashMap = new TreeMap<>();
		
		int n = Y.length;
		for( int i = 0; i < n-1; i++ ) {
			int small = Math.min(Y[i], Y[i+1]);
			int big = Math.max(Y[i], Y[i+1]);
			
			hashMap.put( small, hashMap.getOrDefault(small, 0)+1);
			hashMap.put( big, hashMap.getOrDefault(big, 0)-1);
		}
		System.out.println(hashMap.toString());
		
		int maxVal = 0;
		int currVal = 0;
		
		for( Map.Entry<Integer, Integer> entry : hashMap.entrySet()) {
			int val = entry.getValue();
			currVal = currVal + val;
			maxVal = Math.max(maxVal, currVal);
		}
		return maxVal;
	}
	
	public static void main(String[] args ) {
//		int[] arr = {1, 2, 1, 2, 1, 3, 2};
		int[] arr = {2,1, 2, 1, 2, 3, 2,3, 2};
		System.out.println(solution(arr));
	}

}
