package com.datastructures.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum2 {
	public void getCombinations(int idx, int[] candidates, int target,List<List<Integer>> result,List<Integer> ds) {

		if( target == 0 ){
			result.add(new ArrayList<>(ds));
			return;                
		}

		for( int i = idx; i < candidates.length; i++ ){
			if( i > idx && candidates[i] == candidates[i-1]) continue;

			if( candidates[i] <= target ){
				ds.add(candidates[i]);
				getCombinations(i+1,candidates,target - candidates[i],result,ds);
				ds.remove(ds.size()-1);
			}
		}
	}
	// 1 1 2 5 6 7 10
	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		Arrays.sort(candidates);
		List<List<Integer>> result = new ArrayList<>();
		List<Integer> ds = new ArrayList<>();
		getCombinations(0,candidates,target,result,ds);
		return result;
	}

}
