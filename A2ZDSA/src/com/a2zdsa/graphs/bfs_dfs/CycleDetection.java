package com.a2zdsa.graphs.bfs_dfs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CycleDetection {
	
	
	static class NodeParent{
		int node;
		int parent;
		NodeParent(int node, int parent){
			this.node = node;
			this.parent = parent;
		}
	}
	boolean detectCycleBFS(int V, List<List<Integer>> graph) {
		
		boolean[] visited = new boolean[V];
		Arrays.fill(visited, false);
		
		for( int i =0; i<V;i++) {
			if( !visited[i] && detectCycleBFS(i,-1,visited,graph) == true)	return true;
		}
		return false;
	}
	
	
	private boolean detectCycleBFS(int src, int parent, boolean[] visited, List<List<Integer>> graph) {
		Queue<NodeParent> queue = new LinkedList<>();
		visited[src] = true;
		queue.add(new NodeParent(src,parent));
		
		while( !queue.isEmpty() ) {
			NodeParent topEl = queue.poll();
			for( Integer neighbour : graph.get(topEl.node) ) {
				if( !visited[neighbour] ) {
					visited[neighbour] = true;
					queue.add(new NodeParent(neighbour,topEl.node));
				}else if( neighbour != topEl.parent ) {
					return true;
				}
			}
		}
		return false;
	}


	boolean detectCycleDFS(int V, List<List<Integer>> graph) {
		boolean[] visited = new boolean[V];
		Arrays.fill(visited, false);
		
		for( int i =0; i<V; i++) {
			if( !visited[i] && detectCycleDFS(i,-1,visited,graph) == true ) 	return true;
		}
		return false;
	}
	private boolean detectCycleDFS(int src, int parent, boolean[] visited, List<List<Integer>> graph) {
		visited[src] = true;
		for( Integer neighbour : graph.get(src) ) {
			if( !visited[neighbour] && neighbour != parent ) {
				if( detectCycleDFS(neighbour, src, visited, graph) == true )	return true;
			}else if( visited[neighbour] && neighbour != parent ){
				return true;
			}
		}
		return false;
	}
	boolean detectCycle(int V, List<List<Integer>> adj) {
//		return detectCycleDFS(V, adj);
		return detectCycleBFS(V, adj);
	}

}
