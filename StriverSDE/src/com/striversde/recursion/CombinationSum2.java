package com.striversde.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum2 {
	public void getAllCombination(int idx, int[] candidates, int target, List<Integer> ds, List<List<Integer>> result){
		if ( target == 0 ){
			result.add(new ArrayList<>(ds));
			return;
		}

		for(int i = idx ; i<candidates.length; i++){

			if ( i > idx && candidates[i] == candidates[i-1] ) continue;

			if ( candidates[i] <= target ){
				ds.add( candidates[i] );
				getAllCombination(i+1,candidates,target - candidates[i],ds,result);
				ds.remove(ds.size() - 1 );
			}
		}
	}

	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		Arrays.sort(candidates);
		List<List<Integer>> result = new ArrayList<>();
		List<Integer> ds = new ArrayList<>();
		getAllCombination(0,candidates,target,ds,result);
		return result;
	}
}
