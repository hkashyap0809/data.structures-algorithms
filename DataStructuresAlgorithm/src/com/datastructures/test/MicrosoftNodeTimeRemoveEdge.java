package com.datastructures.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class MicrosoftNodeTimeRemoveEdge {
	static class DegreeNode{
		int degree;
		int node;
		DegreeNode(int degree, int node ){
			this.degree = degree;
			this.node = node;
		}
	}
	
	
	static int solution( int N, int[] A, int[] B) {
		
		int edges = A.length;

		
		List<List<Integer>> graph = new ArrayList<>();
		for( int i = 0; i < N; i++) {
			graph.add( new ArrayList<>() );
		}
		
		int[] degree = new int[N];
		Arrays.fill(degree,0);
		
		for( int i = 0; i < edges; i++ ) {
			int u = A[i];
			int v = B[i];
			
			graph.get(u).add(v);
			graph.get(v).add(u);
			
			degree[u]++;
			degree[v]++;
		}
		
		Queue<DegreeNode> queue = new LinkedList<>();
		
		boolean[] visited = new boolean[N];
		Arrays.fill(visited, false);
		
		for(int i =0; i< N; i++) {
			if( degree[i] <=1 ) {
				queue.add( new DegreeNode(degree[i],i));
				visited[i] = true;
			}
		}
		
		int time = 0;
		
		
		while( !queue.isEmpty() ) {
			
			int queueSize = queue.size();
			for( int i = 0; i<queueSize; i++ ) {
				DegreeNode topEl = queue.poll();
				int node = topEl.node;
				
				
				for( Integer neighbour : graph.get(node) ) {
					degree[neighbour]--;
					if( degree[neighbour] == 1 && !visited[neighbour]) {
						queue.add(new DegreeNode(1,neighbour));
						visited[neighbour] = true;
					}
				}
			}
			time++;
		}
		return time;	
	}
	public static void main(String[] args) {
//		int N = 7;
//		int[] A = {0,1,2,1,4,4};
//		int[] B = {1,2,0,4,5,6};
		//2
		
//		int N = 4;
//		int[] A = {0,1,2,3};
//		int[] B = {1,2,3,0};
		//0
		
		int N = 4;
		int[] A = {0,1,2};
		int[] B = {1,2,0};
		//1
		
		System.out.println(solution(N,A,B));
	}

}
