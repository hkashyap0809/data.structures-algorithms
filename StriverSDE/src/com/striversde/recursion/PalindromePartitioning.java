package com.striversde.recursion;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
	public static boolean isPalindrome(String str){
		if ( str.length() == 1) return true;
		int i=0;
		int j=str.length()-1;
		while(i<=j){
			if(str.charAt(i)!=str.charAt(j))    return false;
			i++;
			j--;
		}
		return true;
	}
	public void getAllPalindromePartition(int idx, String str, ArrayList<String> ds, List<List<String>> result){

		if ( idx == str.length() ){
			result.add(new ArrayList<>(ds));
			return;
		}
		for(int i = idx; i < str.length(); i++ ){
			String str1 = str.substring(idx,i+1);
			if ( isPalindrome(str1) ){
				ds.add(str1);
				getAllPalindromePartition(i+1,str,ds,result);
				ds.remove(ds.size()-1);
			}
		}
	}
	public List<List<String>> partition(String s) {
		List<List<String>> result = new ArrayList<>();
		ArrayList<String> ds = new ArrayList<>();
		getAllPalindromePartition(0,s,ds,result);
		return result;
	}
}
