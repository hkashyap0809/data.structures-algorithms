package com.datastructures.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class CycleDetectionDFS {
	public static ArrayList<ArrayList<Integer>> getAdjacencyList(int[][] edges,int edge,int vertices){
		ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
		for(int i=0;i<=vertices;i++)
			adjList.add(new ArrayList<>());

		for(int i=0;i<edges.length;i++) {
			int u = edges[i][0];
			int v = edges[i][1];

			adjList.get(u).add(v);
			adjList.get(v).add(u);
		}
		return adjList;
	}
	public static boolean detectCycleDFS(int src, int parent, ArrayList<ArrayList<Integer>> adjList, int edge, int vertices,boolean[] visited) {

		visited[src] = true;
		
		for( Integer neighbour : adjList.get(src)) {
			if ( !visited[neighbour] && neighbour != parent) {
				return detectCycleDFS(neighbour, src, adjList, edge, vertices, visited);
			}else if(visited[neighbour] && neighbour != parent) {
				return true;
			}
		}
		return false;

	}
	public static String cycleDetection(int[][] edges, int n, int m) {
		ArrayList<ArrayList<Integer>> adjList = getAdjacencyList(edges,m,n);
		boolean[] visited = new boolean[n+1];
		for(int i=1; i<=n; i++){
			if(!visited[i]){
				boolean result = detectCycleDFS(i,-1,adjList,m,n,visited);
				if( result )	return "Yes"; 
			}
		}
		return "No";
	}

}
