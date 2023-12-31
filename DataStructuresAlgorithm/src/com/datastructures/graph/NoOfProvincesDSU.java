package com.datastructures.graph;

import java.util.ArrayList;

public class NoOfProvincesDSU{

	static int numProvinces(ArrayList<ArrayList<Integer>> adj, int V) {
		DisjointSet disjointSet = new DisjointSet(V);

		for(int i=0;i<V;i++) {
			for(int j=0;j<V;j++) {
				if ( adj.get(i).get(j) == 1 ) {
					disjointSet.unionByRank(i, j);
				}
			}
		}

		int provinces = 0;
		for(int i=0;i<=V;i++) {
			if ( disjointSet.parent[i] == i ) {
				provinces++;
			}
		}
		return provinces-1;
	}

}
