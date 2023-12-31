package com.striversde.recursionbacktracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutaionString {

	//Extra Space Technique
	public 	static void giveAllPermutaion1(int[] nums,List<Integer> ds,List<List<Integer>> result,boolean[] map) {

		if(ds.size() == nums.length) {
			result.add(new ArrayList<>(ds));
			return;
		}
		for(int i=0;i<nums.length;i++) {
			if(map[i]==false) {
				ds.add(nums[i]);
				map[i]=true;
				giveAllPermutaion1(nums, ds, result, map);
				map[i]=false;
				ds.remove(ds.size()-1);
			}
		}

	}

	public static List<List<Integer>> allPermutaion1(int[] nums){
		List<List<Integer>> result = new ArrayList<>();
		List<Integer> ds = new ArrayList<>();
		boolean[] map = new boolean[nums.length];
		Arrays.fill(map, false);
		giveAllPermutaion1(nums, ds,result,map);
		return result;

	}
	
	//Swapping Technique
	public static void swap(int i, int j, int[] nums) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
	public static void allPermutaionSwap(int idx, int[] nums, List<List<Integer>> result) {


		if ( idx == nums.length ) {
			List<Integer> ds = new ArrayList<>();
			for ( int num : nums ) {
				ds.add(num);
			}
			result.add(new ArrayList<>(ds));
		}

		for(int i = idx; i<nums.length; i++) {
			swap(i,idx,nums);
			allPermutaionSwap(idx+1,nums,result);
			swap(i,idx,nums);
		}
	}
	public static List<List<Integer>> allPermutaionSwap(int[] nums){
		List<List<Integer>> result = new ArrayList<>();
		allPermutaionSwap(0,nums,result);
		return result;

	}
	public static void main(String[] args) {
		int[] num = {1,2,3};

		List<List<Integer>> allPerm = allPermutaion1(num);
		;
		for(int i=0;i<allPerm.size();i++) {
			System.out.println(allPerm.get(i).toString());
		}
	}
}
