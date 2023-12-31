package com.datastructures.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

//https://practice.geeksforgeeks.org/problems/shortest-path-in-undirected-graph/1
class DAGPair{
	int node;
	int weight;
	DAGPair(int node, int weight){
		this.node = node;
		this.weight = weight;
	}
	@Override
	public String toString() {
		return "["+Integer.toString(node)+","+Integer.toString(weight)+"]";
	}
}
public class ShortestPathInDAG {
	public static int[] shortestPath(int vertices,int edges, int[][] edgeList) {
		int[] dist = new int[vertices];
		Arrays.fill(dist, 10000000);

		//create adjacency list

		ArrayList<ArrayList<DAGPair>> adjList = new ArrayList<>();
		for(int i=0;i<vertices;i++)	adjList.add( new ArrayList<DAGPair>());

		for(int[] edge : edgeList) {
			int u = edge[0];
			int v = edge[1];
			int wt = edge[2];
			adjList.get(u).add(new DAGPair(v, wt));

		}

		//do topological sort
		boolean[] visited = new boolean[vertices];
		Stack<Integer> topologicalOrder = new Stack<Integer>();

		for(int i=0;i<vertices;i++) {
			if( !visited[i] ) {
				doTopologicalSort(i,visited,adjList,topologicalOrder);
			}
		}

		int src = 0;
		dist[src] = 0;
		while( !topologicalOrder.empty() ) {
			int node = topologicalOrder.pop();

			for(DAGPair neighbour : adjList.get(node) ) {

				if( dist[node] + neighbour.weight < dist[neighbour.node] ) {
					dist[neighbour.node] = dist[node]+ neighbour.weight;
				}
			}
		}

		for( int i=0;i<dist.length;i++) {
			if(dist[i] == 10000000) {
				dist[i]=-1;
			}
		}

		return dist;
	}

	private static void doTopologicalSort(int src, boolean[] visited, ArrayList<ArrayList<DAGPair>> adjList,
			Stack<Integer> topologicalOrder) {
		visited[src]=true;

		for(DAGPair neighbour : adjList.get(src)) {
			if( !visited[neighbour.node] ) {
				doTopologicalSort(neighbour.node, visited, adjList, topologicalOrder);
			}
		}
		topologicalOrder.push(src);

	}

	public static void main(String[] args) {
		int[][] edges = {{0,1,2},{0,4,1},{4,5,4},{4,2,2},{1,2,3},{2,3,6},{5,3,1}};

		int[] arr = shortestPath(6, 7, edges);

		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println();

	}

}
