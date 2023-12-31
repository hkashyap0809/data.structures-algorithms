package com.datastructures.sorting;

public class MergeSort {

	
	public static void print(int[] arr) {
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}
	public static void main(String[] args) {
		int[] arr = {3,6,1,8,0,11,2,5};
		print(arr);
		mergeSort(arr,0,arr.length-1);
		print(arr);
		
		
	}

	public static void mergeSort(int[] arr, int start, int end) {
		if(start<end) {
			int mid = (start+end)/2;
			mergeSort(arr,start,mid);
			mergeSort(arr,mid+1,end);
			merge2(arr,start,mid,end);
		}
		
	}
	
//	Approach 2 - create 2 left,right unsorted array and then update the original array
	public static void merge2(int[] arr, int start, int mid, int end) {
		int[] left = new int[mid-start+1];
		int[] right = new int[end-mid];
		
		for(int i=0;i<left.length;i++) {
			left[i]=arr[start+i];
		}
		for(int j=0;j<right.length;j++) {
			right[j]=arr[mid+1+j];
		}
		
		int i=0,j=0,k=0;
		while(i<left.length && j<right.length) {
			if(left[i]<right[j]) {
				arr[start+k]=left[i];
				i++;
				k++;
			}else if(left[i]>right[j]) {
				arr[start+k]=right[j];
				j++;
				k++;
			}
		}
		while(i<left.length) {
			arr[start+k]=left[i];
			k++;
			i++;
		}
		
		while(j<right.length) {
			arr[start+k]=right[j];
			k++;
			j++;
		}
				
	}

//	Approach 1 - create sorted array and then copy the contents back to the original array
	public static void merge(int[] arr, int start, int mid, int end) {
		
		int[] sortedArr = new int[end-start+1];
		int i=start;
		int j=mid+1;
		int k=0;
		
		
		while(i<=mid && j<=end) {
			if(arr[i]<arr[j]) {
				sortedArr[k] = arr[i];
				i++;
				k++;
			}else if(arr[i]>arr[j]) {
				sortedArr[k] = arr[j];
				k++;
				j++;
			}
		}
		while(i<=mid) 
			sortedArr[k++]=arr[i++];

		while(j<=end)
			sortedArr[k++]=arr[j++];
		
		for(int x=0; x<end-start+1;x++) {
			arr[start+x]=sortedArr[x];
		}
	}
}
