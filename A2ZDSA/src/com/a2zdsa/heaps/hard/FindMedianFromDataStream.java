package com.a2zdsa.heaps.hard;

import java.util.PriorityQueue;

public class FindMedianFromDataStream {
	private PriorityQueue<Integer> minHeap;
	private PriorityQueue<Integer> maxHeap;
	public FindMedianFromDataStream() {
		minHeap = new PriorityQueue<Integer>((a,b)->a-b);
		maxHeap = new PriorityQueue<Integer>((a,b)->b-a);
	}

	public void addNum(int num) {
		maxHeap.add(num);

		if(!minHeap.isEmpty() && !maxHeap.isEmpty() && maxHeap.peek() > minHeap.peek() ) minHeap.add(maxHeap.poll());

		if( maxHeap.size() > minHeap.size() + 1)    minHeap.add(maxHeap.poll());
		if( minHeap.size() > maxHeap.size() + 1)    maxHeap.add(minHeap.poll());

	}

	public double findMedian() {
		if(minHeap.size() > maxHeap.size()) return (double)minHeap.peek();
		if(minHeap.size() < maxHeap.size()) return (double)maxHeap.peek();
		return (minHeap.peek() + maxHeap.peek())/2.0;
	}




}





