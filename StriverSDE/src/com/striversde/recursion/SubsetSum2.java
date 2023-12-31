package com.striversde.recursion;

import java.util.ArrayList;
import java.util.List;

public class SubsetSum2 {
	public List<List<Integer>> subsetsWithDup(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		ArrayList<Integer> ds = new ArrayList<>();
		getAllSubsets(0,nums,ds,result);
		return result;
	}

	private void getAllSubsets(int idx, int[] nums, ArrayList<Integer> ds, List<List<Integer>> result) {
		if ( idx == nums.length ) {
			result.add(new ArrayList<>(ds));
		}
		
		for(int i = idx; i < nums.length; i++) {
			
			if ( i > 0 && nums[i] == nums[i-1] )	continue; 
			
				ds.add( nums[i] );
				getAllSubsets(i+1, nums, ds, result);
				ds.remove( ds.size() - 1 );
				
		}
		
		
	}
}
