package com.striversde.arrays4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class FourSum {
	//Brute
	public List<List<Integer>> fourSumBrute(int[] nums, int target) {
		HashSet<ArrayList<Integer>> set = new HashSet<>();
		int n = nums.length;
		for(int i=0;i<n; i++) {
			for(int j=i+1; j<n; j++) {
				for(int k=j+1; k<n; k++) {
					for(int l = k+1; l<n;l++) {
						long sum = 0;
						sum+=nums[i];
						sum+=nums[j];
						sum+=nums[k];
						sum+=nums[l];
						if ( sum == target ) {
							ArrayList<Integer> ds = new ArrayList<>();
							ds.add(nums[i]);
							ds.add(nums[j]);
							ds.add(nums[k]);
							ds.add(nums[l]);
							Collections.sort(ds);
							set.add(ds);
						}
					}
				}
			}
		}
		List<List<Integer>> result = new ArrayList<>();
		for( ArrayList<Integer> list : set ) {
			result.add(list);
		}
		return result;
		
	}
	//Better
	public List<List<Integer>> fourSumBetter(int[] nums, int target) {
		HashSet<ArrayList<Integer>> resultSet = new HashSet<>();
		int n = nums.length;
		for(int i = 0; i<n; i++ ) {
			
			for(int j=i+1; j<n;j++) {
				HashSet<Long> numSet = new HashSet<>();
				for(int k = j+1; k<n; k++) {
					long sum = 0;
					sum+= nums[i];
					sum+= nums[j];
					sum+= nums[k];
					long diff = target - sum;
					if ( numSet.contains(diff) ) {
						ArrayList<Integer> ds = new ArrayList<>();
						ds.add(nums[i]);
						ds.add(nums[j]);
						ds.add(nums[k]);
						ds.add((int)(diff));
						Collections.sort(ds);
						resultSet.add(ds);
					}
					numSet.add((long)nums[k]);
				}
			}
		}
		List<List<Integer>> answer = new ArrayList<>();
		for(ArrayList<Integer> list : resultSet ) {
			answer.add(list);
		}
		return answer;
	}
	public List<List<Integer>> fourSum(int[] nums, int target) {
		Arrays.sort(nums);
		int n = nums.length;
		List<List<Integer>> result = new ArrayList<>();
		for(int i=0;i<n;i++) {
			if ( i>0 && nums[i]==nums[i-1])	continue;
			for( int j = i+1; j<n; j++) {
				if ( j>i+1 && nums[j] == nums[j-1] )continue;
				int k = j+1;
				int l = n-1;
				while( k < l ) {
					long sum = 0;
					sum+= nums[i];
					sum+= nums[j];
					sum+= nums[k];
					sum+= nums[l];
					if ( sum == target ) {
						ArrayList<Integer> ds = new ArrayList<>();
						ds.add(nums[i]);
						ds.add(nums[j]);
						ds.add(nums[k]);
						ds.add(nums[l]);
						result.add(ds);
						
						k++;
						l--;
						while( k < n && nums[k]==nums[k-1]) k++;
						while( l >= 0 && nums[l]==nums[l+1]) l--;
					
					}else if ( sum < target) {
						k++;
					}else {
						l--;
					}
				}
				
			}
		}
		return result;
	}

}
