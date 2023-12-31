package com.datastructures.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BridgesInGraph {

	List<List<Integer>> getAdjList(int vertices, List<List<Integer>> connections){
		List<List<Integer>> adjList = new ArrayList<>();
		for(int i=0;i<vertices;i++) adjList.add( new ArrayList<>());

		for( List<Integer> connection : connections ){
			adjList.get(connection.get(0)).add(connection.get(1));
			adjList.get(connection.get(1)).add(connection.get(0));
		}
		return adjList;
	}
	public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {

		List<List<Integer>> adjList = getAdjList(n,connections);
		List<List<Integer>> bridges = new ArrayList<>();

		int[] insertTime = new int[n];
		int[] lowestTime = new int[n];
		boolean[] visited = new boolean[n];
		Arrays.fill(visited,false);
		int time = 1;
		int src = 0;
		int parent = -1;
		startDFS(src,time,parent,adjList,insertTime,lowestTime,visited,bridges);
		return bridges;

	}
	
	public void startDFS(int src,int time,int parent, List<List<Integer>> adjList, int[] insertTime, int[] lowestTime,boolean[] visited, List<List<Integer>> bridges){
		visited[src] = true;
		insertTime[src] = time;
		lowestTime[src] = time;
		time++;
		for( Integer neighbour : adjList.get(src) ){
			//if parent and neighbour are same  - continue
			if( parent == neighbour )  continue;

			if( !visited[ neighbour ] ){
				//not visited
				startDFS(neighbour,time,src,adjList,insertTime,lowestTime,visited,bridges);
				lowestTime[src] = Math.min(lowestTime[src], lowestTime[neighbour]);

				//check for bridge between src - neighbour
				if( insertTime[src] < lowestTime[neighbour] ){
					bridges.add(List.of(neighbour,src));
				}
			}
			else{
				lowestTime[src] = Math.min(lowestTime[src], lowestTime[neighbour]);   
			}   
		}
	}
	
}


