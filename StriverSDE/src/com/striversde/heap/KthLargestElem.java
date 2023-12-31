package com.striversde.heap;

import java.util.PriorityQueue;

public class KthLargestElem {
	public int findKthLargest(int[] nums, int k) {
		PriorityQueue<Integer> pq= new PriorityQueue<>((a,b)->b-a);
		for( int num : nums ){
			pq.add(num);
		}
		for(int i=1;i<=k-1;i++){
			pq.poll();
		}
		return pq.peek();
	}

}
