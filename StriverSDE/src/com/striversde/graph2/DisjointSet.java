package com.striversde.graph2;

import java.util.Arrays;

class DisjointSet {

	int[] rank;
	int[] parent;
	int[] size;
	
	DisjointSet(int n){
		rank = new int[n+1];
		parent = new int[n+1];
		size = new int[n+1];

		Arrays.fill(rank, 1);
		Arrays.fill(size, 1);
		for(int i=0;i<=n;i++) {
			parent[i] = i;
		}
	}

	public void unionByRank(int u, int v) {
		int up_u = findParent(u);
		int up_v = findParent(v);

		if ( up_u == up_v )	return;

		if ( rank[up_u] < rank[up_v]) {
			parent[up_u] = up_v;

		}else if ( rank[up_v] < rank[up_u]) {
			parent[up_v] = up_u;
		}else {
			parent[up_u] = up_v;
			rank[up_v] = rank[up_v]+1;
		}
	}

	public void unionBySize(int u, int v) {
		int up_u = findParent(u);
		int up_v = findParent(v);

		if ( up_u == up_v )	return;

		if ( size[up_u] < size[up_v]) {
			parent[up_u] = up_v;
			size[up_v]+=size[up_u];

		}else {
			parent[up_v] = up_u;
			size[up_u]+=size[up_v];
		}

	}

	public int findParent(int node) {

		if (parent[node] == node) {
			return node;
		}
		else { 
			parent[node] = findParent(parent[node]);
			return parent[node];
		}

	}

}
