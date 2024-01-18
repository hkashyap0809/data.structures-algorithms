package com.a2zdsa.graphs.learning;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {

	public void performBFS(int src,int v, ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> bfsList, boolean[] visited) {
		Queue<Integer> queue = new LinkedList<>();

		queue.add(src);
		visited[src] = true;

		while( !queue.isEmpty() ) {
			Integer top = queue.poll();
			bfsList.add(top);

			for( Integer neighbour : adj.get(top)) {
				if( !visited[neighbour] )	{
					queue.add(neighbour);
					visited[neighbour] = true;
				}
			}
		}
	}
	public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
		ArrayList<Integer> bfsList = new ArrayList<Integer>();
		boolean[] visited = new boolean[V];
		Arrays.fill(visited, false);

		performBFS(0,V,adj,bfsList,visited);


		return bfsList;
	}

}
