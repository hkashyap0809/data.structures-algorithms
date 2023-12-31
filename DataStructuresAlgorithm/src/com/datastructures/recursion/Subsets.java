package com.datastructures.recursion;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
	
	
	public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        
        giveAllSubsets(nums, 0, list,result);
        return result;
        
    }
	public static void giveAllSubsets(int[] nums,int index,List<Integer> list,List<List<Integer>> result) {
		if(index ==nums.length) {
			result.add(new ArrayList<>(list));
			return;
		}
		
//		take
		list.add(nums[index]);
		giveAllSubsets(nums, index+1, list, result);
		list.remove(list.size()-1);
		giveAllSubsets(nums, index+1, list, result);
		
	}
	public static void main(String[] args) {
		int num[] = {1,2,3};
		System.out.println(subsets(num));
	}

}
