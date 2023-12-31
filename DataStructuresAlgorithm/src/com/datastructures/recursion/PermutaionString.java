package com.datastructures.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutaionString {
	
	//Using map
	static void giveAllPermutaionMap(int[] nums,List<Integer> ds,List<List<Integer>> result,boolean[] map) {
		
		if(ds.size() == nums.length) {
			result.add(new ArrayList<>(ds));
			return;
		}
		for(int i=0;i<nums.length;i++) {
			if(map[i]==false) {
				ds.add(nums[i]);
				map[i]=true;
				giveAllPermutaionMap(nums, ds, result, map);
				map[i]=false;
				ds.remove(ds.size()-1);
			}
		}
		
	}
	
	static List<List<Integer>> giveAllPermutaionMap(int[] nums){
		List<List<Integer>> result = new ArrayList<>();
		List<Integer> ds = new ArrayList<>();
		boolean[] map = new boolean[nums.length];
		Arrays.fill(map, false);
		giveAllPermutaionMap(nums, ds,result,map);
		return result;
		
	}
	//Swap
	static void giveAllPermutaionSwap(int index,int[] nums,List<List<Integer>> result) {
		
		if(index == nums.length) {
			ArrayList<Integer> ds = new ArrayList<Integer>();
			for(int i=0;i<nums.length;i++) {
				ds.add(nums[i]);
			}
			result.add(new ArrayList<>(ds));
			return;
		}
		
		for (int i=index; i<nums.length;i++) {
			int temp = nums[i];
			nums[i] = nums[index];
			nums[index]=temp;
			
			giveAllPermutaionSwap(index+1, nums, result);
			
			int temp2 = nums[i];
			nums[i] = nums[index];
			nums[index]=temp2;
		}
	}
	
	static List<List<Integer>> allPermutaionSwap(int[] nums){
		List<List<Integer>> result = new ArrayList<>();
		giveAllPermutaionSwap(0,nums, result);
		return result;
	}
	
	public static void main(String[] args) {
		int[] num = {1,2,3};
		
		List<List<Integer>> allPerm = allPermutaionSwap(num);
		;
		for(int i=0;i<allPerm.size();i++) {
			System.out.println(allPerm.get(i).toString());
		}
	}

}
