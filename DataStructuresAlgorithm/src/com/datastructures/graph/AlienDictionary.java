package com.datastructures.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class AlienDictionary {
	public void createEdge(String word1, String word2, ArrayList<ArrayList<Integer>> graph,int[] inDegree) {
		int len1 = word1.length();
		int len2 = word2.length();
	
		for ( int i =0; i< Math.min(len1, len2); i++){
			char ch1 = word1.charAt(i);
			char ch2 = word2.charAt(i);
			
			if( ch1 != ch2 ) {
				int u = ch1 - 'a';
				int v = ch2 - 'a';
				graph.get(u).add(v);
				inDegree[v]++;
				return;
			}
		}
		
	}
	public String findOrder(String [] dict, int N, int K){
		
		int n = dict.length;
		
		ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
		for(int i=0;i<K;i++) {
			graph.add(new ArrayList<>());
		}
		
		int[] inDegree = new int[K];
		Queue<Integer> queue = new LinkedList<Integer>();
		
		Arrays.fill(inDegree, 0);
		
		for(int i = 0 ; i < n-1; i++ ) {
			String word1 = dict[i];
			String word2 = dict[i+1];
			
			createEdge(word1,word2,graph,inDegree);
		}
		
		for(int i = 0; i< inDegree.length;i++) {
			if( inDegree[i] == 0 ) queue.add(i);
		}

		String order ="";
		while( !queue.isEmpty() ) {
			int node = queue.poll();
			order = order + (char)(97+node);
			
			for( int neighbour : graph.get(node)) {
				inDegree[neighbour]--;
				if( inDegree[neighbour] == 0 ) {
					queue.add( neighbour );
				}
			}
		}
		return order;

	}

}
