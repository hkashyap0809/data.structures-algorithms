package com.datastructures.graph;

import java.util.ArrayList;

public class TopologicalSortDFS {
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
	
	public static void topologicalSort(int src,ArrayList<ArrayList<Integer>> adjList, ArrayList<Integer> result,boolean[] visited) {
		visited[src] = true;
		
		for(Integer neighbour : adjList.get(src)) {
			if(!visited[neighbour]) topologicalSort(neighbour, adjList, result, visited);
		}
		result.add(src);
		
	}
	public static ArrayList<Integer> topologicalSort(ArrayList<ArrayList<Integer>> edges, int v, int e) {
		
		boolean[] visited = new boolean[v];
		ArrayList<Integer> result = new ArrayList<>();
		ArrayList<ArrayList<Integer>> adjList = adjacencyList(edges, v);
		for(int i=0;i<visited.length;i++) {
			if (!visited[i]) {
				topologicalSort(i,adjList,result,visited);
			}
		}
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i = result.size() -1 ; i>=0; i--)
            ans.add(result.get(i));
		return ans;
	}
}
