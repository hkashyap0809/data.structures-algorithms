package com.datastructures.trie;

import java.util.Arrays;

public class TrieNode {
	TrieNode[] children;
	boolean isEnd;
	int countWord;
	int countStartsWith=0;
	TrieNode(){
		children = new TrieNode[26];
		Arrays.fill(children, null);
		countWord = 0;
		countStartsWith = 0;
		isEnd = false;
	}
}

