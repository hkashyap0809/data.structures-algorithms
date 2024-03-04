package com.samsung;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class SpaceshipAndWormholes {

	static class Point{
		int x;
		int y;
		Point(int x, int y){
			this.x = x;
			this.y = y;
		}
	}	
	public static void main(String[] args){
		try (Scanner sc = new Scanner(System.in)) {
			int T = sc.nextInt();
			for(int a =0; a<T;a++) {

				ArrayList<Point> vertices = new ArrayList<>();

				
				int N = sc.nextInt();

				int srcX = sc.nextInt();
				int srcY = sc.nextInt();

				int destX = sc.nextInt();
				int destY = sc.nextInt();



				int nVertices = N*2+2;
				int[][] adjMatrix = new int[nVertices][nVertices];
				for( int[] row : adjMatrix )	Arrays.fill(row, -1);

				vertices.add( new Point( srcX,srcY));


				int graphVertexIndex = 1;
				for( int i = 0 ; i<N;i++ ) {
					int x1 = sc.nextInt();
					int y1 = sc.nextInt();
					int x2 = sc.nextInt();
					int y2 = sc.nextInt();
					int t = sc.nextInt();


					//adding source
					vertices.add(new Point(x1,y1));

					//adding destination
					vertices.add(new Point(x2,y2));

					//initializing the distance of same wormhole
					adjMatrix[graphVertexIndex][graphVertexIndex+1] = t;
					adjMatrix[graphVertexIndex+1][graphVertexIndex] = t;

					graphVertexIndex+=2;

				}

				
				vertices.add(new Point(destX,destY));

				int minTime = getMinTime(vertices,adjMatrix);
				System.out.println(minTime);
			}
		}
	}
	private static int getMinTime(ArrayList<Point> vertices, int[][] adjMatrix ) {

		//find distance of source to all the vertices
		for( int i = 0; i < adjMatrix.length; i++ ) {
			adjMatrix[0][i] = distance(vertices.get(0), vertices.get(i));
		}

		//find distance of destination to all the vertices
		for( int i =0; i < adjMatrix.length; i++) {
			adjMatrix[ adjMatrix.length-1][i] = distance(vertices.get(adjMatrix.length-1) , vertices.get(i));
		}

		//filling up the remaining matrix

		for( int i = 0; i < adjMatrix.length; i++ ) {
			for( int j = 0; j< adjMatrix.length; j++ ) {
				if( i == j ) {
					adjMatrix[i][j] = 0;
				}else if( adjMatrix[i][j] == -1 ) {
					//only fill the unfilled cells
					if( i % 2 == 1 ) {
						//source of the wormhole
						adjMatrix[i][j] = adjMatrix[i][i+1] + distance(vertices.get(i+1), vertices.get(j));
					}else {
						//						end of the wormhole
						adjMatrix[i][j] = adjMatrix[i][i-1] + distance(vertices.get(i-1), vertices.get(j));
					}
				}
			}
		}

		//setting the distance of source and destination
		adjMatrix[0][adjMatrix.length-1] = distance(vertices.get(0), vertices.get(vertices.size()-1));
		adjMatrix[adjMatrix.length-1][0] = distance(vertices.get(0), vertices.get(vertices.size()-1));

		int nVertices = adjMatrix.length;
		ArrayList<ArrayList<DijkstraPair>> graph = getAdjacencyList(adjMatrix, nVertices);
		int minTime = Dijkstra(graph, nVertices);
		return minTime;

	}

	static class DijkstraPair{
		int time;
		int node;
		DijkstraPair(int time, int node){
			this.time = time;
			this.node = node;
		}
	}

	private static ArrayList<ArrayList<DijkstraPair>> getAdjacencyList(int[][] adjMatrix, int nVertices) {
		ArrayList<ArrayList<DijkstraPair>> graph = new ArrayList<>();
		for( int i =0; i<nVertices; i++ ) {
			graph.add( new ArrayList<>());
		}

		for( int i =0; i<nVertices; i++ ) {
			for( int j =0; j<adjMatrix[0].length;j++) {

				graph.get(i).add(new DijkstraPair(adjMatrix[i][j] , j));
			}

		}
		return graph;
	}

	private static int Dijkstra(ArrayList<ArrayList<DijkstraPair>> graph, int nVertices) {
		int[] minTime = new int[nVertices];
		Arrays.fill(minTime, Integer.MAX_VALUE);

		minTime[0] = 0;

		PriorityQueue<DijkstraPair> minHeap = new PriorityQueue<>((a,b) -> a.time - b.time);
		minHeap.add( new DijkstraPair(0,0));
		while( !minHeap.isEmpty() ) {
			DijkstraPair topEl = minHeap.poll();
			int time = topEl.time;
			int node = topEl.node;
			for( DijkstraPair neighbour : graph.get(node) ) {
				int neighbourNode = neighbour.node;
				int neighbourTime = neighbour.time;

				if( time + neighbourTime < minTime[neighbourNode] ) {
					minTime[neighbourNode] = time + neighbourTime;
					minHeap.add( new DijkstraPair( time + neighbourTime, neighbourNode ));
				}
			}
		}
		return minTime[ minTime.length - 1];
	}
	private static int distance(Point p1, Point p2) {
		return Math.abs( p2.x - p1.x) + Math.abs( p2.y-p1.y);
	}

}



/*

INP:
0 0
2
50 50 100 100 2
75 75 100 100 1
100 100

OUT:
102


INP
0 0
3
1 2 120 120 2
4 5 120 100 3
6 8 102 102 4
100 100

OUT:22


INP:
0 0
3
1 2 120 120 2
4 5 120 100 3
6 8 150 180 4
100 100


OUT : 32



 */
