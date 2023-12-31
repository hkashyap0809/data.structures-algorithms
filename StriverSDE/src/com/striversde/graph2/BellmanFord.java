package com.striversde.graph2;

import java.util.ArrayList;
import java.util.Arrays;

public class BellmanFord {
	static int[] bellman_ford(int V, ArrayList<ArrayList<Integer>> edges, int S) {
        int[] distance = new int[V];
        
        Arrays.fill(distance,100000000);
		distance[S] = 0;
		
		for( int i=1; i<=V-1; i++ ) {

			for(ArrayList<Integer> edge : edges ) {
				int u = edge.get(0);
				int v = edge.get(1);
				int wt = edge.get(2);
				
				if ( distance[u] + wt < distance[v] ) {
					distance[v] = distance[u] + wt;
				}
			}
      
		}
		for(ArrayList<Integer> edge : edges ) {
				int u = edge.get(0);
				int v = edge.get(1);
				int wt = edge.get(2);
				
				if ( distance[u] + wt < distance[v] ) {
				    int[] arr = {-1};
					return arr;
				}
			}
		
		return distance;
    }
}
