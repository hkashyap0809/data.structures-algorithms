package com.datastructures.recursion;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum3 {
	public void getCombination(int idx, int k, int n,int[] nums, List<List<Integer>> result,List<Integer> ds){
		if( idx == nums.length ){
			if( k == 0 && n == 0 ){
				result.add(new ArrayList<>(ds));
			}
			return;
		}
		getCombination(idx+1,k,n,nums,result,ds);

		if( nums[idx] <= n ){
			ds.add( nums[idx] );
			getCombination(idx+1, k-1,n-nums[idx],nums, result,ds);
			ds.remove(ds.size()-1);
		}
	}
	public List<List<Integer>> combinationSum3(int k, int n) {
		List<List<Integer>> result = new ArrayList<>();
		List<Integer> ds = new ArrayList<>();
		int[] nums = {1,2,3,4,5,6,7,8,9};
		getCombination(0,k,n,nums,result,ds);
		return result;
	}

}
