package com.datastructures.test;

import java.util.Arrays;
import java.util.Collections;
import java.util.TreeMap;

//You are given an array A consisting of N integers (N is divisible by 3) and an integer K. 
//In one move, you can increase or decrease any element of A by 1. The task is to modify array A using such moves in 
//order to maximize the difference between the (N/3) th largest element and the (N/3) th smallest element of the
//resulting array. You can perform at most K moves.
//For example, array A = 19, 12, 15, 5, 7, 13| consists of N = 6 elements, so the
//(N/3)th (that is, the 2nd) largest element is 13 and the (N/3)th (2nd) smallest
//element is 7.
//Write a function:
//int solution(int All, int N, int K);
//that, given an array A and an integer K, returns the maximum possible difference between the (N/3)th largest 
//element and the (N/3)th smallest element of A after
//performing at most K moves, as described above.
//Example:
//1. Given A = [8, 8, 8, 7, 7, 7, 7, 7, 7, 7, -8, -8] and K = 1, the function should return
// N = 12
//1. 
//We can increase one 7 once. The resulting array is [8, 8, 8, 8, 7, 7, 7, 7, 7, 7, -8,-8].

//The 4th biggest number is 8 and the 4th smallest is 7.
//2. Given A = [-5, 1, 1, 4, 4, 4, 7, 4, 6] and K = 6, the function should return 7. We can
//increase one 4 three times, increase the 6 once and decrease both 1s once. The resulting array is [-5, 0, 0, 4, 4, 7, 7, 4, 7]. 
//The 3rd biggest number is 7 and the 3rd
//smallest is 0.

//3. Given A = [-7, -6, -3, -2, -2, -2, -2, -2, -2, -2, -2, - 1] and K = 5, the function
//should return 3. We can decrease one -2 three times and decrease the -3 twice.
//The resulting array is [-7, -6, -5, -5, -2, -2, -2, -2, -2, -2, -2, -1]. The 4th biggest number is -2 and the 4th smallest is -5.

public class MicrosoftMinPossibleDiff {

	static int solution(int[] A, int N, int K ) {
		Arrays.sort(A);
		
		TreeMap<Integer,Integer> minHeap = new TreeMap<Integer,Integer>();
		TreeMap<Integer,Integer> maxHeap = new TreeMap<Integer,Integer>(Collections.reverseOrder());
		
		int p = N/3;
		
		for( int i = 0 ; i < p ; i++ ) {
			maxHeap.put(A[i], maxHeap.getOrDefault(A[i], 0)+1);
		}
		
		for( int i = N-1 ; i>= N-p ; i-- ) {
			minHeap.put(A[i], minHeap.getOrDefault(A[i], 0)+1);
		}
		System.out.println(minHeap.toString());
		System.out.println(maxHeap.toString());
		
		int maxDiff = minHeap.firstKey() - maxHeap.firstKey();
		
		while( K > 0 ) {
			int leftVal = maxHeap.firstKey();
			int leftFreq = maxHeap.get(leftVal);
			maxHeap.remove(leftVal);
			
			
			int rightVal = minHeap.firstKey();
			int rightFreq = minHeap.get(rightVal);
			minHeap.remove(rightVal);
			
			
			
			if( rightFreq < leftFreq ) {
				
			}else if( rightFreq > leftFreq ) {
				
			}else {
				
			}
		}
		return maxDiff;
	}
	
	public static void main(String[]args) {
		int[] A = {-5, 1, 1, 4, 4, 4, 7, 4, 6};
		System.out.println(solution(A,9,7));
	}
}
