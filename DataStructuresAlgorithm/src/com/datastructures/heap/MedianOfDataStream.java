package com.datastructures.heap;

import java.util.PriorityQueue;

public class MedianOfDataStream {

	PriorityQueue<Integer> minHeap;
	PriorityQueue<Integer> maxHeap;
	public MedianOfDataStream() {
		maxHeap = new PriorityQueue<>((a,b)->b-a);
		minHeap = new PriorityQueue<>((a,b)->a-b);
	}

	public void addNum(int num) {
		maxHeap.add(num);

		if(!maxHeap.isEmpty() && !minHeap.isEmpty() && maxHeap.peek() >= minHeap.peek()){
			minHeap.add(maxHeap.poll());
		}

		if ( maxHeap.size() > minHeap.size() + 1 ){
			minHeap.add(maxHeap.poll());
		}

		if ( minHeap.size() > maxHeap.size() + 1 ){
			maxHeap.add(minHeap.poll());
		}

	}

	public double findMedian() {
		if ( maxHeap.size() == minHeap.size() )
			return (maxHeap.peek() + minHeap.peek()) / 2.0;    
		else if ( maxHeap.size() > minHeap.size() )  
			return maxHeap.peek();
		else
			return minHeap.peek();

	}
}

