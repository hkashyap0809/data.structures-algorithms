package com.a2zdsa.arrays.easy;

import java.util.ArrayList;

public class RotateArrayD {

	public void rotateNaive(int[] nums, int k) {
		int len = nums.length;
		int[] arr = new int[len];
		for( int i = 0; i<len; i++ ){
			int newIdx = (i + k)%len;
			arr[newIdx] = nums[i];
		}
		for(int i=0;i<len;i++){
			nums[i] = arr[i];
		}
	}

	//Rotate right
	public void reverseArray(int[] arr, int start, int end){
		while( start < end ){

			int temp = arr[start];
			arr[start] = arr[end];
			arr[end] = temp;

			start++;
			end--;
		}
	}

	public void rotate(int[] nums, int k) {
		int len = nums.length;
		k = k % len;
		k = len - k;
		reverseArray(nums,0,k-1);
		reverseArray(nums,k,len-1);
		reverseArray(nums,0,len-1);
	}

	//Rotate Left
	public static void reverseArray(ArrayList<Integer> arr, int start, int end){
		while( start < end ){

			int temp = arr.get(start);
			arr.set(start,arr.get(end));
			arr.set(end,temp);

			start++;
			end--;
		}
	}
	public static ArrayList<Integer> rotateArray(ArrayList<Integer> arr, int k) {
		int len = arr.size();
		k = k % len;
		reverseArray(arr,0,k-1);
		reverseArray(arr,k,len-1);
		reverseArray(arr,0,len-1);
		return arr;
	}

}
