package com.datastructures.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class NoOfProvincesBFS {
	static int numProvinces(ArrayList<ArrayList<Integer>> adj, int V) {
		boolean[] visited = new boolean[V];
		Arrays.fill(visited, false);
		adj = giveAdjacencyList(adj, V);
		int provinces = 0;
		for(int i=0;i<V;i++) {
			if(!visited[i]) {
				provinces++;
				startBFS(i,adj,visited);
			}
		}
		return provinces;
	}
	public static ArrayList<ArrayList<Integer>> giveAdjacencyList(ArrayList<ArrayList<Integer>> adj, int V){
		ArrayList<ArrayList<Integer>> adjacencyList = new ArrayList<>() ;
		for(int i=0;i<V;i++) {
			adjacencyList.add(new ArrayList<Integer>());
		}
		for(int i=0;i<V;i++) {
			for(int j = 0; j<V; j++) {
				if(adj.get(i).get(j)==1) {
					adjacencyList.get(i).add(j);
					adjacencyList.get(j).add(i);
				}
			}
		}
		return adjacencyList;
	}

	public static void startBFS(int src, ArrayList<ArrayList<Integer>> adj, boolean[] visited) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(src);
		visited[src]=true;
		while(!queue.isEmpty()) {
			int node = queue.poll();
			for(var adjNode : adj.get(node)) {
				if(!visited[adjNode]) {
					queue.add(adjNode);
					visited[adjNode] = true;
				}
			}
		}
	}
}
