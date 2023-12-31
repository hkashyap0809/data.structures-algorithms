package com.striversde.arrays4;

import java.util.HashMap;
import java.util.HashSet;

public class LongSubstrWithoutRepeatChar {
	//Brute
	public static int lengthOfLongestSubstringBrute(String s) {
		if ( s.length() <= 1 )  return s.length();

		int len = s.length();
		int maxLen = 1;
		for(int i=0; i<len;i++){
			for(int j=i; j<len;j++){
				String str = s.substring(i,j+1);
				if ( isNonRepeating(str) ) {
					maxLen = Math.max(maxLen, j-i+1);
				}
			}
		}
		return maxLen;

	}

	private static boolean isNonRepeating(String str) {
		HashSet<Character> hashSet = new HashSet<>();
		for( int i=0;i<str.length(); i++) {
			char ch = str.charAt(i);
			if ( hashSet.contains(ch) )	return false;
			hashSet.add(ch);
		}
		return true;
	}
	
	//Better - Sliding Window
	public static int lengthOfLongestSubstringBetter(String s) {
		int left = 0;
		int right = 0;
		int maxLen = 0;
		int len = s.length();
		HashSet<Character> hashSet = new HashSet<>();
		
		while( right < len ) {
			char ch = s.charAt(right);
			
			while( hashSet.contains(ch) ) {
				hashSet.remove(s.charAt(left));
				left++;
			}
			
			hashSet.add(ch);
			maxLen = Math.max( maxLen, right - left + 1);
			right++;
		}
		
		return maxLen;
				
		
	}
	//Optimal - Sliding Window
	public static int lengthOfLongestSubstring(String s) {
		int maxLen = 0;
		int left = 0;
		int right = 0;
		int len = s.length();
		HashMap<Character,Integer> hashMap = new HashMap<>();
		
		while( right < len) {
			char ch = s.charAt(right);
			
			
			if ( hashMap.containsKey(ch) && hashMap.get(ch)>=left && hashMap.get(ch)<=right) {
				left = hashMap.get(ch) + 1;
				
			}
			hashMap.put(ch, right);
			maxLen = Math.max(maxLen,  right - left + 1);
			right++;
		}
		
		
		return maxLen;
	}
	

	public static void main(String[] args) {
		System.out.println(lengthOfLongestSubstring("abcaabcdba"));
	}

}
