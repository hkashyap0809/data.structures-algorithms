package com.datastructures.graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class WordLadder2 {
	
	
	public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList){
		
	}
	public List<List<String>> findLaddersBrute(String beginWord, String endWord, List<String> wordList) {

		Queue<ArrayList<String>> queue = new LinkedList<ArrayList<String>>();
		HashSet<String> hashSet = new HashSet<>();
		for(String word : wordList) hashSet.add(word);

		queue.add(new ArrayList<String>(List.of(beginWord)));
		List<List<String>> result = new ArrayList<>();

		while( !queue.isEmpty() ) {
			int queueSize = queue.size();
			ArrayList<String> lastWords = new ArrayList<>();

			for(int q=1;q<=queueSize;q++) {
				ArrayList<String> topSequence = queue.poll();
				String lastWord = topSequence.get(topSequence.size()-1);
				char[] wordArr = lastWord.toCharArray();

				if( lastWord.equals(endWord)) {
					result.add(new ArrayList<>(topSequence));
					continue;
				}

				for(int i=0;i<wordArr.length;i++) {
					char origCh = wordArr[i];
					for(char ch = 'a'; ch<='z'; ch++) {
						wordArr[i] = ch;
						if( hashSet.contains(new String(wordArr)) && !lastWord.equals(new String(wordArr))) {

							ArrayList<String> newSeq = new ArrayList<>(topSequence);
							newSeq.add(new String(wordArr));
							lastWords.add(new String(wordArr));
							queue.add(newSeq);
						}
					}
					wordArr[i] = origCh;
				}
			}
			for( String lastWord : lastWords) {
				if(hashSet.contains(lastWord)) {
					hashSet.remove(lastWord);
				}
			}
		}
		return result;

	}
}


