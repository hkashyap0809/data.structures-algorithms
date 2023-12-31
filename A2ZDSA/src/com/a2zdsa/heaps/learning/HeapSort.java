package com.a2zdsa.heaps.learning;

public class HeapSort {
	
	public void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	void buildHeap(int arr[], int n){
		int nonLeaf = (n/2)-1;
		for( int i = nonLeaf; i>= 0; i--) {
			heapify(arr,n,i);
		}
	}

	//Heapify function to maintain heap property
	void heapify(int arr[], int n, int i)
	{
		int leftIdx = 2*i + 1;
		int rightIdx = 2*i + 2;
		int largestIdx = i;
		
		if( leftIdx < n && arr[largestIdx] < arr[leftIdx])  largestIdx = leftIdx;
		if( rightIdx < n && arr[largestIdx] < arr[rightIdx]) largestIdx = rightIdx;
		
		if( largestIdx != i) {
		
			swap(arr,largestIdx,i);
			heapify(arr,n,largestIdx);
		}
	}

	//Function to sort an array using Heap Sort.
	public void heapSort(int arr[], int n){
		buildHeap(arr,n);
		for(int i = n-1; i>=1; i--) {
			swap(arr,0,i);
			heapify(arr,i,0);
		}
	}

}
