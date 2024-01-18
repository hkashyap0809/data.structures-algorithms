package com.a2zdsa.graphs.learning;

import java.util.ArrayList;
import java.util.Arrays;

public class DFS {

	private void performDFS(int src, int v, ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> dfsList, boolean[] visited) {
		dfsList.add(src);
		visited[src] = true;

		for( Integer neighbour : adj.get(src) ) {
			if( !visited[neighbour] ) {
				performDFS(neighbour, v, adj, dfsList, visited);
			}
		}
	}

	public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
		ArrayList<Integer> dfsList = new ArrayList<>();
		boolean[] visited = new boolean[V];
		Arrays.fill(visited, false);
		performDFS(0,V,adj,dfsList,visited);
		return dfsList;
	}
}
