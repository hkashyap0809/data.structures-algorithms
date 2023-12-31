package com.datastructures.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class TopologicalSortBFS {
	public static ArrayList<ArrayList<Integer>> adjacencyList(ArrayList<ArrayList<Integer>> edges, int n){
		ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
		for(int i=0;i<n;i++) {
			adjList.add(new ArrayList<Integer>());
		}
		
		for(int i=0;i<edges.size();i++) {
			int u = edges.get(i).get(0);
			int v = edges.get(i).get(1);
			
			adjList.get(u).add(v);
		}
		
		return adjList;
	}
	
	public static void topologicalSortBFS(int[] inDegree,ArrayList<Integer> result,ArrayList<ArrayList<Integer>> adjList) {
		Queue<Integer> queue = new LinkedList<>();
		
		for(int i=0; i<inDegree.length;i++) {
			if(inDegree[i] == 0) {
				queue.add(i);
			}
		}
		
		while(!queue.isEmpty()) {
			int node = queue.poll();
			
			for( Integer neighbour : adjList.get(node)) {
				inDegree[neighbour]--;
				if(inDegree[neighbour] == 0)
					queue.add(neighbour);
			}
			result.add(node);
		}
		
	}
	public static ArrayList<Integer> topologicalSort(ArrayList<ArrayList<Integer>> edges, int v, int e) {
		
		int[] inDegree = new int[v];
		ArrayList<Integer> result = new ArrayList<>();
		ArrayList<ArrayList<Integer>> adjList = adjacencyList(edges, v);
		for(int i=0;i<edges.size(); i++) {
			int node = edges.get(i).get(1);
			inDegree[node] ++;
		}
		
		topologicalSortBFS(inDegree,result,adjList);
		return result;
//        ArrayList<Integer> ans = new ArrayList<>();
//        for(int i = result.size() -1 ; i>=0; i--)
//            ans.add(result.get(i));
//		return ans;
	}
}
