package com.a2zdsa.strings.medium;

public class LongestPalindromicSubstring {
	public String longestPalindrome(String s) {
		int n = s.length();
		int start = 1;
		int maxVal = -1;

		for( int i = 0; i<n; i++){
			int left = i;
			int right = i;
			while( left >=0 && right < n && s.charAt(left) == s.charAt(right)){
				left--;
				right++;
			}

			if( maxVal < right - left - 1){
				start = left+1;
				maxVal = right - left - 1;
			}
		}

		for( int i =0 ; i <n; i++){
			int left = i;
			int right = i+1;

			while( left >=0 && right <n && s.charAt(left) == s.charAt(right)){
				left--;
				right++;
			}

			if( maxVal < right - left - 1){
				start = left+1;
				maxVal = right - left - 1;
			}
		}

		return s.substring(start, start + maxVal);
	}

}
