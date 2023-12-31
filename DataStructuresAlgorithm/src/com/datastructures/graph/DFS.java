package com.datastructures.graph;

import java.util.ArrayList;

public class DFS {
	
	public void startDFS(int src,ArrayList<ArrayList<Integer>> adj, boolean[] visited, ArrayList<Integer> dfs) {
		
		visited[src] = true;
		dfs.add(src);
		for(var adjNode : adj.get(src)) {
			if(!visited[adjNode]) {
				startDFS(adjNode,adj,visited,dfs);
			}
		}
		
	}
	public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[V];
        ArrayList<Integer> dfs = new ArrayList<>();
        startDFS(0,adj,visited,dfs);
        return dfs;
    }

}
