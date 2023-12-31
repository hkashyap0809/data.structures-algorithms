package com.datastructures.graph;

import java.util.ArrayList;
import java.util.Arrays;

public class StringlyConnectedComponents {

public static int kosaraju(int V, ArrayList<ArrayList<Integer>> adj){
		
		ArrayList<Integer> finishingDFS = new ArrayList<>();
		boolean[] visited = new boolean[V];
		Arrays.fill(visited, false);
		for(int i=0;i<V;i++) {
			if(!visited[i])
			startDFS(i,adj,finishingDFS,visited);
		}
		
		ArrayList<ArrayList<Integer>> revAdj = reverseAdjacencyList(adj);
		
		Arrays.fill(visited, false);

		ArrayList<ArrayList<Integer>> SCC = new ArrayList<>();
		int scc = 0;
		for(int i=finishingDFS.size()-1; i>=0; i--) {
			if( !visited[finishingDFS.get(i)]) {
				scc++;
				ArrayList<Integer> list = new ArrayList<>();
				startDFS(finishingDFS.get(i),revAdj,list,visited);
				SCC.add(list);
			}

		}
		return scc;

	}

	private static void startDFS(int src, ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> finishingDFS,
			boolean[] visited) {
		visited[src] = true;
		for( Integer neighbour : adj.get(src)) {
			if( !visited[neighbour] ) {
				startDFS(neighbour,adj,finishingDFS,visited);
			}
		}

		finishingDFS.add(src);
	}

	private static ArrayList<ArrayList<Integer>> reverseAdjacencyList(ArrayList<ArrayList<Integer>> adj){
		ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();

		for(int i=0;i<adj.size();i++) {
			adjList.add(new ArrayList<>());
		}
		
		for(int i=0;i<adj.size();i++) {

			for(int j = 0; j < adj.get(i).size(); j++ ) {
				int u = i;
				int v = adj.get(i).get(j);
				adjList.get(v).add(u);
			}
		}
		return adjList;
	}
}
