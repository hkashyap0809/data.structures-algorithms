package com.striversde.stackandqueue2;

import java.util.Deque;
import java.util.LinkedList;

public class SlidingWindowMaximum {
	public int[] maxSlidingWindow(int[] nums, int k) {
		int n = nums.length;
		int[] result = new int[n-k+1];
		Deque<Integer> dequeue = new LinkedList<Integer>();

		for(int i=0; i<n; i++) {
			
			//maintain the dequeue in decreasing order
			while(!dequeue.isEmpty() &&  nums[dequeue.peekLast()] < nums[i] ) {
				dequeue.pollLast();
			}

			dequeue.addLast(i);

			//check boundary condition and remove the elements
			while( i-k+1 >=0 && dequeue.peekFirst() < i-k+1 ) {
				dequeue.pollFirst();
			}
				
			//add element to the answer 
			if ( i-k+1 >= 0 ) {
				result[i-k+1] = nums[dequeue.peekFirst()];
			}
		}

		return result;
	}

}
