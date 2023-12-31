package com.a2zdsa.heaps.learning;

public class MaxHeap {
	
	private int[] arr;
	private int topIdx;
	private int capacity;
	
	MaxHeap(int size){
		capacity = size; 
		arr = new int[capacity];
		topIdx = -1;
	}
	
	public int heapSize() {
		return topIdx+1;
	}
	
	private void swap(int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	private void buildHeap() {
		int nonLeaf = (heapSize()/2)-1;
		for( int i = nonLeaf; i>= 0; i--) {
			maxHeapify(i);
		}
	}
	
	private void maxHeapify(int i) {
		int leftIdx = 2*i + 1;
		int rightIdx = 2*i + 2;
		int largestIdx = i;
		
		if( leftIdx < heapSize() && arr[largestIdx] < arr[leftIdx])  largestIdx = leftIdx;
		if( rightIdx < heapSize() && arr[largestIdx] < arr[rightIdx]) largestIdx = rightIdx;
		
		if( largestIdx != i) {
		
			swap(largestIdx,i);
			maxHeapify(largestIdx);
		}
	}
	
	public int poll() {
		if( heapSize() == 0 ) {
			return -1;
		}
		int topEl = arr[0];
		swap(0,topIdx);
		topIdx--;
		buildHeap();
		return topEl;
	}
	
	public void add(int val) {
		if( heapSize() == capacity )	return;
		
		arr[topIdx] = val;
		topIdx++;
		buildHeap();
		
	}
	public void deleteAt(int idx) {
		if( heapSize() == 0 )	return;
		if( idx > topIdx ) 	return;
		
		if( idx == topIdx ) {
			topIdx--;
			return;
		}
		
		swap(idx, topIdx);
		topIdx--;
		buildHeap();
	}

}
