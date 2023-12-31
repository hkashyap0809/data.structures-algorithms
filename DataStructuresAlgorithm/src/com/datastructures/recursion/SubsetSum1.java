package com.datastructures.recursion;

import java.util.ArrayList;
import java.util.Collections;


//https://www.geeksforgeeks.org/print-sums-subsets-given-set/
public class SubsetSum1 {
	static void giveAllSubsetSum(ArrayList<Integer> arr, int n, int index, int sum,ArrayList<Integer> result){

		if(index == n) {
			result.add(sum);
			return;
		}
		//take the element
		giveAllSubsetSum(arr, n, index+1, sum+arr.get(index),result);
		//not take the element
		giveAllSubsetSum(arr, n, index+1, sum,result);

	}

	static ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int N){
		ArrayList<Integer> result = new ArrayList<Integer>();
		giveAllSubsetSum(arr, N, 0, 0,result);
		Collections.sort(result);	
		return result;
	}


	public static void main(String[]args) {
		ArrayList<Integer> arr = new ArrayList<Integer>();

		arr.add(2);
		arr.add(3);

		System.out.println(subsetSums(arr,2).toString());

	}
}
