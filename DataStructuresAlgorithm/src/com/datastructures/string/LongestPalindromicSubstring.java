package com.datastructures.string;

public class LongestPalindromicSubstring {
	public String longestPalindrome(String s) {
		int len = s.length();
		int start = 0;
		int maxVal = Integer.MIN_VALUE;
		for(int i=0; i<len; i++){
			int left = i ;
			int right = i;

			while( left >=0 && right<len && s.charAt(left) == s.charAt(right)){
				left--;
				right++;
			}

			if( maxVal < right - left + 1 ){
				start = left + 1;
				maxVal = right - left + 1;
			}
		}

		for(int i=0; i<len; i++){
			int left = i;
			int right = i+1;
			while(left >=0 && right<len && s.charAt(left) == s.charAt(right)){
				left--;
				right++;
			}
			if( maxVal < right - left + 1 ){
				start = left + 1;
				maxVal = right - left + 1;
			}
		}
		return s.substring(start,maxVal+start-2);
	}
	

}
