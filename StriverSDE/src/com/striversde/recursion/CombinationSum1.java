package com.striversde.recursion;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum1 {
	public void findCombination(int idx, int candidates[], int target, ArrayList<Integer> ds, List<List<Integer>> result) {
		if(idx == candidates.length){
			if(target == 0){
				result.add(new ArrayList<>(ds));
				return;
			}else return;
		}
		if(candidates[idx] <= target ) {
			ds.add(candidates[idx]);
			findCombination(idx, candidates, target - candidates[idx], ds, result);
			ds.remove(ds.size()-1);
		}
		findCombination(idx+1, candidates, target, ds, result);
	}
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		ArrayList<Integer> ds = new ArrayList<>(); 
		List<List<Integer>> result = new ArrayList<>();
		findCombination(0, candidates, target, ds, result);
		return result;
	}
}
