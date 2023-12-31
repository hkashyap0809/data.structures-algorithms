package com.striversde.graph;

import java.util.ArrayList;
import java.util.Arrays;

public class DFSTraversal {
public static void startDFS(int src, ArrayList<ArrayList<Integer>> adjList, ArrayList<Integer> dfsList, boolean[] visited) {
		
		visited[src] = true;
		
		for(Integer adjNode : adjList.get(src)) {
			if( !visited[adjNode] ) {
				dfsList.add(adjNode);
				startDFS(adjNode,adjList,dfsList,visited);
			}
		}
		
		
	}
	public static ArrayList<Integer> getDFSList(int src, ArrayList<ArrayList<Integer>> adjList, boolean[] visited ){
		ArrayList<Integer> dfsList = new ArrayList<>();
		dfsList.add(src);
		startDFS(src,adjList,dfsList,visited);
		return dfsList;
	}
	public static ArrayList<ArrayList<Integer>> depthFirstSearch(int v, int e, ArrayList<ArrayList<Integer>> edges) {
		ArrayList<ArrayList<Integer>> dfsList = new ArrayList<>();
		ArrayList<ArrayList<Integer>> adjList = getAdjacencyList(v,edges);
		boolean[] visited = new boolean[v];
		Arrays.fill(visited, false);
		
		for(int i=0;i<v;i++) {
			if( !visited[i] ) {
				dfsList.add( getDFSList(i,adjList,visited) );
			}
		}
		
		return dfsList;
		
	}
	private static ArrayList<ArrayList<Integer>> getAdjacencyList(int v, ArrayList<ArrayList<Integer>> edges) {
		ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
		for(int i=0 ;i<v;i++) {
			adjList.add(new ArrayList<Integer>());
		}
		
		for(int i=0;i<edges.size();i++) {
			int a = edges.get(i).get(0);
			int b = edges.get(i).get(1);
			
			adjList.get(a).add(b);
			adjList.get(b).add(a);
		}
		return adjList;
	}
}
