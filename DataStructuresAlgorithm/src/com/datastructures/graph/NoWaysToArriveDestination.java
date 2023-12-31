package com.datastructures.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class NoWaysToArriveDestination {
	static class DestTimePair{
		int node;
		long time;
		DestTimePair(int node, long time){
			this.time = time;
			this.node = node;
		}
	}

	public ArrayList<ArrayList<DestTimePair>> createGraph(int n,int[][] roads){
		ArrayList<ArrayList<DestTimePair>> graph = new ArrayList<>();
		for(int i = 0; i< n; i++){
			graph.add(new ArrayList<DestTimePair>());
		}

		for(int [] road : roads ){
			int u = road[0];
			int v = road[1];
			int time = road[2];

			graph.get(u).add( new DestTimePair(v,time));
			graph.get(v).add( new DestTimePair(u,time));
		}
		return graph;
	}

	public int countPaths(int n, int[][] roads) {

		long MOD = 1000000007;
		ArrayList<ArrayList<DestTimePair>> graph = createGraph(n,roads);

		PriorityQueue<DestTimePair> priorityQueue = new PriorityQueue<>( (a,b)-> (int)(a.time - b.time));

		long[] time = new long[n];
		Arrays.fill( time,Long.MAX_VALUE);

		long[] ways = new long[n];
		Arrays.fill( ways, 0 );

		// setting time of src = 1
		time[0] = 0;

		// setting ways of src = 1;
		ways[0] = 1;

		priorityQueue.add( new DestTimePair(0,0));

		while( !priorityQueue.isEmpty() ){

			DestTimePair topEl = priorityQueue.poll();
			int currNode = topEl.node;
			long currTime = topEl.time;

			for( DestTimePair neighbour : graph.get( currNode ) ){
				long newTime = currTime + neighbour.time;

				if ( newTime < time[ neighbour.node ] ){
					//update time, ways and push
					time [ neighbour.node ] = newTime;
					ways [ neighbour.node ] = ways [ currNode ];
					priorityQueue.add( new DestTimePair( neighbour.node , newTime));

				}else if( newTime == time[neighbour.node] ){

					ways [ neighbour.node ] = ( ways [ neighbour.node ] + ways[currNode] ) % MOD;
				}
			}

		}
		return (int)ways[n-1];
	}
}


