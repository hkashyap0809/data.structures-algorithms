package com.a2zdsa.arrays.medium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.stream.Collectors;

//https://leetcode.com/problems/longest-consecutive-sequence/
public class LongestConsecutiveSubsequence {

	//Brute
	public boolean find(int val, int[] nums){
		for( int num : nums ){
			if( val == num )    return true;
		}
		return false;
	}
	public int longestConsecutiveBRUTE(int[] nums) {

		int n = nums.length;
		if( n == 0 )    return 0;
		int longestCount = -1;
		for( int i =0; i< n; i++){
			int val = nums[i]+1;
			int count = 1;
			while(find(val,nums)){
				val = val + 1;
				count++;
			}
			longestCount = Math.max(count,longestCount);
		}
		return longestCount;
	}
	//Better - 
	public int longestConsecutiveBETTER(int[] nums) {
		int n  = nums.length;
		if( n == 0 )    return 0;
		Arrays.sort(nums);
		int lastSmallest = Integer.MIN_VALUE;
		int longestCount = 1;
		int count = 0;

		for( int num : nums ){
			if( num == lastSmallest )   continue;
			if( num != lastSmallest + 1){
				lastSmallest = num ;
				count = 1;
			}else if( num == lastSmallest + 1){
				lastSmallest = num;
				count++;
			}
			longestCount = Math.max(longestCount,count);
		}
		return longestCount;    
	}
	//Using SET
	public int longestConsecutiveSET(int[] nums) {
		if( nums.length == 0 )  return 0;
		HashSet<Integer> hashSet = new HashSet<>(Arrays.stream(nums).boxed().collect(Collectors.toList())); 
		int longestCount = -1;
		for( int num : nums ){
			if( !hashSet.contains(num-1) ){
				int val = num;
				int count = 1;
				while( hashSet.contains(val+1) ){
					val++;
					count++;
				}
				longestCount = Math.max(longestCount,count);
			}
		}
		return longestCount;
	}

}
