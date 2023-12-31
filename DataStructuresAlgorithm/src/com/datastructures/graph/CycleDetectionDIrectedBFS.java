package com.datastructures.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class CycleDetectionDIrectedBFS {

	public static void topologicalSortBFS(int[] inDegree,ArrayList<ArrayList<Integer>> adjList, ArrayList<Integer> result) {

		Queue<Integer> queue = new LinkedList<>();

		for(int i=1;i<inDegree.length;i++) {
			if(inDegree[i]==0)	queue.add(i);
		}

		while(!queue.isEmpty()) {
			int node = queue.poll();
			result.add(node);

			for( Integer neighbour : adjList.get(node)) {
				inDegree[neighbour]--;
				if ( inDegree[neighbour] == 0 ) {
					queue.add(neighbour);
				}
			}
		}
	}
	public static boolean detectCycleInDirectedGraph(int n, ArrayList < ArrayList < Integer >> edges) {

		int[] inDegree = new int[n+1];
		ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
		for(int i=0;i<=n;i++) {
			adjList.add(new ArrayList<>());
		}

		for(int i=0;i<edges.size();i++) {
			int node = edges.get(i).get(1);
			inDegree[node]++;

			int u = edges.get(i).get(0);
			int v = edges.get(i).get(1);

			adjList.get(u).add(v);
		}

		ArrayList<Integer> result = new ArrayList<>();
		topologicalSortBFS(inDegree,adjList,result);
		if (result.size() == n )	return false;
		else	return true;

	}
}
