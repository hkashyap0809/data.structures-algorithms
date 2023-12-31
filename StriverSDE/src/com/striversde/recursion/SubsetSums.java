package com.striversde.recursion;

import java.util.ArrayList;
import java.util.Collections;

public class SubsetSums {
	public ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int N){
        ArrayList<Integer> result = new ArrayList<>();
        getAllSubsetSum(0,arr,0,result);
        Collections.sort(result);
        return result;
    }

	private void getAllSubsetSum(int idx, ArrayList<Integer> arr, int sum, ArrayList<Integer> result) {
		if ( idx == arr.size() ) {
			result.add(sum);
			return;
		}
		
		//take
		getAllSubsetSum(idx+1, arr, sum+arr.get(idx), result);
		//not take
		getAllSubsetSum(idx+1, arr, sum, result);
		
	}

}
