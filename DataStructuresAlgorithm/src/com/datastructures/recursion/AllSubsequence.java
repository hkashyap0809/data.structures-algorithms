package com.datastructures.recursion;

import java.util.ArrayList;

public class AllSubsequence {
	public static void allSubsequences(int idx, int[] nums, ArrayList<Integer> ds,ArrayList<ArrayList<Integer>> result) {
		if(idx == nums.length) {
			result.add(new ArrayList<>(ds));
			return;
		}
		
		ds.add(nums[idx]);
		allSubsequences(idx+1, nums, ds, result);
		ds.remove(ds.size()-1);
		allSubsequences(idx+1, nums, ds, result);
	}
	
	public static ArrayList<ArrayList<Integer>> getAllSubsequences(int[] nums){
		ArrayList<ArrayList<Integer>> result = new ArrayList<>();
		ArrayList<Integer> ds = new ArrayList<>();
		allSubsequences(0,nums,ds,result);
		return result;
	}
	public static void main(String[] args) {
		int[] nums = {1,2,3};
		ArrayList<ArrayList<Integer>> subsequences = getAllSubsequences(nums);
		
		for(var subsequence : subsequences) {
			System.out.println(subsequence.toString());
		}
	}

}
