package com.datastructures.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BipartiteBFS {
	public static boolean isGraphBipartiteBFS(int src, ArrayList<ArrayList<Integer>> edges, int[] color){

		Queue<Integer> queue = new LinkedList<>();
		queue.add(src);
		color[src] = 0 ;

		while( !queue.isEmpty() ){

			int node = queue.poll();
			for ( int adjNode = 0; adjNode < edges.size(); adjNode++){
				int adjNodeVal = edges.get(node).get(adjNode);
				if ( adjNodeVal == 1 ){
					if( color[adjNode] == -1 ){
						queue.add(adjNode);
						color[adjNode] = 1 - color[node];
					}else if( color[adjNode] == color[node] ){
						return false;
					}
				}
			}
		}
		return true;
	}
	public static boolean isGraphBirpatite(ArrayList<ArrayList<Integer>> edges) {

		int vertices = edges.size();
		int[] color = new int[vertices];
		Arrays.fill(color,-1);
		for(int i=0; i<vertices; i++){
			if ( color[i] == -1 && isGraphBipartiteBFS(i,edges,color)==false){
				return false;
			}
		}
		return true;
	}
}
