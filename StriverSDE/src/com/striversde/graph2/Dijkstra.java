package com.striversde.graph2;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.TreeSet;

class DijkstraPair{
	Integer dist;
	Integer node;
	DijkstraPair(Integer dist, Integer node) {
		this.dist = dist;
		this.node = node;
	}
}

public class Dijkstra {
	private static ArrayList<ArrayList<DijkstraPair>> giveAdjList(ArrayList< ArrayList < Integer > > vec, int vertices, int edges){
		ArrayList<ArrayList<DijkstraPair>> adjList = new ArrayList<>();
		for(int i=0;i<vertices;i++) {
			adjList.add( new ArrayList<>());
		}
		
		for(ArrayList<Integer> edge : vec) {
			int u = edge.get(0);
			int v = edge.get(1);
			int w = edge.get(2);
			
			adjList.get(u).add(new DijkstraPair(w,v));
			adjList.get(v).add(new DijkstraPair(w,u));
		}
		return adjList;
	}
	
	//Priority Queue Implementation
	public static ArrayList<Integer> dijkstraPriorityQueue(ArrayList< ArrayList < Integer > > vec, int vertices, int edges, int source){
		ArrayList<Integer> distance = new ArrayList<>();
		for(int i=0;i<vertices; i++) {
			distance.add(Integer.MAX_VALUE);
		}
		distance.set(source,0);

		PriorityQueue<DijkstraPair>minHeap = new PriorityQueue<>((a,b)->a.dist - b.dist);
		minHeap.add(new DijkstraPair(0, source));
		ArrayList<ArrayList<DijkstraPair>> adjList = giveAdjList(vec,vertices,edges);
		
		while( !minHeap.isEmpty() ) {
			DijkstraPair topEl = minHeap.poll();
			int node = topEl.node;
			int dist = topEl.dist;
			
			for( DijkstraPair neighbour : adjList.get(node) ) {
				int neighbourNode = neighbour.node;
				int neighbourDist = neighbour.dist;
				
				if ( dist + neighbourDist < distance.get(neighbourNode) ) {
					distance.set(neighbourNode, dist + neighbourDist);
					minHeap.add(new DijkstraPair(dist + neighbourDist, neighbourNode));
				}
			}
		}
		
		return distance;
	}
	
	//Set Implementation
	public static ArrayList<Integer> dijkstra(ArrayList< ArrayList < Integer > > vec, int vertices, int edges, int source){
		ArrayList<Integer> distance = new ArrayList<>();
		for(int i=0;i<vertices; i++) {
			distance.add(Integer.MAX_VALUE);
		}
		distance.set(source,0);

		TreeSet<DijkstraPair> set = new TreeSet<>((a,b)-> a.dist - b.dist);
		set.add(new DijkstraPair(0, source));
		
		ArrayList<ArrayList<DijkstraPair>> adjList = giveAdjList(vec,vertices,edges);
		
		while( !set.isEmpty() ) {
			DijkstraPair topEl = set.pollFirst();
			int node = topEl.node;
			int dist = topEl.dist;
			
			for( DijkstraPair neighbour : adjList.get(node) ) {
				int neighbourNode = neighbour.node;
				int neighbourDist = neighbour.dist;
				
				if ( dist + neighbourDist < distance.get(neighbourNode) ) {
					distance.set(neighbourNode, dist + neighbourDist);
					set.add(new DijkstraPair(dist + neighbourDist, neighbourNode));
				}
			}
		}
		
		return distance;
	}
	

}
