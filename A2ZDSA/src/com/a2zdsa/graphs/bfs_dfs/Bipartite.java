package com.a2zdsa.graphs.bfs_dfs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Bipartite {


	public boolean isBipartiteBFS(int[][] graph) {
		int V = graph.length;
		int[] color = new int[V];
		Arrays.fill(color,-1);

		for( int i =0; i<V; i++ ) {
			if( color[i] == -1 && isBipartiteBFS(i,0,graph,color) == false )	return false;
		}
		return true;
	}

	private boolean isBipartiteBFS(int src, int col, int[][] graph, int[] color) {
		Queue<Integer> queue = new LinkedList<>();
		color[src] = col;
		queue.add(src);
		while( !queue.isEmpty() ) {
			int node = queue.poll();	
			for( int neighbour : graph[node] ) {
				if( color[neighbour] == -1 ) {
					color[neighbour] = 1-color[node];
					queue.add(neighbour);
				}else if(color[neighbour] == color[node])	return false;
			}
		}
		return true;
	}

	public boolean isBipartiteDFS(int[][] graph) {

		int V = graph.length;
		int[] color = new int[V];
		Arrays.fill(color, -1);

		for( int i =0; i< V; i++ ) {
			if( color[i] == -1 && isBipartiteDFS(i,0,V,graph,color) ==  false )	return false;	
		}
		return true;

	}

	private boolean isBipartiteDFS(int src, int col, int V, int[][] graph, int[] color) {
		color[src] = col;

		for( int neighbour : graph[src] ) {
			if( color[neighbour] == -1 && isBipartiteDFS(neighbour,1-col,V,graph,color) == false) {
				return false;
			}else if( color[neighbour] == col ) {
				return false;
			}
		}
		return true;
	}

	public boolean isBipartite(int[][] graph) {
		//		return isBipartiteDFS(graph);
		return isBipartiteBFS(graph);
	}

}
