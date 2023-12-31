package com.datastructures.trie;

public class Trie {
	private TrieNode root;

	public Trie() {
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
		}
		tempRoot.isEnd = true;

	}

	public boolean search(String word) {
		TrieNode tempRoot = root;
		int len = word.length();
		for(int i=0;i<len;i++) {
			char ch = word.charAt(i);
			if( tempRoot.children[ ch - 'a'] == null ) {
				return false;
			}else {
				tempRoot = tempRoot.children[ ch - 'a'];
			}
		}
		return tempRoot.isEnd;

	}

	public boolean startsWith(String prefix) {
		TrieNode tempRoot = root;
		int len = prefix.length();
		for(int i=0;i<len;i++) {
			char ch = prefix.charAt(i);
			if( tempRoot.children[ ch - 'a'] == null ) {
				return false;
			}else {
				tempRoot = tempRoot.children[ ch - 'a'];
			}
		}
		return tempRoot != null;
	}

}
