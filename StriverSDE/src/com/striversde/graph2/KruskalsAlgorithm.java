package com.striversde.graph2;

import java.util.ArrayList;
import java.util.Collections;
class Tuple{
	int u;
	int v;
	int wt;
	Tuple(int u, int v, int wt){
		this.u = u;
		this.v = v;
		this.wt = wt;
	}
}
public class KruskalsAlgorithm {
	public static int kruskalMST(int n, int m, ArrayList<ArrayList<Integer>> graph) {
		DisjointSet disjointSet = new DisjointSet(n);
		int weight = 0;
		ArrayList<Tuple> edges = new ArrayList<>();
		for ( ArrayList<Integer> edge : graph ) {
			edges.add(new Tuple(edge.get(0),edge.get(1), edge.get(2)));
		}
		Collections.sort(edges,(a,b)-> a.wt-b.wt);
		for ( Tuple edge : edges ) {
			int u = edge.u;
			int v = edge.v;
			int wt = edge.wt;
			if ( disjointSet.findParent(u) != disjointSet.findParent(v)) {
				disjointSet.unionByRank(u, v);
				weight+=wt;
			}
		}
		return weight;
        
    }
}
