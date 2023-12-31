package com.datastructures.heap;

public class HeapSort {
	
	void buildHeap(int arr[], int n){
		//build max Heap
		for( int  i = n/2 -1  ; i>=0; i--){
			heapify(arr,n,i);
		}
	}

	private void swap(int i, int j, int[] arr){
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}


	void heapify(int arr[], int n,int i) {
		//max heap property
		int leftIdx = 2*i + 1;
		int rightIdx = 2*i + 2;

		int largestIdx = i;

		if ( leftIdx < n && arr[leftIdx] > arr[largestIdx] ){
			largestIdx = leftIdx;
		}

		if ( rightIdx < n && arr[rightIdx] > arr[largestIdx] ){
			largestIdx = rightIdx;
		}

		if ( largestIdx != i ){
			swap(largestIdx,i,arr);
			heapify(arr,n,largestIdx);
		}
	}

	public void heapSort(int arr[], int n){
		buildHeap(arr,n);
		for(int i = n-1; i>=1; i-- ){
			swap(0,i,arr);
			heapify(arr,i,0);
		}
	}

}
