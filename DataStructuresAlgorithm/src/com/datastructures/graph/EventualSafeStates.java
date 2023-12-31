package com.datastructures.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class EventualSafeStates {
	
	//DFS solution
	public boolean startDFS(int src, boolean[] visited, boolean[] pathVisited,boolean[] safeNodes,int[][] graph){
        visited[src] = true;
        pathVisited[src] = true;
        safeNodes[src] = false;

        for(int neighbour : graph[src]){
            if( !visited[neighbour] ){
                if( startDFS(neighbour,visited,pathVisited,safeNodes,graph) == true ){
                    //cycle present - cannot be safe node
                    safeNodes[src] = false;
                    return true;
                }
            }else if( pathVisited[neighbour]){
                //cycle present - cannot be safe node
                safeNodes[src] = false;
                return true;
            }
        }
        //DFS completes successfully -> safe node
        safeNodes[src] = true;
        pathVisited[src] = false;
        return false;
    }
    public List<Integer> eventualSafeNodesDFS(int[][] graph) {
        int vertices = graph.length;
        boolean[] visited = new boolean[vertices];
        boolean[] pathVisited = new boolean[vertices];
        boolean[] safeNodes = new boolean[vertices];
        List<Integer> result = new ArrayList<>();


        for(int i=0;i<vertices; i++){
            if( !visited[i] )  startDFS(i,visited,pathVisited,safeNodes,graph);
        }
        for(int i=0;i<vertices;i++){
            if( safeNodes[i] )  result.add(i);
        }
        return result;
    }
	
	//BFS - Topological Sort Solution | Kahn's Algorithm
	public List<Integer> eventualSafeNodesBFS(int[][] graph) {
		int vertices = graph.length;
		int[] indegree = new int[vertices];
		ArrayList<ArrayList<Integer>> adjList = reverseGraph(graph,vertices,indegree);


		Queue<Integer> queue = new LinkedList<>();
		List<Integer> safeNodes = new ArrayList<>();

		for(int i=0;i<indegree.length;i++) {
			if(indegree[i]==0)queue.add(i);
		}

		while( !queue.isEmpty() ) {
			int node = queue.poll();

			for(Integer neighbour : adjList.get(node)) {
				indegree[neighbour]--;
				if( indegree[neighbour]==0) {
					queue.add(neighbour);
				}
			}
			safeNodes.add(node);

		}
		Collections.sort(safeNodes);
		return safeNodes;
	}

	private ArrayList<ArrayList<Integer>> reverseGraph(int[][] graph, int vertices,int[] indegree) {
		ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
		for(int i=0;i<vertices;i++) adjList.add(new ArrayList<>());

		for(int i=0;i<graph.length;i++) {
			for(int j=0;j<graph[i].length;j++) {
				int u = i;
				int v = graph[i][j];
				adjList.get(v).add(u);
				indegree[u]++;
			}
		}
		return adjList;
	}


}
