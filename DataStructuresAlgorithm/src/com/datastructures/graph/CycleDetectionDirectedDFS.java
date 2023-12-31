package com.datastructures.graph;

import java.util.ArrayList;

public class CycleDetectionDirectedDFS {
	
	public static ArrayList<ArrayList<Integer>> adjacencyList(ArrayList<ArrayList<Integer>> edges, int n){
		ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
		for(int i=0;i<n;i++) {
			adjList.add(new ArrayList<Integer>());
		}
		
		for(int i=0;i<edges.size();i++) {
			int u = edges.get(i).get(0);
			int v = edges.get(i).get(1);
			
			adjList.get(u).add(v);
		}
		
		return adjList;
	}
	
	public static boolean detectCycleInDirectedGraph(int n, ArrayList<ArrayList<Integer>> edges) {
		boolean[] visited = new boolean[n+1];
		boolean[] pathVisited = new boolean[n+1];
		ArrayList<ArrayList<Integer>> adjList = adjacencyList(edges, n);
		for(int i=1; i<=n; i++) {
			boolean result = detectCycleDirectedDFS(i,adjList,visited,pathVisited);
			if ( result )	return true;
		}
		return false;
	}

	public static boolean detectCycleDirectedDFS(int src, ArrayList<ArrayList<Integer>> adjList, boolean[] visited,
			boolean[] pathVisited) {
		visited[src] = true;
		pathVisited[src] = true;
		
		for( Integer neighbour : adjList.get(src)) {
			if ( visited[neighbour] && !pathVisited[neighbour] )	return false;
			else if(visited[neighbour] && pathVisited[neighbour]) 
				return true;
		}
		pathVisited[src] = false;
		return false;
	}
}

