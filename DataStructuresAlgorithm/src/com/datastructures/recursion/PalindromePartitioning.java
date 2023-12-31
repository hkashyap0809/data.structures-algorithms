package com.datastructures.recursion;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
	
	
	public static List<List<String>> partition(String s) {
		List<List<String>> result = new ArrayList<>();
		List<String> ds = new ArrayList<>();
		getAllPartition(s,0,ds, result);
		return result;
	}
	

	public static void getAllPartition(String s, int idx,List<String> ds,List<List<String>> result) {
		
		if(idx == s.length()) {
			result.add(new ArrayList<>(ds));
			return;
		}
		
		for(int i=idx; i<s.length();i++) {
			String s1 = s.substring(idx,i+1);			
			if(isPalindrome(s1)) {
				ds.add(s1);
				getAllPartition(s, i+1, ds, result);
				ds.remove(ds.size()-1);	
			}
		}
	}


	private static boolean isPalindrome(String s1) {
		int len = s1.length();
		if(len == 1 ) return true;
		
		int i=0;
		int j=len-1;
		
		while(i<=j) {
			if(s1.charAt(i)!=s1.charAt(j))	return false;
			i++;
			j--;
		}
		return true;
	}
	
	public static void main(String[] args) {
		List<List<String>> result = partition("aabb");
		for(int i=0;i<result.size();i++) {
			System.out.println(result.get(i).toString());
		}
	}
}
