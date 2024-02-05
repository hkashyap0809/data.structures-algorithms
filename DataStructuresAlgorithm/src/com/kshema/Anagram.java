package com.kshema;

import java.util.HashMap;

public class Anagram {
	
	public static void main(String[] args) {
		String str1 = "poiuytrewq";
		String str2 = "qwertyuiop";
		
		boolean result = isAnagram(str1, str2);
		if( result )
			System.out.println(str1 +" and "+str2+" are anagram. ");
		else
			System.out.println(str1 +" and "+str2+" are not anagram. ");
		
	}

	private static boolean isAnagram(String str1, String str2) {
		HashMap<Character, Long> hashMap = new HashMap<>();
		
		int len1 = str1.length();
		int len2 = str2.length();
		
		if( len1 != len2 )return false;
		
		for( int i =0; i<len1; i++) {
			char ch = str1.charAt(i);
			hashMap.put(ch, hashMap.getOrDefault(ch, 0L)+1);
		}
		
		for( int i =0; i<len2; i++) {
			char ch = str2.charAt(i);
			hashMap.put(ch, hashMap.getOrDefault(ch, 0L)-1);
			if( hashMap.get(ch) == 0 )hashMap.remove(ch);
		}
		
		return hashMap.size() == 0;
	}

}
