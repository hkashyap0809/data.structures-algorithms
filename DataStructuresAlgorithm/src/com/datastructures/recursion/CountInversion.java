package com.datastructures.recursion;

//https://www.interviewbit.com/blog/count-inversions-of-an-array/
//https://practice.geeksforgeeks.org/problems/inversion-of-array-1587115620/1?utm_source=gfg&utm_medium=article&utm_campaign=bottom_sticky_on_article
public class CountInversion {
	public static void print(int[] arr) {
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}
	public static void main(String[]args) {
		int[] arr = {3,5,1,10,9,2,6,8};
		int inv = countInversion(arr);
		System.out.println("inversion "+inv);
	}

	public static int countInversion(int[] arr) {
		return countInversion(arr,0,arr.length-1);
	}
	public static int countInversion(int[] arr, int start, int end) {
		if(start<end) {
			int mid = (start+end)/2;
			int inversion = 0;
			inversion += countInversion(arr,start,mid);
			inversion += countInversion(arr,mid+1,end);
			inversion += inversion(arr,start,mid,end);
			return inversion;
		}else {
			return 0;
		}
	}

	private static int inversion(int[] arr, int start, int mid, int end) {
		
		int[] sortedArr = new int[end-start+1];
		int inversion = 0;
		
		int i = start;
		int j = mid+1;
		int k = 0;
		
		while(i<=mid && j<=end) {
			if(arr[i]>arr[j]) {
				sortedArr[k++]=arr[j++];
				inversion += (mid-i+1);
			}else if(arr[i]<=arr[j]) {
				sortedArr[k++]=arr[i++];
			}
		}
		
		while(i<=mid)
			sortedArr[k++]=arr[i++];
		
		while(j<=end)
			sortedArr[k++]=arr[j++];
		
		for(int x=0;x<k;x++) {
			arr[start+x]=sortedArr[x];
		}
		
		System.out.println(start+" "+mid+" "+end);
		print(arr);
		System.out.println("inversion "+inversion);
		
		return inversion;
	}

}
