package com.datastructures.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class CourseSchedule2 {
	public int[] findOrder(int numCourses, int[][] prerequisites) {
		ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
		int[] indegree = new int[numCourses];

		for(int i=0;i<numCourses;i++)   adjList.add(new ArrayList<>());


		for(int[] prerequisite : prerequisites ){
			adjList.get(prerequisite[1]).add(prerequisite[0]);
			indegree[prerequisite[0]]++;
		}

		Queue<Integer> queue = new LinkedList<>();
		for(int i=0;i<indegree.length;i++){
			if(indegree[i]==0)  queue.add(i);
		}
		ArrayList<Integer> topoOrder = new ArrayList<Integer>();


		while( !queue.isEmpty() ){
			int node = queue.poll();
			for(Integer neighbour : adjList.get(node)){
				indegree[neighbour]--;
				if( indegree[neighbour] == 0 )  queue.add(neighbour);
			}
			topoOrder.add(node);
		}


		if( topoOrder.size() != numCourses) return new int[0];

		int[] res = new int[numCourses];
		for(int i=0;i<res.length;i++){
			res[i] = topoOrder.get(i);
		}
		return res;
	}

}
