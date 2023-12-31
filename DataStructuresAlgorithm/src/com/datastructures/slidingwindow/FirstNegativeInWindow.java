package com.datastructures.slidingwindow;

import java.util.LinkedList;
import java.util.Queue;

public class FirstNegativeInWindow {
	public static int[] firstNegative(int[] arr, int n, int k) {
		Queue<Integer> queue = new LinkedList<>();
		int i = 0;
		int j = 0;
		int q = 0;
		int[] ans = new int[n-k+1];

		while( j < arr.length ){
			if ( arr[j] < 0 )	queue.add(arr[j]);

			if ( j-i+1 < k ) {
				j++;
			}else if ( j-i+1 == k ){
				if ( queue.isEmpty() ){
					ans[q++]=0;
				}else{
					ans[q++]=queue.peek();
					if ( arr[i] == queue.peek() ){
						queue.poll();
					}
				}
				i++;
				j++;
			}
		}

		return ans;
	}


}
