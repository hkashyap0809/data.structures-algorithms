package com.striversde.arrays4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class ThreeSum {
	//Brute
	public List<List<Integer>> threeSumBrute(int[] nums) {

		HashSet<ArrayList<Integer>> set = new HashSet<>();
		for(int i=0;i<nums.length;i++) {
			for(int j= i+1; j<nums.length;j++) {
				for(int k=j+1;k<nums.length;k++) {
					int sum = nums[i]+nums[j]+nums[k];
					if ( sum == 0 ) {
						ArrayList<Integer> ds = new ArrayList<>();
						ds.add(nums[i]);
						ds.add(nums[j]);
						ds.add(nums[k]);
						Collections.sort(ds);
						set.add(ds);
					}
				}
			}
		}
		List<List<Integer>> result = new ArrayList<>();
		for( ArrayList<Integer> list : set) {
			result.add(list);
		}
		return result;
	}
	
	//Better
	public List<List<Integer>> threeSumBetter(int[] nums) {
		HashSet<ArrayList<Integer>> answer = new HashSet<>();
		for(int i=0;i<nums.length;i++) {
			HashSet<Integer> set = new HashSet<>();
			for(int j=i+1;j<nums.length;j++) {
				int target = 0 - nums[i] - nums[j];
				if ( set.contains(target)) {
					ArrayList<Integer> ds = new ArrayList<>();
					ds.add(nums[i]);
					ds.add(nums[j]);
					ds.add(target);
					Collections.sort(ds);;
					answer.add(ds);
				}
				set.add(nums[j]);
			}
		}
		List<List<Integer>> result = new ArrayList<>();
		for( ArrayList<Integer> list : answer) {
			result.add(new ArrayList<>(list));
		}
		return result;
	}
	//Optimal
	public List<List<Integer>> threeSum(int[] nums) {
		Arrays.sort(nums);
		List<List<Integer>> result = new ArrayList<>();
		for(int i=0;i<nums.length;i++) {
			if ( i>0 && nums[i] == nums[i-1]) continue;
			int j = i+1;
			int k = nums.length-1;
			while( j < k ) {
				int sum = nums[i] + nums[j] + nums[k];
				if ( sum == 0 ) {
					ArrayList<Integer> ds = new ArrayList<>();
					ds.add(nums[i]);
					ds.add(nums[j]);
					ds.add(nums[k]);
					result.add(ds);
					j++;
					k--;
					while( j < nums.length && nums[j] == nums[j-1] ) 	j++;
					while( k >= 0 && nums[k] == nums[k+1] )	k--;

				}else if ( sum < 0 ) {
					j++;
				}else if ( sum > 0 ) {
					k--;
				}
			}

		}
		return result;
	}

}
