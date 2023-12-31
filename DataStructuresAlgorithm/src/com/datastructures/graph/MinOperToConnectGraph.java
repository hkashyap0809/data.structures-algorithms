package com.datastructures.graph;

public class MinOperToConnectGraph {

	public int minOperationToConnectGraph(int n, int[][] edges) {
		DisjointSet disjointSet = new DisjointSet(n);
		int extraEdge = 0;
		int noComponents=0;

		for( int[] edge : edges) {
			int u = edge[0];
			int v = edge[1];

			if ( disjointSet.findParent(u) != disjointSet.findParent(v) ) { 
				disjointSet.unionByRank(u, v);
			}else {
				extraEdge++;
			}
		}

		for( int i=0;i<n;i++) {
			if ( disjointSet.parent[i] == i )	noComponents++;
		}

		if ( extraEdge >=  noComponents - 1 ) 
			return noComponents - 1;
		else
			return -1;

	}
}
