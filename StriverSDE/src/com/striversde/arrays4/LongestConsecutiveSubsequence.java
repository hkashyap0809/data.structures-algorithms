package com.striversde.arrays4;

import java.util.Arrays;
import java.util.HashSet;

public class LongestConsecutiveSubsequence {

	public boolean linearSearch(int x, int[] nums) {
		for( int num : nums) {
			if ( x==num)	return true;
		}
		return false;
	}
	public int longestConsecutiveBrute(int[] nums) {
		if ( nums.length == 0 ) return 0;
		int longest = 1;

		for(int num : nums ) {
			int x = num + 1;
			int currCount = 1;
			while(linearSearch(x,nums)==true) {
				x = x+1;
				currCount++;
			}
			longest = Math.max(longest, currCount);
		}
		return longest;
	}

	//Sorting
	public int longestConsecutiveBetter(int[] nums) {
		if( nums.length == 0 )	return 0;
		Arrays.sort(nums);
		int longest = 1;
		int count = 0;
		int lastSmallest = Integer.MIN_VALUE;

		for( int num : nums ) {
			if ( num == lastSmallest + 1) {
				lastSmallest = num;
				count++;
			}else if( num != lastSmallest) {
				lastSmallest = num;
				count = 1;
			}
			longest = Math.max(longest, count);
		}
		return longest;
	}
	//Using set
	public int longestConsecutive(int[] nums) {
		if ( nums.length == 0 )	return 0;
		HashSet<Integer> hashSet = new HashSet<>();
		int longest = 1;
		for(int num : nums ) {
			hashSet.add(num);
		}
		for( int num : nums) {
			if ( !hashSet.contains(num-1) ) {
				int x = num;
				int count = 0;
				while( hashSet.contains(x)) {
					x = x + 1;
					count++;
				}
				longest = Math.max(longest, count);
			}
		}
		return longest;
	}

}
