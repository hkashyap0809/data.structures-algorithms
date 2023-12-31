package com.striversde.graph;

import java.util.ArrayList;
import java.util.Arrays;

public class BipartiteDFS {
	public static boolean isGraphBipartiteDFS(int src, int col, ArrayList<ArrayList<Integer>> edges, int[] color){
		int currNode = src;
		color[currNode] = col ;

		for ( int adjNode = 0; adjNode < edges.size(); adjNode++){
			int adjNodeVal = edges.get(src).get(adjNode);
			if ( adjNodeVal == 1 ){
				if( color[adjNode] == -1 ){
					if( isGraphBipartiteDFS(adjNode, 1 - col, edges, color)==false)
						return false;
				}else if( color[adjNode] == color[currNode] ){
					return false;
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
			if ( color[i] == -1 && isGraphBipartiteDFS(i,0,edges,color)==false){
				return false;
			}
		}
		return true;
	}
}
