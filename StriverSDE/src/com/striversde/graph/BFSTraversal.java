package com.striversde.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.*;

public class BFSTraversal {
	private static ArrayList<ArrayList<Integer>> getAdjacencyList(int v, int[][] edges) {
		ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
		for(int i=0 ;i<v;i++) {
			adjList.add(new ArrayList<Integer>());
		}

		for(int i=0;i<edges.length;i++) {
			int a = edges[i][0];
			int b = edges[i][1];

			adjList.get(a).add(b);
			adjList.get(b).add(a);
		}
		for(int i=0; i<adjList.size(); i++) {
			Collections.sort(adjList.get(i));
		}
		return adjList;
	}
	public static ArrayList<Integer> BFS(int vertex, int edges[][]){
		boolean[] visited = new boolean[vertex];
		Arrays.fill(visited,false);
		System.out.println(edges[0].length);
		ArrayList<ArrayList<Integer>> adjList = getAdjacencyList(vertex, edges);	

		ArrayList<Integer> bfsList = new ArrayList<>();
		for(int i=0 ;i<vertex; i++) {
			if ( !visited[i] )
				startBFS(i,adjList,bfsList,visited);
		}
		return bfsList;
	}
	private static void startBFS(int src, ArrayList<ArrayList<Integer>> adjList, ArrayList<Integer> bfsList,
			boolean[] visited) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(src);
		visited[src] = true;
		bfsList.add(src);

		while( !queue.isEmpty()) {
			int node = queue.poll();

			for( int neighbour : adjList.get(node) ) {
				if ( !visited[neighbour] ) {
					visited[neighbour] =true;
					bfsList.add(neighbour);
					queue.add(neighbour);
				}
			}
		}
	}
}
