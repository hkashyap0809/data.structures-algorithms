package com.datastructures.graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


class WordLadderPair{
	String word;
	int distance;
	WordLadderPair(String word, int distance){
		this.word = word;
		this.distance = distance;
	}
}
public class WordLadder1 {
	public int ladderLength(String beginWord, String endWord, List<String> wordList) {

		HashSet<String> hashSet = new HashSet<>();
		for( String word : wordList)	hashSet.add(word);
		
		Queue<WordLadderPair> queue = new LinkedList<WordLadderPair>();
		
		queue.add(new WordLadderPair(beginWord,1));
		
		while( !queue.isEmpty() ) {
			
			WordLadderPair topEl = queue.poll();
			String topWord = topEl.word;
			char[] wordArr = topWord.toCharArray();
			int topDistance = topEl.distance;
			// System.out.println(topWord+" "+topDistance);
			
			if( topWord.equals(endWord))	return topDistance;
			
			for(int i=0;i<wordArr.length;i++) {
				char origCh = wordArr[i];
				for(char ch = 'a'; ch<='z'; ch++) {
					wordArr[i] =ch;
					if( hashSet.contains(new String(wordArr))) {
						queue.add(new WordLadderPair(new String(wordArr), topDistance+1));
						hashSet.remove(new String(wordArr));
					}
				}
				wordArr[i] = origCh;
			}
		}
		return 0;
		
		
	}

}
