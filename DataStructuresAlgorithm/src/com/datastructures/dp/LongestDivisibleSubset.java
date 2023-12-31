package com.datastructures.dp;

import java.util.ArrayList;
import java.util.Arrays;

public class LongestDivisibleSubset {
	public static ArrayList<Integer> divisibleSet(int arr[]) {

		Arrays.sort(arr);		
		int[] maxLength = new int[arr.length];
		Arrays.fill(maxLength,1);

		int[] parentMap = new int[arr.length];
		for(int i=0;i<arr.length;i++)
			parentMap[i] = i;
		

		int maxLen = 1;
		int maxLenIdx = 0;
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<i;j++) {
				if ( arr[i] % arr[j] == 0 && maxLength[i] < 1 + maxLength[j]) {
					maxLength[i] = 1 + maxLength[j];
					parentMap[i] = j;
				}
			}
			if( maxLen < maxLength[i]) {
				maxLen = maxLength[i];
				maxLenIdx = i;
			}
		}
		ArrayList<Integer> result = new ArrayList<>();
		result.add(0,arr[maxLenIdx]);

		while( parentMap[maxLenIdx] != maxLenIdx) {
			
			int parIdx = parentMap[maxLenIdx];
			result.add(0,arr[parIdx]);
			maxLenIdx = parentMap[maxLenIdx];
		}
		return result;
	}
	public static void main(String[] args) {
		int[] arr = {1,16,7,8,4};
		divisibleSet(arr);
	}
}
