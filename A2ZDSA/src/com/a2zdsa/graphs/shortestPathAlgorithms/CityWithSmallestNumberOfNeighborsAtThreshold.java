package com.a2zdsa.graphs.shortestPathAlgorithms;

import java.util.Arrays;

public class CityWithSmallestNumberOfNeighborsAtThreshold {
	public int findTheCity(int n, int[][] edges, int distanceThreshold) { 
		int[][] grid = new int[n][n];

		for( int[] row : grid ) {
			Arrays.fill(row, 100000000);
		}

		for( int[] edge : edges ) {
			int from = edge[0];
			int to = edge[1];
			int weight = edge[2];

			grid[from][to] = weight;
			grid[to][from] = weight;

		}
		for( int k = 0; k < n; k++ ) {
			for( int i=0; i<n; i++ ) {
				grid[i][i] = 0;
				for( int j = 0; j< n; j++) {
					//due to wrap around
					grid[i][j] = Math.min(grid[i][j], grid[i][k]+grid[k][j]);
				}
			}
		}

		int city = 0;
		int totalNeighbours = Integer.MAX_VALUE;
		for( int i=0;i<n;i++) {
			int neighbour = 0;
			for(int j = 0; j<n; j++) {
				if( grid[i][j] <= distanceThreshold ) {
					neighbour++;
				}
			}
			if( totalNeighbours >= neighbour ) {
				totalNeighbours = neighbour;
				city = i ;
			}
		}
		return city;
	}

}
