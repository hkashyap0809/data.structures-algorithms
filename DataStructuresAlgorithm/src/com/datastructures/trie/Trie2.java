package com.datastructures.trie;

public class Trie2 {
	private TrieNode root;
	public Trie2() {
		root = new TrieNode();
	}

	public void insert(String word) {
		TrieNode tempRoot = root;
		int len = word.length();
		for(int i=0;i<len;i++) {
			char ch = word.charAt(i);
			if( tempRoot.children[ ch - 'a'] == null ) {
				tempRoot.children[ch-'a'] = new TrieNode();
				
			}
			tempRoot = tempRoot.children[ ch - 'a'];
			tempRoot.children[ch-'a'].countStartsWith++;
		}
		tempRoot.isEnd = true;
		tempRoot.countWord++;
	}

	public int countWordsEqualTo(String word) {
		TrieNode tempRoot = root;
		int len = word.length();
		for(int i=0;i<len;i++) {
			char ch = word.charAt(i);
			if( tempRoot.children[ ch - 'a'] == null ) {
				return 0;
			}else {
				tempRoot = tempRoot.children[ ch - 'a'];
			}
		}
		if(tempRoot.isEnd)	return tempRoot.countWord;
		return 0;
	}

	public int countWordsStartingWith(String word) {
		 TrieNode tempRoot = root;
		int len = word.length();
		for(int i=0;i<len;i++) {
			char ch = word.charAt(i);
			if( tempRoot.children[ ch - 'a'] == null ) {
				return 0;
			}else {
				tempRoot = tempRoot.children[ ch - 'a'];
			}
		}
		if(tempRoot != null)	return tempRoot.countStartsWith;
		return 0;
	}

	public void erase(String word) {
		TrieNode tempRoot = root;
		int len = word.length();
		int count = countWordsStartingWith(word);
		for(int i=0; i<len; i++) {
			char ch = word.charAt(i);
			
			if( tempRoot.children[ ch - 'a'] !=null) {
				tempRoot.children[ ch - 'a'].countStartsWith-=count;
			}
			tempRoot = tempRoot.children[ ch-'a'];
		}
		if( tempRoot != null ) {
			tempRoot.countWord = 0;
		}
		
	}
}
