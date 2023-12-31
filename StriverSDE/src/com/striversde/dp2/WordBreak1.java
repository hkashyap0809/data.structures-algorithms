package com.striversde.dp2;

import java.util.ArrayList;
import java.util.List;

public class WordBreak1 {
	//Memoization
	public List<String> wordBreak(String s, List<String> wordDict) {
		List<String> result = new ArrayList<>();
		getAllWords(0,s,wordDict,"",result);
		return result;
	}

	public static void getAllWords(int idx, String s, List<String> hashSet, String sent, List<String> result){
		if ( idx == s.length() ){
			result.add(sent.trim());
			return;
		}

		for(int i = idx; i<s.length(); i++){
			String str = s.substring(idx,i+1);
			if( hashSet.contains(str) ){
				getAllWords(i+1,s,hashSet,sent+str+" ",result);
			}
		}
	}

}
