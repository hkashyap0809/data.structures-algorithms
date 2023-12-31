package com.datastructures.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//90. Subsets II 
//https://leetcode.com/problems/subsets-ii/description/
public class SubsetSum2 {
	
	public static List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        
        getAllSubsets(0,nums,list,result);
        return result;
    }
	static void getAllSubsets(int index, int[] nums,List<Integer> list,List<List<Integer>> result) {
		
		result.add(new ArrayList<>(list));
		for(int i= index; i<nums.length;i++) {
			
			if(i>index && nums[i]==nums[i-1]) {
				continue;
			}
			list.add(nums[i]);
			getAllSubsets(i+1, nums, list, result);
			list.remove(list.size()-1);
		}	
	}
	public static void main(String[] args) {
		int num[] = {1,2,2};
		System.out.println(subsetsWithDup(num).toString());
		System.out.println(subsetsWithDup(num).size());
		
	}

}
