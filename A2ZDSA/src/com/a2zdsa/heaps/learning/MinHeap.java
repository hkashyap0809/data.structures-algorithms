package com.a2zdsa.heaps.learning;

public class MinHeap {
	int[] arr;
    int capacity;
    int topIdx;
    
    MinHeap(int cap) {
        topIdx = -1;
        capacity = cap;
        arr = new int[cap];
    }

    public int heapSize(){
        return topIdx+1;
    }
    
    public void print(){
        System.out.print("HEAP SIZE : "+heapSize()+" HEAP : ");
        for(int i=0; i < heapSize(); i++ ){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

    public void swap(int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
    int extractMin()
    {
        if( heapSize() == 0 )	return -1;
		int minElem = arr[0];
		swap(0,topIdx);
		topIdx--;
		buildHeap();
		return minElem;
    }

    //Function to insert a value in Heap.
    void insertKey(int k) {
        if( heapSize() == capacity ) return;
        topIdx++;
        arr[topIdx] = k;
        buildHeap();
    }

    //Function to delete a key at ith index.
    void deleteKey(int i) {
        if( heapSize() == 0 )    return;
        if( i > topIdx ) return;
        if( i == topIdx ){
            topIdx--;
            return;
        }
        swap(i,topIdx);
        topIdx--;
        buildHeap();
    }
    
    void buildHeap(){
		int nonLeafIndex = (heapSize()/2)-1;
			
		for(int i=nonLeafIndex;i>=0;i--){
			MinHeapify(i);
		}
	}

    void MinHeapify(int i) {
        int leftIdx = 2*i + 1;
        int rightIdx = 2*i + 2;
        int smallestIdx = i;
        
        if( leftIdx < heapSize() && arr[leftIdx] < arr[smallestIdx] ) smallestIdx = leftIdx;
        if( rightIdx < heapSize() && arr[rightIdx] < arr[smallestIdx] ) smallestIdx = rightIdx;
        
        if( smallestIdx != i){
            swap(smallestIdx,i);
            MinHeapify(smallestIdx);
        }
    }}
