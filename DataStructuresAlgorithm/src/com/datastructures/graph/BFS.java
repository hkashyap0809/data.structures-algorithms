package com.datastructures.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

//https://practice.geeksforgeeks.org/problems/bfs-traversal-of-graph/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=bfs_of_graph
public class BFS {
	public void startBFS(int src,int V, ArrayList<ArrayList<Integer>> adj, boolean[] visited,ArrayList<Integer> bfs) {
		Queue<Integer> queue =new LinkedList<>();
		queue.add(src);
		visited[src]=true;
		while(!queue.isEmpty()) {
			int node = queue.poll();
			bfs.add(node);
			for(int adjNode : adj.get(node)) {
				if(!visited[adjNode]) {
					queue.add(adjNode);
					visited[adjNode]=true;
				}
			}
		}	
	}
	
	public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
		boolean[] visited = new boolean[V];
		Arrays.fill(visited, false);		
		
		ArrayList<Integer> bfs = new ArrayList<>();

		startBFS(0,V,adj,visited,bfs);
		
		return bfs;
    }

}
