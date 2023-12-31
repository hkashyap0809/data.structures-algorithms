package com.datastructures.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class UnitPair{
	int node;
	int dist;
	UnitPair(int node, int dist){
		this.node = node;
		this.dist = dist;
	}
}
public class ShortestPathUndirectedGraphUnitWeight {

	public int[] shortestPath(int[][] edgeList,int vertices,int edges ,int src) {

		int[] dist = new int[vertices];
		Arrays.fill(dist, 10000000);
		ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
		for(int i=0;i<vertices;i++)adjList.add( new ArrayList<>());

		for(int[] edge : edgeList ) {
			int u = edge[0];
			int v = edge[1];

			adjList.get(u).add(v);
			adjList.get(v).add(u);
		}	

		dist[src]=0;
		Queue<UnitPair> queue = new LinkedList<>();
		queue.add( new UnitPair(src, 0));

		while( !queue.isEmpty() ) {

			UnitPair topEl = queue.poll();
			int node = topEl.node;

			for( Integer neighbour : adjList.get(node)) {
			    
				if( dist[node] + 1 < dist[neighbour] ) {
					dist[neighbour] = dist[node] + 1;
					queue.add(new UnitPair(neighbour,dist[neighbour]));
				}
			}

		}
		
		for(int i=0;i<dist.length;i++) {
			if( dist[i] == 10000000) dist[i] = -1;
		}
		return dist;

	}
}
