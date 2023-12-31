package com.a2zdsa.graphs.shortestPathAlgorithms;

import java.util.ArrayList;
import java.util.Arrays;

public class FloydWarshall {
	static int floydWarshall(int n, int m, int src, int dest, ArrayList<ArrayList<Integer>> edges) {
		int[][] grid = new int[n][n];
		for( int[] row : grid ){
			Arrays.fill(row,10000000);
		}

		for( ArrayList<Integer> edge : edges ){
			int from = edge.get(0)-1;
			int to = edge.get(1)-1;
			int weight = edge.get(2);

			grid[from][to] = weight;
		}

		for( int k = 0; k< n ; k++ ){
			for( int i = 0; i< n; i++ ){
				grid[i][i] = 0;
				for( int j = 0; j< n; j++){
					grid[i][j] = Math.min( grid[i][j], grid[i][k] + grid[k][j]);
				}
			}
		}

		return grid[src-1][dest-1] >= 1000000 ? 1000000000 : grid[src-1][dest-1];

	}
}
