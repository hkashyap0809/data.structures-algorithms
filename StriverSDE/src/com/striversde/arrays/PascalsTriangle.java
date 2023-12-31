package com.striversde.arrays;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {
	public List<List<Integer>> generate(int numRows) {
		List<List<Integer>> result = new ArrayList<>();        
		result.add(List.of(1));
		if ( numRows == 1)  return result;
		result.add(List.of(1,1));
		if ( numRows == 2)  return result;
		for(int i = 2; i<numRows; i++){
			ArrayList<Integer> list = new ArrayList<>();
			list.add(1);
			for(int j = 1; j<=i+1-2; j++){
				list.add( result.get(i-1).get(j-1) + result.get(i-1).get(j) );
			}   
			list.add(1);
			result.add(list);
		}
		return result;
	}

}
