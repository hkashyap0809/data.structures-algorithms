package com.a2zdsa.graphs.bfs_dfs;

import java.util.Arrays;

public class NumberOfProvinces {
	static class DisjointSet {

		int[] rank;
		int[] parent;
		int[] size;
		DisjointSet(int n){
			rank = new int[n+1];
			parent = new int[n+1];
			size = new int[n+1];

			Arrays.fill(rank,1);
			Arrays.fill(size, 1);

			for(int i=0; i<=n ; i++) {
				parent[i]=i;
			}
		}

		public int findParent(int node) {
			if (node == parent[node]) {
				return node;
			}
			parent[node] = findParent(parent[node]);
			return parent[node];
		}

		void unionByRank(int nodeU, int nodeV) {
			int up_u = findParent(nodeU);
			int up_v = findParent(nodeV);

			if (up_u == up_v) 	return;

			if (rank[up_u] < rank[up_v])
				parent[up_u]=up_v;

			else if (rank[up_u] > rank[up_v])
				parent[up_v]=up_u;
			else {
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

	}
	public int findCircleNum(int[][] isConnected) {
		int n = isConnected.length;
		DisjointSet disjointSet = new DisjointSet(n);

		for( int i=0; i < n; i++ ){
			for( int j = 0 ; j < i ; j++ ){
				if( isConnected[i][j] == 1 ){
					disjointSet.unionByRank(i,j);
				}
			}
		}

		int provinces = 0;
		for( int i =0; i<n;i++){
			if( disjointSet.findParent(i) == i ){
				provinces++;
			}
		}
		return provinces;

	}

}
