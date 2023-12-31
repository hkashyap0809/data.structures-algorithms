package com.a2zdsa.arrays.easy;

public class RotateLeftOne {
	public static int[] rotateArray(int[] arr, int n) {
		int len = arr.length;
		for(int i = 0; i<len-1; i++ ){
			int newIdx = (i - 1 + len )%len;
			int temp = arr[i];
			arr[i] = arr[newIdx];
			arr[newIdx] = temp;
		}
		return arr;

	}

}
