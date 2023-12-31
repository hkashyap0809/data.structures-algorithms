package com.datastructures.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class CycleDetectionBFS {
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
	public static boolean detectCycle(int src, ArrayList<ArrayList<Integer>> adjList, int edge, int vertices,boolean[] visited) {

		Queue<Pair> queue = new LinkedList<>();
		queue.add(new Pair(src,-1));
		visited[src]=true;

		while(!queue.isEmpty()) {
			Pair topEl = queue.poll();
			int parentNode = topEl.second;
			int node = topEl.first;

			ArrayList<Integer> neighbours = adjList.get(node);
			for( Integer neighbourNode : neighbours) {
				
				if ( parentNode!=neighbourNode ){
					if(visited[neighbourNode])	return true;
					else{
						queue.add(new Pair(neighbourNode,node));
						visited[neighbourNode] = true;
					}
				}
			}
		}

		return false;

	}
	public static String cycleDetection(int[][] edges, int n, int m) {
		ArrayList<ArrayList<Integer>> adjList = getAdjacencyList(edges,m,n);
		boolean[] visited = new boolean[n+1];
		for(int i=1; i<=n; i++){
			if(!visited[i]){
				boolean result = detectCycle(i,adjList,m,n,visited);
				if( result )	return "Yes"; 
			}
		}
		return "No";
	}

}
