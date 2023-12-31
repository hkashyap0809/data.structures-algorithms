package com.striversde.graph2;

import java.util.ArrayList;
import java.util.PriorityQueue;

class PrimsPair{
	int weight;
	int node;
	PrimsPair(int weight, int node){
		this.weight = weight;
		this.node = node;
	}
}

class PrimsTuple{
	int weight;
	int node;
	int parent;
	PrimsTuple(int weight, int node, int parent){
		this.weight = weight;
		this.node = node;
		this.parent = parent;
	}
}
public class PrimsAlgorithm {

	public static ArrayList<ArrayList<PrimsPair>> getAdjacencyList(int V, int[][] edges) {
		ArrayList<ArrayList<PrimsPair>> adjList = new ArrayList<>();

		for(int i=0;i<V;i++) {
			adjList.add(new ArrayList<>());
		}

		for(int[] edge : edges ) {
			int u = edge[0];
			int v = edge[1];
			int wt = edge[2];

			adjList.get(u).add(new PrimsPair(wt, v));
			adjList.get(v).add(new PrimsPair(wt, u));
		}

		return adjList;
	}

	public static int spanningTree(int V, int E, int edges[][]){
		boolean[] visited = new boolean[V];
		PriorityQueue<PrimsTuple> minHeap = new PriorityQueue<>((a,b)-> a.weight - b.weight);
		//parent is required if want to print the MST edges
		ArrayList<ArrayList<Integer>> mst = new ArrayList<>();
		int mstSum = 0;

		minHeap.add(new PrimsTuple(0, 0, -1));
		ArrayList<ArrayList<PrimsPair>> adjList = getAdjacencyList(V,edges);

		while( !minHeap.isEmpty() ) {
			PrimsTuple topEl = minHeap.poll();
			int parent = topEl.parent;
			int node = topEl.node;
			int weight = topEl.weight;

			if ( visited[node] )    continue;

			mstSum = mstSum + weight;
			ArrayList<Integer> ds = new ArrayList<>();
			ds.add(parent);
			ds.add(node);
			mst.add(ds);
			visited[node] = true;

			for( PrimsPair neighbour : adjList.get(node) ) {
				int newNode = neighbour.node;
				int newWeight = neighbour.weight;

				if ( !visited[newNode] ) {
					minHeap.add(new PrimsTuple(newWeight, newNode, node));
				}

			}



		}
		return mstSum;
	}
}
